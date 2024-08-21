package com.dilan.ecorecicla;

import static com.dilan.ecorecicla.valied.valiedGmail;
import static com.dilan.ecorecicla.valied.valiedNombre;
import static com.dilan.ecorecicla.valied.valiedPassword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity_registersed extends AppCompatActivity {

    Button btn_user;
    Button btn_regisitarsee;
    Button btn_estrada;
    EditText gmail;
    EditText usuario_r;
    EditText contraPP;
    EditText confirma_contraseña;




    public enum cap {REQUERIDA, NO_RUQUERIDA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_registersed);


        btn_regisitarsee = (Button) findViewById(R.id.btn_regisitarsee);
        btn_estrada = (Button) findViewById(R.id.btn_estrada);
        gmail        = (EditText)findViewById(R.id.gmail);
        usuario_r    = (EditText)findViewById(R.id.usuario_r);
        contraPP   = (EditText)findViewById(R.id.contraPP);
        confirma_contraseña = (EditText)findViewById(R.id.confirma_contraseña);


        btn_estrada.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity_registersed.this, MainActivity_menuP.class);

            boolean nombreValido = valied.valiedNombre(usuario_r,  "usuario nuevo", 3,  30, cap.REQUERIDA,this);
            boolean gmailValido = valied.valiedGmail(gmail, cap.REQUERIDA, this);
            boolean passwordValido = valied.valiedPassword(contraPP, confirma_contraseña, 6, 20, this);

            // ... (tu lógica de encriptación)...

            // Verifica si todas las validaciones fueron exitosas
            if (nombreValido && gmailValido && passwordValido) {
                startActivity(intent); // Inicia la actividad si las validaciones son exitosas

            }
        });

    }

}
