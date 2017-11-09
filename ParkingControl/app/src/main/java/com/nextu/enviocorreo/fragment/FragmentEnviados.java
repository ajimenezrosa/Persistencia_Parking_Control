package com.nextu.enviocorreo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nextu.enviocorreo.R;
import com.nextu.enviocorreo.ServicioArchivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Next University.
 */
public class FragmentEnviados extends Fragment {

    private String nombreArchivo = "enviados.txt";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enviados, container, false);

        try{
            TextView txtEnviados = (TextView) view.findViewById(R.id.txt_enviados);
            txtEnviados.setText(ServicioArchivo.cargar(getActivity()));
        }catch (IOException e){
            Toast.makeText(getActivity(), "Error al cargar el archivo", Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
