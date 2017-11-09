package com.nextu.enviocorreo;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Next University.
 */
public class ServicioArchivo {

    private static String nombreArchivo = "enviados.txt";

    public static void guardar(Activity activity, String value) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(activity.openFileOutput(nombreArchivo,activity.MODE_APPEND)));
        writer.write(value);
        writer.close();
    }

    public static String cargar(Activity activity) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(activity.openFileInput(nombreArchivo)));
        String iteracion, resultado = "";
        while ((iteracion = br.readLine()) != null){
            resultado += iteracion+"\n";
        }
        return resultado;
    }
}
