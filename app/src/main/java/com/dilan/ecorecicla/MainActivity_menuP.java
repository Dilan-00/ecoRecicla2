package com.dilan.ecorecicla;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity_menuP extends AppCompatActivity {

    Button btn_tipod;
    Button btn_registraT;
    Button btn_estadisticas;
    Button btn_concejos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_p);

        btn_tipod = (Button)findViewById(R.id.btn_tipod);

        btn_tipod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_tipod = new Intent(MainActivity_menuP.this, MainActivity_tiposR.class);
                startActivity(btn_tipod);
            }
        });

        btn_registraT = (Button)findViewById(R.id.btn_registraT);

        btn_registraT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_registraT = new Intent(MainActivity_menuP.this, MainActivity_registraR.class);
                startActivity(btn_registraT);
            }
        });


        btn_concejos = (Button) findViewById(R.id.btn_concejos);

        btn_concejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_concejos = new Intent(MainActivity_menuP.this, MainConcejosActivity.class);
                startActivity(btn_concejos);
            }
        });

    }
}
