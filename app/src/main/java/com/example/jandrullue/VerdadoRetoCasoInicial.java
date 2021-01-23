package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class VerdadoRetoCasoInicial extends AppCompatActivity {

    private TextView Jugador;
    private ArrayList<String> Jugadores;
    private Button VerdadButton;
    private Button RetoButton;
    private ArrayList<String> numeross = new ArrayList<>();
    private int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdado_reto);
        Jugador = findViewById(R.id.Jugador);
        Jugadores = getIntent().getStringArrayListExtra("playerList");

        generarRandom();

        Jugador.setText(Jugadores.get(n));

        VerdadButton = findViewById(R.id.VerdadButton);
        RetoButton = findViewById(R.id.RetoButton);

        VerdadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerdadoRetoCasoInicial.this, VerdadoRetoContinuo.class);
                intent.putExtra("VerdadOReto", "verdad");
                intent.putStringArrayListExtra("jugadores", Jugadores);
                intent.putExtra("PrimerJugador", Jugadores.get(n));
                startActivity(intent);
            }
        });

        RetoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerdadoRetoCasoInicial.this, VerdadoRetoContinuo.class);
                intent.putExtra("VerdadOReto", "reto");
                intent.putStringArrayListExtra("jugadores", Jugadores);
                startActivity(intent);
            }
        });
    }


    public void generarRandom() {
        boolean ha_salido = false;
        double m = Math.random()*Jugadores.size()+0;
        n = (int) m;
        String n_string = Integer.toString(n);

        if (numeross.size()==0) {
            numeross.add(n_string);
            ha_salido = false;
        }
        else if(numeross.size()==Jugadores.size()) ha_salido=false;
        else {
            for (int k = 0; k < numeross.size(); ++k) {
                if (numeross.get(k).equals(n_string)) ha_salido = true;
            }
        }
        Log.d("tamaño de NUMEROS es:", ""+numeross.size());
        if(ha_salido) generarRandom();
        else numeross.add(n_string);
    }
}