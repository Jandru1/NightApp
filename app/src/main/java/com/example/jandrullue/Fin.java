package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fin extends AppCompatActivity {

    private Button Fin;
    private TextView Fin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        Fin = findViewById(R.id.Volver);
        Fin2 = findViewById(R.id.textView3);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        Fin.setTypeface(robotoLight);
        Fin2.setTypeface(robotoLight);

        Fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fin.this, GamesModalities.class);
                startActivity(intent);
            }
        });


    }
}