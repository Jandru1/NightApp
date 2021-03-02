package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Map;

public class YoNuncaLevels extends AppCompatActivity {

    private ImageButton ChillLevel;
    private Button MediumLevel;
    private ImageButton HotLevel;
    private ArrayList<String> Jugadores = new ArrayList<>();

    private PlayerClass PlayerClass = new PlayerClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca_levels);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        ChillLevel = findViewById(R.id.ChillLevelButton);
        // MediumLevel = findViewById(R.id.MediumLevelButton);
        HotLevel = findViewById(R.id.HotLevelButton);

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        if(PlayerClass!=null) {
            for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
                String key = entry.getKey();
                Jugadores.add(key);
            }
        }
        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        //  ChillLevel.setTypeface(robotoLight);
        //  HotLevel.setTypeface(robotoLight);

        ChillLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaLevels.this, YoNuncaPacks.class);
                intent.putExtra("Level", "Chill");
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
            }
        });
        /*
        MediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaLevels.this, YoNuncaPacks.class);
                intent.putExtra("Level", "Medium");
                startActivity(intent);
            }
        });

         */
        HotLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaLevels.this, YoNuncaPacks.class);
                intent.putExtra("Level", "Hot");
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
            }
        });

    }
}