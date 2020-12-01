package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class VerDetalle extends AppCompatActivity {

    private TextView idtitulo, idauthor, idtipo;
    Activity activity;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalle);

        idtitulo = (TextView) findViewById(R.id.idtitulo);
        idauthor = (TextView) findViewById(R.id.idauthor);
        idtipo = (TextView) findViewById(R.id.idtipo);
        vercontenido();



    }


    protected void vercontenido()
    {
       Bundle bundle = getIntent().getExtras();
       bundle.getString("idtitulo");
        bundle.getString("idauthor");
        bundle.getString("idtipo");

    }

}