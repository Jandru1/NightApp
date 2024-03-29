package com.example.jandrullue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Map;

public class GamesModalities extends AppCompatActivity {

    private ImageButton VerdadoReto;
    private ImageButton ElCamino;
    private ImageButton YoNunca;
    private ImageButton Trivial;

    private ArrayList<String> Jugadores = new ArrayList<>();

    private PlayerClass PlayerClass = new PlayerClass();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_modalities);

        VerdadoReto = findViewById(R.id.VerdadoReto);
        ElCamino = findViewById(R.id.ElCamino);
        YoNunca = findViewById(R.id.YoNunca);
        Trivial = findViewById(R.id.Trivial);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        if(PlayerClass!=null) {
            for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
                String key = entry.getKey();
                Jugadores.add(key);
            }
        }

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        //   VerdadoReto.setTypeface(robotoLight);
        //  ElCamino.setTypeface(robotoLight);
        // YoNunca.setTypeface(robotoLight);
        //Trivial.setTypeface(robotoLight);

        VerdadoReto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (GamesModalities.this, ChoosePlayers.class);
                intent.putExtra("Modalidad", "VerdadOReto");
                ShotsCounter Shots = new ShotsCounter();
                intent.putExtra("Shots", Shots);
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
                //ANIMACIÓN
                //overridePendingTransition(R.anim.top_in, R.anim.top_out);
            }
        });

        ElCamino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (GamesModalities.this, ChoosePlayers.class);
                intent.putExtra("Modalidad", "ElCamino");
                ShotsCounter Shots = new ShotsCounter();
                intent.putExtra("Shots", Shots);
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
                //ANIMACIÓN
                //overridePendingTransition(R.anim.top_in, R.anim.top_out);
            }
        });

        YoNunca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesModalities.this, YoNuncaLevels.class);
                intent.putExtra("Modalidad", "YoNunca");
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
                //ANIMACIÓN
                //overridePendingTransition(R.anim.top_in, R.anim.top_out);
            }
        });
        Trivial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesModalities.this, ChoosePlayers.class);
                intent.putExtra("Modalidad", "Trivial");
                ShotsCounter Shots = new ShotsCounter();
                intent.putExtra("Shots", Shots);
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
                //ANIMACIÓN
                //overridePendingTransition(R.anim.top_in, R.anim.top_out);
            }
        });
    }
}