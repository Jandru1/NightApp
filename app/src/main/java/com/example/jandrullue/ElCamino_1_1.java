package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ElCamino_1_1 extends AppCompatActivity {

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private int n;
    private int k = 0;

    private Button RojoButton;
    private Button NegroButton;
    private Button SiguienteButton;

    private ImageView HomeButton;

    private TextView pregunta;
    private TextView player;

    private Intent intent;
    private BarajaPoker Baraja = new BarajaPoker();

    private ShotsCounter Shots = new ShotsCounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_1_1);

        Jugadores = getIntent().getStringArrayListExtra("playerList");

        RojoButton = findViewById(R.id.RojoButton);
        NegroButton = findViewById(R.id.NegroButton);
        SiguienteButton = findViewById(R.id.SiguienteButton);
        HomeButton = findViewById(R.id.HomeButton1_1);
        pregunta = findViewById(R.id.RojoONegro);
        player = findViewById(R.id.Player);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        pregunta.setTypeface(robotoLight);
        player.setTypeface(robotoLight);

        intent = new Intent(ElCamino_1_1.this, ElCamino_1_2.class);

        Primer_caso();
    }

    private void Primer_caso() {
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_1_1.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_1_1.this, GamesModalities.class);
                        startActivity(intent);
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

            }
        });

        player.setText(Jugadores.get(k));
        pregunta.setText("¿De qué color es la carta?");
        RojoButton.setVisibility(View.VISIBLE);
        NegroButton.setVisibility(View.VISIBLE);
        SiguienteButton.setVisibility(View.INVISIBLE);

        RojoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = "rojo";
                enseñar_carta(color);
            }
        });

        NegroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = "negro";
                enseñar_carta(color);
            }
        });


    }

    private void enseñar_carta(String color) {
        generarRandom();

        String carta = Baraja.getBaraja().get(n);
        Log.d("CARTA 1: ", ""+carta);

        String color_carta = getColorCarta(carta);
        RojoButton.setVisibility(View.INVISIBLE);
        NegroButton.setVisibility(View.INVISIBLE);
        SiguienteButton.setVisibility(View.VISIBLE);

        if(!color.equals(color_carta)){
            String color_respuesta = null;
            if (color.equals("negro")) color_respuesta = "rojo";
            if (color.equals("rojo")) color_respuesta = "negro";
            pregunta.setText("Lástima!" + "   " + "Tu carta es un " + carta + ". Bebes 1 trago!");
            Shots.SumShot(Jugadores.get(k));
        }

        else {
            pregunta.setText("Felicidades! Tu carta es un " + carta + ". Repartes 1 trago");
        }

        BarajaPersonalizada BarajaPers = new BarajaPersonalizada();
        BarajaPers.añadir_carta(carta);
        BarajaPers.setplayer(Jugadores.get(k));
        Bundle b = new Bundle();
        b.putSerializable("BarajaPersonalizada", BarajaPers);

        intent.putExtra("BarajaPers " + k , b);

        SiguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k+1 == Jugadores.size()) {
                    intent.putStringArrayListExtra("Players", Jugadores);
                    intent.putStringArrayListExtra("numeross", numeross);
                    intent.putExtra("Shots", Shots);
                    startActivity(intent);
                }
                else {

                    ++k;

                    Primer_caso();
                }
            }
        });

    }

    private String getColorCarta(String carta) {
        String color = null;
        String tipo = null;

        for(int i = 0; i < carta.length(); ++i) {
            if (carta.startsWith("de", i)){
                tipo = carta.substring(i+3);
            }
        }
        if(tipo.equals("corazones") || tipo.equals("diamantes")) color = "rojo";
        else if(tipo.equals("treboles") || tipo.equals("picas")) color = "negro";
        return color;
    }

    public void generarRandom() {
        boolean ha_salido = false;
        double m = Math.random()*Baraja.getBaraja().size()+0;
        n = (int) m;
        String n_string = Integer.toString(n);

        if (numeross.size()==0) {
            numeross.add(n_string);
            ha_salido = false;
        }
        else if(numeross.size()==Baraja.getBaraja().size()) ha_salido=false;
        else {
            for (int k = 0; k < numeross.size(); ++k) {
                if (numeross.get(k).equals(n_string)) ha_salido = true;
            }
        }
        if(ha_salido) generarRandom();
        else numeross.add(n_string);
    }

}