package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YoNuncaLevels extends AppCompatActivity {

    private Button ChillLevel;
    private Button MediumLevel;
    private Button HotLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca_levels);

        ChillLevel = findViewById(R.id.ChillLevelButton);
       // MediumLevel = findViewById(R.id.MediumLevelButton);
        HotLevel = findViewById(R.id.HotLevelButton);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        ChillLevel.setTypeface(robotoLight);
        HotLevel.setTypeface(robotoLight);

        ChillLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaLevels.this, YoNuncaPacks.class);
                intent.putExtra("Level", "Chill");
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
                startActivity(intent);
            }
        });

    }
}