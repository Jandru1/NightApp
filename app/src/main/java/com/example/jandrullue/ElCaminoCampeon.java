package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ElCaminoCampeon extends AppCompatActivity {

    private TextView CampeonTV;
    private String Campeon;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_campeon);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        layout = findViewById(R.id.ElCaminoCampeon);
        Campeon = getIntent().getExtras().getString("Ganador");
        CampeonTV = findViewById(R.id.CampeonTV);
        CampeonTV.setText("Felicidades!!! "+ Campeon + " ha pasado El Camino!!");
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElCaminoCampeon.this, GamesModalities.class);
                startActivity(intent);
            }
        });
    }
}