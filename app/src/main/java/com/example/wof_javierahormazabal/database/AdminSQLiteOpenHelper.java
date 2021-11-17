package com.example.wof_javierahormazabal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    //Constructor para instanciar y usar la database
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //crear tablas y sus cambios
    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creo mi tabla y sus campos
        db.execSQL("CREATE TABLE mascotas(codigo int primary key, nombre text, especie text, edad int)");

    }

    //Me permite realizar cambios esquematicos en mi modelo.
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
