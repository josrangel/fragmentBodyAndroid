package com.josrangel.fragmentbody;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class BodyPartFragment extends Fragment {

    private int indice = 0;
    private List arreglo;
    private int tipo;


    public BodyPartFragment() {

    }

    public void eligeTipo(int tipo){
        this.tipo = tipo;
        switch (tipo){
            case 1:
                arreglo=ImagenesGenerales.iniciaHeads();
                break;
            case 2:
                arreglo=ImagenesGenerales.iniciaBodys();
                break;
            case 3:
                arreglo=ImagenesGenerales.iniciaLegs();
                break;
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        //super.onSaveInstanceState(outState);
        outState.putInt("indice",indice);
        outState.putInt("tipo",tipo);

        //outState.
        Log.i("saved0",indice+"");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){

            eligeTipo(savedInstanceState.getInt("tipo"));
            indice = savedInstanceState.getInt("indice");
            Log.i("saved",indice+"");
        }
        View vista;

        vista = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = vista.findViewById(R.id.imagenFragment);

        imageView.setImageResource((int)arreglo.get(indice));
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indice++;
                imageView.setImageResource((int)arreglo.get(indice));
                if(indice==11){
                    indice=-1;
                }
            }
        });
        return vista;
    }
}