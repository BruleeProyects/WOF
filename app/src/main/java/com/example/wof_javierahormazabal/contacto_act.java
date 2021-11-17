package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class contacto_act extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        video = findViewById(R.id.vw);

        //Obtengo la ruta del video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video_contacto;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        video.start(); // Inicia el video
    }

    public void Marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + "958744156"));
        startActivity(i);

    }

    public void Maps(View view)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }


}