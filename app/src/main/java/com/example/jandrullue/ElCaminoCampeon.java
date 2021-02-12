package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCaminoCampeon extends AppCompatActivity {

    private TextView CampeonTV;
    private TextView Quehacertv;

    private String Campeon;

    private View layout;

    private Button SeguirJugandoButton;
    private Button TerminarButton;

    private ShotsCounter Shots = new ShotsCounter();

    private ArrayList<String> Jugadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_campeon);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        layout = findViewById(R.id.ElCaminoCampeon);
        Quehacertv = findViewById(R.id.quehacertv);
        SeguirJugandoButton = findViewById(R.id.SeguirJugandoButton);
        TerminarButton = findViewById(R.id.TerminarButton);

        Campeon = getIntent().getExtras().getString("Ganador");
        Jugadores = getIntent().getStringArrayListExtra("Jugadores");
        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        CampeonTV = findViewById(R.id.CampeonTV);
        CampeonTV.setText("Felicidades!!! "+ Campeon + " ha pasado El Camino!!");

        SeguirJugandoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElCaminoCampeon.this, ElCamino3_Nuevo.class);
                intent.putStringArrayListExtra("Jugadores", Jugadores);
                intent.putExtra("Perdedor", Campeon);
                intent.putExtra("Shots", Shots);

                startActivity(intent);
            }
        });

        TerminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElCaminoCampeon.this, GamesModalities.class);
                startActivity(intent);
            }
        });
    }
}