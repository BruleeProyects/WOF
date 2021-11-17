package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Objetos.Servicios;

public class perfil_act extends AppCompatActivity {

    public TextView name, type, age;
    private Servicios ser = new Servicios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void Carnet(View view)
    {
        Intent i = new Intent(this, carnet_act.class);
        startActivity(i);
    }

    public void Servicios(View view)
    {
        Intent i = new Intent(this, servicios_act.class);
        Bundle bun =new Bundle();
        bun.putStringArray("servicios", ser.getServicios());
        i.putExtras(bun);
        startActivity(i);



    }

    public void Contacto (View view)
    {
        Intent i = new Intent(this, contacto_act.class);
        startActivity(i);
    }

    public void Mascotas(View view)
    {
        Intent i = new Intent(this, mascotas_act.class);
        startActivity(i);
    }

}