package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ElCaminoCampeon extends AppCompatActivity {

    private TextView CampeonTV;
    private String Campeon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_campeon);

        Campeon = getIntent().getExtras().getString("Ganador");
        CampeonTV = findViewById(R.id.CampeonTV);
        CampeonTV.setText("Felicidades!!! "+ Campeon + " ha pasado El Camino!!");
    }
}