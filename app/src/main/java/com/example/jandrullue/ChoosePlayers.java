package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ChoosePlayers extends AppCompatActivity {

    private ListView players;
    private ArrayList<String> playersList;
    private ArrayAdapter<String> adaptador1;
    private EditText et1;
    private ImageView addButton;
    private Button startgame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_players);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

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

        players.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ChoosePlayers.this);
                dialogo1.setMessage("¿ Eliminar este jugador ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        playersList.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShotsCounter Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
                for(int i = 0; i < playersList.size();++i) {
                    Shots.getShotsMap().put(playersList.get(i),0);
                }

                String modality = getIntent().getExtras().getString("Modalidad");
                if (modality.equals("VerdadOReto")) {
                    if (playersList.size() < 2) Toast.makeText(ChoosePlayers.this, "Se necesita un mínimo de 2 jugadores", Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(ChoosePlayers.this, VerdadoRetoCasoInicial.class);
                        intent.putStringArrayListExtra("playerList", playersList);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    }
                }
                else if (modality.equals("ElCamino")){
                    if (playersList.size() < 1) Toast.makeText(ChoosePlayers.this, "Se necesita un mínimo de 1 jugador", Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(ChoosePlayers.this, ElCamino_1_1.class);
                        intent.putStringArrayListExtra("playerList", playersList);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    }
                }
                else if (modality.equals("Trivial")){
                    if (playersList.size() < 1) Toast.makeText(ChoosePlayers.this, "Se necesita un mínimo de 1 jugador", Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(ChoosePlayers.this, TrivialDifficulties.class);
                        intent.putStringArrayListExtra("playerList", playersList);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    }
                }
            }
        });

    }
    public void agregar(View v) {
        if(et1.getText().toString().isEmpty()){
            Toast.makeText(ChoosePlayers.this, "Introduce un nombre válido!", Toast.LENGTH_SHORT).show();
        }
        else {
            playersList.add(et1.getText().toString());
            adaptador1.notifyDataSetChanged();
            et1.setText("");
        }
    }
}