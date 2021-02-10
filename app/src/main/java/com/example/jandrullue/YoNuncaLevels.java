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

public class YoNuncaLevels extends AppCompatActivity {

    private ImageButton ChillLevel;
    private Button MediumLevel;
    private ImageButton HotLevel;

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

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
      //  ChillLevel.setTypeface(robotoLight);
      //  HotLevel.setTypeface(robotoLight);

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