package com.dilan.ecorecicla.less;

import android.util.Log;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class residuosN  {

    public LocalDateTime dateTime;
    public double gains;
    public ArrayList<Mat> mats;
   

    public residuosN() {

                this.dateTime = LocalDateTime.now();
                this.gains = 0;
                this.mats = new ArrayList<Mat>();
            }

    public residuosN(double gains, ArrayList<Mat> mats) {
        this.dateTime = LocalDateTime.now();
        this.gains = gains;
        this.mats = mats;

    }

    public void addMat(Mat mat) {
        this.mats.add(mat);

    }

    public void calculateTotalGains(){
        this.gains = 0;

        for (Mat mat : this.mats){
            this.gains += mat.gain;
        }
    }



    public void showMatsR() {
        for (Mat m : this.mats){
            Log.e("msg","Material:" + m.name);
            Log.e("msg","Precio:" + m.price);
            Log.e("msg","Peso: " + m.weight);
            Log.e("msg","Ganancia: " + m.gain);
            Log.e("msg","=============================");
        }


        this.calculateTotalGains();
        Log.e("msg","Ganancia total: " + this.gains);
        Log.e("msg","=============================");

    }

}

