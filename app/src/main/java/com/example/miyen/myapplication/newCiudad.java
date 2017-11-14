package com.example.miyen.myapplication;

import android.content.SharedPreferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class newCiudad extends Fragment implements View.OnClickListener {


    Context context;
    Button btnAgregarCiudad;
    EditText editTextCiudad;
    comunicador comunicador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_ciudad, container, false);
        comunicador =(comunicador)getActivity();
        context = getActivity();
        btnAgregarCiudad =(Button)view.findViewById(R.id.btnAgregarCiudad);
        btnAgregarCiudad.setOnClickListener(this);
        editTextCiudad=(EditText)view.findViewById(R.id.editTextCiudad);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregarCiudad:
                String nombreCiudad = editTextCiudad.getText().toString();

                if(nombreCiudad.isEmpty()){
                    Toast.makeText(getActivity(), "Ingrese una ciudad", Toast.LENGTH_SHORT).show();
                }else {
                    comunicador.nuevaCiudad(nombreCiudad);
                }
                break;
        }
    }
}
