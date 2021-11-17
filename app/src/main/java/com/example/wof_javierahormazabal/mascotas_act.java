package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wof_javierahormazabal.database.AdminSQLiteOpenHelper;

public class mascotas_act extends AppCompatActivity {

    private EditText codigo, name, especie, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        codigo = findViewById(R.id.et_codigo);
        name = findViewById(R.id.et_name);
        especie = findViewById(R.id.et_esp);
        edad = findViewById(R.id.et_edad);
    }

    //Metodo para guardar mascota
    public void guardarMascota(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wof", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Sobreescribe la base de datos

        //Obtengo los valores que escribe el usuario
        String code = codigo.getText().toString();
        String nombre = name.getText().toString();
        String esp = especie.getText().toString();
        String age = edad.getText().toString();

        if(!code.isEmpty() && !nombre.isEmpty() && !esp.isEmpty() && !age.isEmpty())
        {
            //guardo datos
            ContentValues cont = new ContentValues(); //Me permite contener valores
            cont.put("codigo", code);
            cont.put("nombre", nombre);
            cont.put("especie", esp);
            cont.put("edad", age);

            db.insert("mascotas", null,cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Mascota guardada exitosamente", Toast.LENGTH_SHORT).show();

        }


    }

    //Metodo para mostrar mascota
    public void mostrarMascota(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wof", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Sobreescribe la base de datos

        String code = codigo.getText().toString();

        if(!code.isEmpty())
        {
            Cursor file =  db.rawQuery("SELECT nombre, especie, edad FROM mascotas WHERE  codigo="+code, null);

            if(file.moveToFirst()) //Comprueba si la consulta tiene o no valores
            {
               name.setText(file.getString(0));
               especie.setText(file.getString(1));
               edad.setText(file.getString(2));
            }else{
                Toast.makeText(getBaseContext(), "No hay mascotas asociadas", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getBaseContext(), "El código esta vacío", Toast.LENGTH_SHORT).show();
        }

    }



    //Metodo para eliminar mascota
    public void eliminarMascota(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wof", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Sobreescribe la base de datos

        String code = codigo.getText().toString();

        if(!code.isEmpty())
        {
            //Eliminar
            db.delete("mascotas", "codigo="+code, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Mascota eliminada exitosamente", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(), "Ingrese código por favor", Toast.LENGTH_LONG).show();
        }


    }

    //Metodo para actualizar mascota
    public void actualizarMascota(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "wof", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Sobreescribe la base de datos

        //Obtengo los valores que escribe el usuario
        String code = codigo.getText().toString();
        String nombre = name.getText().toString();
        String esp = especie.getText().toString();
        String age = edad.getText().toString();

        if(!code.isEmpty() && !nombre.isEmpty() && !esp.isEmpty() && !age.isEmpty())
        {
            ContentValues cont = new ContentValues(); //Me permite contener valores
            cont.put("nombre", nombre);
            cont.put("especie", esp);
            cont.put("edad", age);

            db.update("mascotas", cont, "codigo="+code, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Mascota actualizada exitosamente", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getBaseContext(), "Hay campos vacíos", Toast.LENGTH_SHORT).show();
        }


    }

    //Metodo para limpiar campos
    public void Clean()
    {
        codigo.setText("");
        name.setText("");
        especie.setText("");
        edad.setText("");
    }
}