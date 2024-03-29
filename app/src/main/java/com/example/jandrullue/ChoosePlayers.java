package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
import java.util.Map;

public class ChoosePlayers extends AppCompatActivity {

    private ListView players;
    private ArrayList<String> playersList;
    private ArrayList<String> Jugadores = new ArrayList<>();
    private ArrayAdapter<String> adaptador1;
    private EditText et1;
    private Button startgame;
    private ImageView HombreButton;
    private ImageView MujerButton;
    private String modality;

    private PlayerClass PlayerClass = new PlayerClass();



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
        adaptador1=new ArrayAdapter<String>(this, R.layout.nombres_chooseplayers, playersList);
        players.setAdapter(adaptador1);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        et1.setTypeface(robotoLight);
        startgame.setTypeface(robotoLight);

        HombreButton = findViewById(R.id.HombreButton);
        MujerButton = findViewById(R.id.MujerButton);

        modality = getIntent().getExtras().getString("Modalidad");
        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        if(PlayerClass!=null) {
            for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
                String key = entry.getKey();
                Jugadores.add(key);
            }
        }
        else PlayerClass = new PlayerClass();

        if(Jugadores != null) {
            for(int i = 0; i < Jugadores.size();++i) {
                playersList.add(Jugadores.get(i));
                adaptador1.notifyDataSetChanged();
            }
        }
        MujerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar(v, "mujer");
            }
        });
        HombreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar(v, "hombre");
            }
        });

        players.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ChoosePlayers.this);
                dialogo1.setMessage("¿Eliminar este jugador?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        PlayerClass.removePlayer(playersList.get(posicion));
                        Log.d("la posicions es",""+posicion);
                        if (!Jugadores.isEmpty()) Jugadores.remove(posicion);
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
                if (modality.equals("VerdadOReto")) {
                    if (playersList.size() < 2)
                        Toast.makeText(ChoosePlayers.this, "Se necesita un mínimo de 2 jugadores", Toast.LENGTH_SHORT).show();
                    else {
                        ShotsCounter Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
                        for(int i = 0; i < playersList.size();++i) {
                            Shots.getShotsMap().put(playersList.get(i),0);
                        }
                        Intent intent = new Intent(ChoosePlayers.this, VerdadoRetoCasoInicial.class);
                        intent.putExtra("Jugadores", PlayerClass);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    }
                }
                else if (modality.equals("ElCamino")) {
                    Log.d("Entro if modalidad","");
                    boolean longitudTooMuch = false;
                    for(int i = 0; i < playersList.size(); ++i) {
                        String nombre = playersList.get(i);
                        if(nombre.length() > 9) {
                            Log.d("Playerslist" + i, "" + playersList.get(i));
                            longitudTooMuch = true;
                        }
                    }
                    if (playersList.size() < 1) Toast.makeText(ChoosePlayers.this, "Se necesita un mínimo de 1 jugador", Toast.LENGTH_SHORT).show();
                    else if (longitudTooMuch) {
                        Toast.makeText(ChoosePlayers.this, "Máximo número de caracteres por nombre: 9", Toast.LENGTH_SHORT).show();
                    }
                    else if (playersList.size() > 9) {
                        Toast.makeText(ChoosePlayers.this, "Máximo número de jugadores: 9", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ShotsCounter Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
                        for(int i = 0; i < playersList.size();++i) {
                            Shots.getShotsMap().put(playersList.get(i),0);
                        }
                        Intent intent = new Intent(ChoosePlayers.this, ElCamino_1_1.class);
                        intent.putExtra("Jugadores", PlayerClass);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    }
                } else if (modality.equals("Trivial")) {
                    if (playersList.size() < 1)
                        Toast.makeText(ChoosePlayers.this, "Se necesita un mínimo de 1 jugador", Toast.LENGTH_SHORT).show();
                    else {
                        ShotsCounter Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
                        for(int i = 0; i < playersList.size();++i) {
                            Shots.getShotsMap().put(playersList.get(i),0);
                        }
                        Intent intent = new Intent(ChoosePlayers.this, TrivialDifficulties.class);
                        intent.putExtra("Jugadores", PlayerClass);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    }
                }
            }
        });

    }
    public void agregar(View v, String sexo) {
        if(et1.getText().toString().isEmpty()){
            Log.d("entro en el log","");
            Toast.makeText(ChoosePlayers.this, "Introduce un nombre válido", Toast.LENGTH_SHORT).show();
        }

        else if (playersList.size()==9 & (modality.equals("ElCamino")||modality.equals("Trivial"))) Toast.makeText(ChoosePlayers.this, "Has llegado al número máximo de jugadores", Toast.LENGTH_SHORT).show();

        else if(et1.getText().toString().length()>9 & modality.equals("ElCamino")) Toast.makeText(ChoosePlayers.this, "Número máximo de carácteres por nombre: 9", Toast.LENGTH_SHORT).show();

        else {
            boolean repetido = false;
            for(int i = 0; i < playersList.size();++i) {
                if(playersList.get(i).equals(et1.getText().toString())) repetido=true;
            }
            if(!repetido) {
                if(sexo.equals("mujer")) {
                    Log.d("entro en mujer","");
                    PlayerClass.addPlayer(et1.getText().toString(),1);
                }
                else if(sexo.equals("hombre")){
                    Log.d("entro en hombre","");
                    PlayerClass.addPlayer(et1.getText().toString(),0);
                }
                playersList.add(et1.getText().toString());
                adaptador1.notifyDataSetChanged();
                et1.setText("");
            }
            else Toast.makeText(ChoosePlayers.this, "Este jugador ya existe", Toast.LENGTH_SHORT).show();
        }
    }
}