package com.example.jandrullue;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class TrivialCampeon extends AppCompatActivity {

    private View TrivialCampeonLayout;
    private TextView TrivialCampeonTV;

    private ShotsCounter Shots = new ShotsCounter();

    private com.example.jandrullue.PlayerClass PlayerClass = new PlayerClass();

    private ArrayList<String> Jugadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivial_campeon);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        TrivialCampeonTV = findViewById(R.id.TrivialCampeonTV);
        TrivialCampeonLayout = findViewById(R.id.TrivialCampeonLayout);

        PlayerClass = (com.example.jandrullue.PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }
        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        TrivialCampeonTV.setTypeface(robotoLight);

        int min = 1000;
        String min_key = null;
        for (Map.Entry<String,Integer> entry : Shots.getShotsMap().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value < min) {
                min = value;
                min_key = key;
            }
        }

        TrivialCampeonTV.setText("¡Felicidades, "+min_key+ " ha ganado el Trivial!");

        TrivialCampeonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrivialCampeon.this, GamesModalities.class);
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
            }
        });

    }
}