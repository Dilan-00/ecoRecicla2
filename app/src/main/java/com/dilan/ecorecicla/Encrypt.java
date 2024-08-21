package com.dilan.ecorecicla;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    public static String encryptPasa(String contraPP) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");


            byte[] hashBytes = digest.digest(contraPP.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);}

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean validateEncryptedrPassword(String password, String storedPassword) {


        String encryptedPassword2 = encryptPasa(password);

        Log.e("msg","contraseña ingresada y encriptada:" + encryptedPassword2);
        Log.e("msg","contraseña de la base de datos:" + storedPassword);

        boolean ok = encryptedPassword2.equals(storedPassword);
        Log.e("msg","Contraseña correcta:" + ok);

        return ok;
    }

}



