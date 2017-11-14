package com.example.miyen.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class listCiudad extends Fragment {

 //nuevo
    ListView listCiudad;
    public listCiudad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_ciudad, container, false);
        listCiudad =(ListView)view.findViewById(R.id.listCiudad);
        return view;
    }

}
