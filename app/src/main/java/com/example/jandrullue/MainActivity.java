package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button startgame;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startgame = findViewById(R.id.startgame);
        startgame.setBackgroundColor(0xFF00FF00);

        textView = findViewById(R.id.textView);
        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        textView.setTypeface(robotoLight);
        startgame.setTypeface(robotoLight);

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