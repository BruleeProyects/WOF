package com.example.wof_javierahormazabal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Button btn;
    private ProgressBar barra;
    Administrador admin = new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.et_user);
        pass = findViewById(R.id.et_pass);
        msj = findViewById(R.id.tv_msj);
        btn = findViewById(R.id.btn1);
        barra = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Ejecuto la tarea asincrona
                new Task().execute();
            }
        });

    }

    //Tarea Asíncrona.
    class Task extends AsyncTask<String, Void, String>
    {
        //Configuracion inicial a mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE); //Visivilizo la barra
        }
        //Procesa en segundo plano la tarea pesada
        @Override
        protected String doInBackground(String... strings) {

            try {

                for (int i = 0; i <= 10; i++)
                {
                    Thread.sleep(500); // duerme un proceso por 500 milisegundos
                }
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            return null;
        }
        //Finalización de la tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            //Validación de la sesión
            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = admin.getUser().trim();
            String passObj = admin.getPass().trim();

            switch (usuario)
            {
                case "javiera":
                    if(usuario.equals(userObj) && contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(),perfil_act.class);
                        startActivity(i);


                    }
                    break;
                case "":
                    if(usuario.equals("") && contrasena.equals(""))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacíos");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos incorrectos");
                    }
                    break;
            }
        }
    }

    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //accion para abrir un sitio web
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public void Youtube (View view)
    {
        Intent i = new Intent();
        i.setData(Uri.parse("https://www.youtube.com/watch?v=_2W6IZqyVFs"));
        startActivity(i);
    }

    public void Instagram (View view)
    {
        Intent i = new Intent();
        i.setData(Uri.parse("https://www.instagram.com/wof.cl/?hl=es-la"));
        startActivity(i);
    }

    public void Website(View view)
    {
        Intent i = new Intent();
        i.setData(Uri.parse("https://wof.gg/top/pc/1/"));
        startActivity(i);
    }

}