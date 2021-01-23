package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startgame = findViewById(R.id.startgame);
        startgame.setBackgroundColor(0xFF00FF00);

        startgame.setText("Start Game!!");
        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GamesModalities.class);
                startActivity(intent);
            }
        });
    }
}