package com.example.jandrullue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamesModalities extends AppCompatActivity {
    private Button VerdadoReto;
    private Button LaMoneda;
    private Button YoNunca;

/*
    private ImageView VerdadoReto;
    private ImageView LaMoneda;
    private ImageView YoNunca;
 */


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_modalities);

        VerdadoReto = findViewById(R.id.VerdadoReto);
        LaMoneda = findViewById(R.id.LaMoneda);
        YoNunca = findViewById(R.id.YoNunca);

/*      ESCONDER BARRA DE ARRIBA
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();
 */

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        VerdadoReto.setTypeface(robotoLight);
        LaMoneda.setTypeface(robotoLight);
        YoNunca.setTypeface(robotoLight);

        VerdadoReto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (GamesModalities.this, ChoosePlayers.class);
                intent.putExtra("Modalidad", "VerdadOReto");
                ShotsCounter Shots = new ShotsCounter();
                intent.putExtra("Shots", Shots);
                startActivity(intent);
                //ANIMACIÓN
                //overridePendingTransition(R.anim.top_in, R.anim.top_out);

            }
        });

        LaMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (GamesModalities.this, ChoosePlayers.class);
                intent.putExtra("Modalidad", "LaMoneda");
                ShotsCounter Shots = new ShotsCounter();
                intent.putExtra("Shots", Shots);
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
                startActivity(intent);
                //ANIMACIÓN
                //overridePendingTransition(R.anim.top_in, R.anim.top_out);
            }
        });


    }
}