package com.dilan.ecorecicla;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dilan.ecorecicla.less.Mat;
import com.dilan.ecorecicla.less.residuosN;

import java.util.ArrayList;

public class ReciclajeAdaper extends RecyclerView.Adapter<ReciclajeAdaper.ElViewHolder> {

        MainActivity_registraR mainActivity_registraR;
        residuosN resiclaje;


    public ReciclajeAdaper(MainActivity_registraR mainActivity_registraR, residuosN reciclaje) {

        this.mainActivity_registraR = mainActivity_registraR;

        this.resiclaje = reciclaje;


    }


    @NonNull
    @Override
    public ElViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mostrar_residuos_r, parent, false);
        return new ElViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElViewHolder holder, int position) {

        holder.materialr.setText(resiclaje.mats.get(position).name);
        holder.price.setText(resiclaje.mats.get(position).price + "");
        holder.weight.setText(resiclaje.mats.get(position).weight + "");
        holder.gain.setText(resiclaje.mats.get(position).gain + "");

        holder.price.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String value = holder.price.getText().toString(); {
                }


                if (value.length() > 0 ){
                 double newPrice = Double.parseDouble(value);
                 resiclaje.mats.get(position).calculateGain(newPrice);
                 holder.gain.setText(resiclaje.mats.get(position).gain + "");

                 resiclaje.calculateTotalGains();

                 mainActivity_registraR.total_p(resiclaje.gains + "");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        holder.weight.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String value = holder.weight.getText().toString();

                if (value.length() > 0 && ! value.trim().isEmpty()) {
                    try {
                        double newWeight = Double.parseDouble(value);

                        resiclaje.mats.get(position).weight = newWeight;

                        new Thread(() -> {
                            resiclaje.mats.get(position).calculateGain(resiclaje.mats.get(position).price);

                            // Actualizar el UI en el hilo principal
                            holder.gain.post(() -> {
                                holder.gain.setText(String.valueOf(resiclaje.mats.get(position).gain));

                                resiclaje.calculateTotalGains();
                                mainActivity_registraR.total_p.setText(resiclaje.gains + "");


                            });
                        }).start();



                    } catch (NumberFormatException e ){
                        Log.e("ReciclajeAdaper", "Error al convertir el peso", e);
                      }
                    }else {

                    resiclaje.mats.get(position).weight = 0;


                    holder.weight.post(() -> {
                        holder.weight.setText("0");
                    });

                    holder.gain.post(() -> {
                        holder.gain.setText("0");
                    });


                    double newWeight = Double.parseDouble(value);
                    resiclaje.mats.get(position).weight = newWeight;
                    resiclaje.mats.get(position).calculateGain(resiclaje.mats.get(position).price);
                    holder.weight.setText(resiclaje.mats.get(position).weight + "");

                    resiclaje.calculateTotalGains();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public int getItemCount(){return resiclaje.mats.size();}

    class ElViewHolder extends RecyclerView.ViewHolder {

        TextView materialr;
        EditText price;
        EditText weight;
        EditText gain;




        public ElViewHolder(@NonNull View item){
            super(item);

            materialr = item.findViewById(R.id.materialr);
            price     = item.findViewById(R.id.price);
            weight    = item.findViewById(R.id.weight);
            gain      = item.findViewById(R.id.gain);


        }
    }
}
