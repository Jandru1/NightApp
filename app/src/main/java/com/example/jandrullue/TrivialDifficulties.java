package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Map;

public class TrivialDifficulties extends AppCompatActivity {

    private ImageView FacilButton;
    private ImageView MedioButton;
    private ImageView DificilButton;

    private String dificultad;
    private ArrayList<String> Jugadores = new ArrayList<>();

    private ShotsCounter Shots = new ShotsCounter();
    private PlayerClass PlayerClass = new PlayerClass();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivial_difficulties);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }
        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        FacilButton = findViewById(R.id.FacilButton);
        MedioButton = findViewById(R.id.MedioButton);
        DificilButton = findViewById(R.id.DificilButton);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        //FacilButton.setTypeface(robotoLight);
        //MedioButton.setTypeface(robotoLight);
        //DificilButton.setTypeface(robotoLight);

        init();
    }

    private void init() {
        dificultad = null;
        FacilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultad = "facil";
                empezar_trivial(dificultad);
            }
        });
        MedioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultad = "medio";
                empezar_trivial(dificultad);
            }
        });
        DificilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultad = "dificil";
                empezar_trivial(dificultad);
            }
        });
    }

    private void empezar_trivial(String dificultad) {
        Intent intent = new Intent(TrivialDifficulties.this, Trivial.class);
        intent.putExtra("Jugadores", PlayerClass);
        intent.putExtra("Dificultad",dificultad);
        intent.putExtra("Shots",Shots);
        startActivity(intent);
    }
}