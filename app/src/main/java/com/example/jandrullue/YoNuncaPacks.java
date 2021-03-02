package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Map;

public class YoNuncaPacks extends AppCompatActivity {

    private String Level;
    private ImageButton Pack2Button;
    private ImageButton Pack1Button;
    private ArrayList<String> Jugadores = new ArrayList<>();

    private PlayerClass PlayerClass = new PlayerClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca_packs);

        Pack1Button = findViewById(R.id.Pack1Button);
        Pack2Button = findViewById(R.id.Pack2Button);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        //    Pack1Button.setTypeface(robotoLight);
        //    Pack2Button.setTypeface(robotoLight);

        Level = getIntent().getExtras().getString("Level");
        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        if(PlayerClass!=null) {
            for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
                String key = entry.getKey();
                Jugadores.add(key);
            }
        }
        Pack1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaPacks.this, YoNunca.class);
                intent.putExtra("Level", Level);
                intent.putExtra("Pack","Pack1");
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
            }
        });
        Pack2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaPacks.this, YoNunca.class);
                intent.putExtra("Level", Level);
                intent.putExtra("Pack","Pack2");
                intent.putExtra("Jugadores", PlayerClass);
                startActivity(intent);
            }
        });
    }
}