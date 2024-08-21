package com.dilan.ecorecicla.less;

import java.text.DecimalFormat;
import android.util.Log;

import java.util.ArrayList;

public class sesione {

    public String        user;
    public String        nickname;
    public String        email;
    public String        password;
    public String        gender;
    public int           age;
    public double        totalTop;
    public sesione       m;
    ArrayList<residuosN> residuosNS;



    public sesione() {

        this.user       = "";
        this.nickname   = "";
        this.email      = "";
        this.password   = "";
        this.gender     = "";
        this.age        = 0;
        this.totalTop   = 0;
        this.residuosNS = new ArrayList<residuosN>();

    }

    public sesione(String user, String nickname, String email, String password, String gender, int age, double totalTop) {
        this.user = user;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.totalTop = totalTop;
        this.residuosNS = new ArrayList<residuosN>();
    }

    public void addReciclajeN(residuosN residuosN) {
        this.residuosNS.add(residuosN);

    }


    public void calculeTotalTop() {
        for (residuosN m : this.residuosNS) {
            this.totalTop += m.gains;

        }
    }


    public void mostrarResiduos(Mat po1, Mat cn1, Mat vo1, Mat po2, Mat vo2) {


        // Dentro del método mostrarResiduos de la clase sesione
        System.out.println((int) po1.gain); // Conver0sión a entero

        // O usando formateo
        DecimalFormat df = new DecimalFormat("#");
        System.out.println(df.format(po1.gain));


        Log.e("msg", "==========================================");
        Log.e("msg", "Reciclaje de " + this.user);
        Log.e("msg", "==========================================");


        for (residuosN m : this.residuosNS) {
            Log.e("msg", "=========================================");
            Log.e("msg", "Reciclaje" + m.dateTime);
            Log.e("msg", "=========================================");

            m.showMatsR();

        }
        this.calculeTotalTop();
        Log.e("msg", "Suma total de los residuos: " + this.totalTop);
        Log.e("msg","=============================");



    }
}

