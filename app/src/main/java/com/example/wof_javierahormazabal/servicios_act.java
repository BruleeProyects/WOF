package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Servicios;

public class servicios_act extends AppCompatActivity {

    private Spinner servicios;
    private TextView result, calificacion;
    private RatingBar calificar;
    private Servicios ser = new Servicios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        servicios = findViewById(R.id.spnServicios);
        result = findViewById(R.id.tv_resultado);
        calificar = findViewById(R.id.rt);
        calificacion = findViewById(R.id.tv_calificar);

        //Recibo los extras desde el main
        Bundle bun = getIntent().getExtras(); //Recibo valores del bundle
        String[] listado = bun.getStringArray("servicios");

        ArrayAdapter adaptServicios = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        servicios.setAdapter(adaptServicios);
    }

    //Metodo cálculo de servicios
    public void Calcular(View view)
    {
        String opcion = servicios.getSelectedItem().toString();
        int resultado = 0;

        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(ser.getServicios()[i]))
            {
                resultado = ser.AnadirAdicional(ser.getPrecios()[i],400);
                break;
            }
        }

        result.setText("Servicio: " + opcion + "\nPrecio: $" + resultado);

        //Calificación del ratingBar
        float estrellas = calificar.getRating();

        calificacion.setText(estrellas + " Estrellas, ¡Gracias! Tu evaluación nos ayuda a seguir mejorando");


    }
}