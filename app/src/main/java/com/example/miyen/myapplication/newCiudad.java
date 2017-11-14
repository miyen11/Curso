package com.example.miyen.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class newCiudad extends Fragment {


    Button btnAgregarCiudad;
    EditText editTextCiudad;
    public newCiudad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_ciudad, container, false);
        btnAgregarCiudad =(Button)view.findViewById(R.id.btnAgregarCiudad);
        editTextCiudad=(EditText)view.findViewById(R.id.editTextCiudad);
        return view;
    }

}
