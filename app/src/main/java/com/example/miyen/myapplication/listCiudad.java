package com.example.miyen.myapplication;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miyen.myapplication.networking.HttpClientDevazt;
import com.example.miyen.myapplication.networking.OnHttpRequestComplete;
import com.example.miyen.myapplication.networking.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class listCiudad extends Fragment implements View.OnClickListener {

 //nuevo
    ListView listCiudad;
    String url,ciudad;
    comunicador comunicador;
    TextView textViewListciudad;
    ArrayList<String> arrayListCiudades;
    String response;
    AsyncTask peticionTiempo;
    public listCiudad() {
        // Required empty public constructor
    }

    //7730dcb2f1842039e53e3dc3e6c5980e

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_ciudad, container, false);
        comunicador=(comunicador)getActivity();
        textViewListciudad=(TextView)view.findViewById(R.id.textViewListciudad);
        listCiudad =(ListView)view.findViewById(R.id.listCiudad);
        listCiudad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombreCiudad =arrayListCiudades.get(position);
                url = "http://api.openweathermap.org/data/2.5/weather?q="+nombreCiudad+"&appid=7730dcb2f1842039e53e3dc3e6c5980e";
                Log.d("url",url);
               peticionTiempo = new asyncTaskTiempo().execute(url);
            }

        });
        comunicador.mostrarCiudad();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
    public void mostrarCiudad(ArrayList<String> nombre){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), R.layout.itemsciudad, R.id.textViewListciudad, nombre);
        arrayListCiudades =nombre;
        listCiudad.setAdapter(adapter);
    }

    public class asyncTaskTiempo extends AsyncTask<String,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... urlFragment) {
            String urlDescarga = urlFragment[0];
            setPeticionTiempo(urlDescarga);
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            try {
                 JSONObject jsonObjectErrorMyCuts = new JSONObject(response);
                 JSONObject jsonArrayErrorCuts = new JSONObject(jsonObjectErrorMyCuts.getString("main"));
                 Toast.makeText(getActivity(), ""+jsonArrayErrorCuts.toString(), Toast.LENGTH_SHORT).show();
                 response = "";
                } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public void setPeticionTiempo(String url){

        HttpClientDevazt clientDevazt = new HttpClientDevazt(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if(status.isSuccess()){
                    response =status.getResult();
                }
                else {
                    Toast.makeText(getActivity(), "no se encontro la ciudad", Toast.LENGTH_SHORT).show();
                }

            }
        });clientDevazt.excecute(url);
    }

}
