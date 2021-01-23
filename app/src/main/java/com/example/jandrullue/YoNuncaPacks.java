package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YoNuncaPacks extends AppCompatActivity {

    private String Level;
    private Button Pack2Button;
    private Button Pack1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca_packs);

        Pack1Button = findViewById(R.id.Pack1Button);
        Pack2Button = findViewById(R.id.Pack2Button);

        Level = getIntent().getExtras().getString("Level");

        Pack1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaPacks.this, YoNunca.class);
                intent.putExtra("Level", Level);
                intent.putExtra("Pack","Pack1");
                startActivity(intent);
            }
        });
        Pack2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YoNuncaPacks.this, YoNunca.class);
                intent.putExtra("Level", Level);
                intent.putExtra("Pack","Pack2");
                startActivity(intent);
            }
        });
    }
}