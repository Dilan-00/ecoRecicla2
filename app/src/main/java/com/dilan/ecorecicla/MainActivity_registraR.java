package com.dilan.ecorecicla;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dilan.ecorecicla.less.Mat;
import com.dilan.ecorecicla.less.residuosN;

import java.util.ArrayList;

public class MainActivity_registraR extends AppCompatActivity {

    ReciclajeAdaper adaper;
    TextView total_p;
    Button btn_almac;
    RecyclerView listt;
    ArrayList <Mat> arcem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registra_r);


        arcem = new ArrayList<Mat>();
        arcem.add(new Mat("Plastico", 1000));
        arcem.add(new Mat("Carton", 2000));
        arcem.add(new Mat("Vidrio", 3000));
        arcem.add(new Mat("Papel", 4000));


        // NEW MATERIALS

        residuosN reciclaje = new residuosN();
        reciclaje.mats = arcem;


        listt = findViewById(R.id.listt);
        btn_almac = findViewById(R.id.btn_almac);
        total_p = findViewById(R.id.total_p);
        total_p.setText("$0.00COP");


        LinearLayoutManager layaoutManager
                = new LinearLayoutManager(this);
        listt.setLayoutManager(layaoutManager);
        listt.setHasFixedSize(true);
        adaper = new ReciclajeAdaper(this, reciclaje);
        listt.setAdapter(adaper);


        btn_almac.setOnClickListener(v -> {
            reciclaje.calculateTotalGains();
            Toast.makeText(this,"Ganancia total:  " + reciclaje.gains, Toast.LENGTH_SHORT).show();

        });


    }
        public void total_p(String s){
        total_p.setText("$ " + s + " COP");



























        /*
        Mat po1 = new Mat("Plastico",1000);

        Mat cn1 = new Mat("Carton", 1000);


        Mat vo1 = new Mat("Vidrio", 1000);


        // Usurio principal:
        sesione newsesione = new sesione();
        newsesione.user = "Pepe";

        // Registro de Residuos:
        residuosN reciclajeJuly = new residuosN();

        // Contador del peso del reciclajes:
        po1.weight    = 4;
        po1.calculateGain(po1.price);

        cn1.weight =  2;
        cn1.calculateGain(500);

        vo1.weight =  3;
        vo1.calculateGain(200);

        // Calcular peso del reciclaje:
        reciclajeJuly.addMat(po1);
        reciclajeJuly.addMat(cn1);
        reciclajeJuly.addMat(vo1);

        newsesione.addReciclajeN(reciclajeJuly);



        // MES NUEVO

        // RESIDUOS DE RECICLAJE:
        Mat po2 = new Mat("Plastico",800);
        Mat vo2 = new Mat("Vidrio", 400);


        //Register del residuo
        residuosN reciclajeAgost = new residuosN();

        // Contador del peso del reciclajes:
        po2.weight =   7;
        po2.calculateGain(po2.price);


        vo2.weight = 2.5;
        vo2.calculateGain(400);

        // Calcular peso del reciclaje:
        reciclajeAgost.addMat(po2);
        reciclajeAgost.addMat(vo2);

        newsesione.addReciclajeN(reciclajeAgost);


        // Mostrar los datos en pantalla:
        newsesione.mostrarResiduos();

        // Estadisticas pantalla de mostrar:
       */











    }
}