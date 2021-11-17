package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class perfil_act extends AppCompatActivity {

    public TextView name, type, age;

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

}