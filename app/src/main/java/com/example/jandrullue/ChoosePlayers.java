package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ChoosePlayers extends AppCompatActivity {

    private ListView players;
    private ArrayList<String> playersList;
    private ArrayAdapter<String> adaptador1;
    private EditText et1;
    private ImageButton addButton;
    private Button startgame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_players);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        startgame = findViewById(R.id.StartButton);
        startgame.setBackgroundColor(0xFF00FF00);
        startgame.setText("Start Game!!");

        players = findViewById(R.id.players);
        et1 = findViewById(R.id.addPlayer);

        playersList = new ArrayList<String>();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, playersList);
        players.setAdapter(adaptador1);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        et1.setTypeface(robotoLight);
        startgame.setTypeface(robotoLight);

        addButton = findViewById(R.id.AddButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar(v);
            }
        });

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoosePlayers.this, VerdadoRetoCasoInicial.class);
                intent.putStringArrayListExtra("playerList", playersList);
                startActivity(intent);
            }
        });

    }
    public void agregar(View v) {
        playersList.add(et1.getText().toString());
        adaptador1.notifyDataSetChanged();
        et1.setText("");
    }
}