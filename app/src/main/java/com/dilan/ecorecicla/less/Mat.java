package com.dilan.ecorecicla.less;

public class Mat<doubleprice> {

    public String name;
    public double price;   // peso del Kg
    public double weight;  // KG
    public double gain;    // PESO + KG


    public  Mat() {

        this.name = "";
        this.price = 0;
        this.weight = 0;
        this.gain = 0;

    }
    public Mat(String name, double price){
        this.name = name;
        this.price = price;


    }


    public Mat(String name, double price, double weight, double gain) {

        this.name = name;
        this.price = price;
        this.weight = weight;
        this.gain = gain;
    }

    public void calculateGain(double price) {
        this.price = price;
        this.gain = this.price * this.weight;



    }
}

