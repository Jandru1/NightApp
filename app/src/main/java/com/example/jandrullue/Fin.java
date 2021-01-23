package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fin extends AppCompatActivity {

    private Button Fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        Fin = findViewById(R.id.Volver);

        Fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fin.this, GamesModalities.class);
                startActivity(intent);
            }
        });


    }
}