package com.nextu.enviocorreo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.nextu.enviocorreo.R;
import com.nextu.enviocorreo.ServicioArchivo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Next University.
 */
public class FragmentEnviar extends Fragment {

    private EditText editPara, editAsunto, editMensaje;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_enviar, container, false);
        editPara = (EditText) view.findViewById(R.id.edit_para);
        editAsunto = (EditText) view.findViewById(R.id.edit_asunto);
        editMensaje = (EditText) view.findViewById(R.id.edit_mensaje);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_enviar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.accion_enviar:
                try{
                    String para = editPara.getText().toString();
                    String asunto = editAsunto.getText().toString();
                    String mensaje = editMensaje.getText().toString();

                    if (!para.equals("") && !asunto.equals("")
                            && !mensaje.equals("")){
                        String result = "Para: "+para+"\nAsunto: "+asunto+"\nMensaje: "+mensaje+"\n\n";
                        ServicioArchivo.guardar(getActivity(), result);
                        editPara.setText("");
                        editAsunto.setText("");
                        editMensaje.setText("");
                        Toast.makeText(getActivity(), "Mensaje enviado", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                    }

                }catch (IOException e){
                    Toast.makeText(getActivity(), "Error al guardar el archivo", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
