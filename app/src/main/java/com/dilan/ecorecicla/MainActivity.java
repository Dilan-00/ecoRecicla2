 package com.dilan.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileReader;import java.io.FileWriter;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.auth.User;

 public class
MainActivity extends AppCompatActivity {

public enum cap {REQUERIDA, NO_RUQUERIDA};



     Button btn_user;
     Button btn_regisitarsee;
     EditText usuario_n;
     EditText contraseña;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         //ESTAMOS AQUI!!!

         btn_user = (Button) findViewById(R.id.btn_user); // Boton de ingreso al menu principal.
         btn_regisitarsee = (Button) findViewById(R.id.btn_regisitarsee);
         usuario_n = (EditText) findViewById(R.id.usuario_n);
         contraseña = (EditText) findViewById(R.id.contraseña);





        btn_user.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, MainActivity_menuP.class);

            boolean userValido = valied.valiedUser(usuario_n,"usuario",3,30,cap.REQUERIDA,this);
            boolean  contraValido = valied.valiedcontraseña(contraseña,"contraseña",6,20,cap.REQUERIDA,this);

            if(userValido && contraValido){

                startActivity(intent);
            }
            
                });




        btn_regisitarsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_regisitarsee = new Intent(MainActivity.this,MainActivity_registersed.class);
                startActivity(btn_regisitarsee);
            }
        });


     }

 }


