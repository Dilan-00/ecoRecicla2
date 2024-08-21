package com.dilan.ecorecicla;



import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.dilan.ecorecicla.MainActivity_registersed.cap;


public class valied {


    public static boolean valiedNombre(EditText editText, String nameC, int baj, int alt, cap cap, Context context) {

        String texto = editText.getText().toString();

        Context editTextContext = editText.getContext();

        if (cap == cap.REQUERIDA && texto.isEmpty()) {
            Toast.makeText(context, "¡El espacio " + nameC + " no puede estar vacio!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (cap == cap.REQUERIDA && texto.length() < baj) {
            Toast.makeText(context, "¡El espacio " + nameC + " debe tener mas de " + (baj - 1) + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (texto.length() > alt) {
            Toast.makeText(context, "¡El espacio " + nameC + " debe tener maximo " + alt + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;

        }

        if (cap == cap.REQUERIDA && !texto.matches("^[a-zA-ZÄ-ÿ\\s'-]{3,30}$")) {
            Toast.makeText(context, "¡El espacio " + nameC + " debe tener solo letras!.", Toast.LENGTH_LONG).show();
            return false;

        }

        return true;
    }

    public static boolean valiedGmail(EditText editText, cap cap, Context context) {

        String texto = editText.getText().toString();

        if (cap == cap.REQUERIDA && texto.isEmpty()) {
            Toast.makeText(context, "¡El espacio gmail no puede estar vacio!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (cap == cap.REQUERIDA && !texto.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
            Toast.makeText(context, "¡El espacio gmail debe ser valido!.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    public static boolean valiedPassword(EditText password, EditText passwordCorrect, int baj, int alt, Context context) {


        String pass = password.getText().toString();
        String passC = passwordCorrect.getText().toString();

        Context editTextContext = password.getContext();

        if (pass.isEmpty()) {
            Toast.makeText(context, "¡El espacio contraseña no puede estar vacia!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (pass.length() < baj) {
            Toast.makeText(context, "  ¡El espacio contraseña debe tener mas de " + (baj - 1) + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (pass.length() > alt) {
            Toast.makeText(context, "¡El espacio contraseña debe tener maximo " + alt + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;

        }

        if (!pass.equals(passC)) {
            Toast.makeText(context, "¡Las contraseñas no coincide!.", Toast.LENGTH_LONG).show();
            return false;


        }

        return true;
    }


    public static boolean valiedUser(EditText usuarioN, String usuario, int baj, int alt, MainActivity.cap cap, MainActivity context) {

        String texto = usuarioN.getText().toString();

        Context editTextContext = usuarioN.getContext();

        if (cap == MainActivity.cap.REQUERIDA && texto.isEmpty()) {
            Toast.makeText(context, "¡El espacio " + usuario + " no puede estar vacio!.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (cap == cap.REQUERIDA && texto.length() < baj) {
            Toast.makeText(context, "¡El espacio " + usuario + " debe tener mas de " + (baj - 1) + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (texto.length() > alt) {
            Toast.makeText(context, "¡El espacio " + usuario + " debe tener maximo " + alt + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;

        }

        if (cap == cap.REQUERIDA && !texto.matches("^[a-zA-ZÄ-ÿ\\s'-]{3,30}$")) {
            Toast.makeText(context, "¡El espacio " + usuario + " debe tener solo letras!.", Toast.LENGTH_LONG).show();
            return false;

        }

        return true;

    }


    public static void valiedcontraseña() {
    }

    public static boolean valiedcontraseña(EditText contraseña, String contraseña1, int i, int i1, MainActivity.cap cap, MainActivity mainActivity) {

        String pass = contraseña.getText().toString();
        String passC = contraseña.getText().toString();

        Context editTextContext = contraseña.getContext();

        if (pass.isEmpty()) {
            Toast.makeText(contraseña.getContext(), "¡El espacio contraseña no puede estar vacia!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (pass.length() < i) {
            Toast.makeText(contraseña.getContext(), "  ¡El espacio contraseña debe tener mas de " + (i - 1) + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (pass.length() > i1) {
            Toast.makeText(contraseña.getContext(), "¡El espacio contraseña debe tener maximo " + i1 + " caracteres!.", Toast.LENGTH_LONG).show();
            return false;

        }

        if (!pass.equals(passC)) {
            Toast.makeText(contraseña.getContext(), "¡Las contraseñas no coincide!.", Toast.LENGTH_LONG).show();
            return false;

        }

        return true;
    }
}









