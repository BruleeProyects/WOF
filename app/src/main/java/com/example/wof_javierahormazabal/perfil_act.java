package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wof_javierahormazabal.database.AdminSQLiteOpenHelper;

import Objetos.Servicios;

public class perfil_act extends AppCompatActivity {

    public TextView name, type, age;
    private Servicios ser = new Servicios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        name= findViewById(R.id.tv_name);
        type= findViewById(R.id.tv_type);
        age= findViewById(R.id.tv_age);

        //Rellenar datos desde base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wof", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Sobreescribe la base de datos

        Cursor file =  db.rawQuery("SELECT nombre, especie, edad FROM mascotas", null);

        if(file.moveToFirst()) //Comprueba si la consulta tiene o no valores
        {
            name.setText(file.getString(0));
            type.setText(file.getString(1));
            age.setText(file.getString(2));
        }else{
            Toast.makeText(getBaseContext(), "No hay mascotas asociadas", Toast.LENGTH_LONG).show();
        }


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