package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class VerdadoRetoContinuo extends AppCompatActivity {

    private ArrayList<String> Players = new ArrayList<String>();
    private String Verdad_o_Reto;
    private ArrayList <String> VerdadList = new ArrayList<String>();;
    private ArrayList<String> RetosList = new ArrayList<String>();;
    private TextView SiguienteJugador;
    private TextView JugadorJugando;
    private TextView Texto;
    private View layout;
    private ArrayList<String> numeross_Player = new ArrayList<>();
    private ArrayList<String> numeross_Verdad = new ArrayList<>();
    private ArrayList<String> numeross_Reto = new ArrayList<>();

    private int n_Player;
    private int n_Verdad;
    private int n_Reto;
    private String Primer_jugador;

    private Button VerdadButton;
    private Button RetoButton;

    private boolean es_un_reto;
    private int i;

    private VerdadoRetoClass VoR = new VerdadoRetoClass();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdado_reto_continuo);
        VerdadList = VoR.getVerdades();
        RetosList = VoR.getRetos();

        Players = getIntent().getStringArrayListExtra("jugadores");
        Verdad_o_Reto = getIntent().getExtras().getString("VerdadOReto");
        Primer_jugador = getIntent().getExtras().getString("PrimerJugador");
        SiguienteJugador = findViewById(R.id.JugadorSiguiente);
        JugadorJugando = findViewById(R.id.JugadorJugando);
        Texto = findViewById(R.id.RetoOVerdad);
        layout = findViewById(R.id.Layout);

        VerdadButton = findViewById(R.id.verdadButton);
        RetoButton = findViewById(R.id.retoButton);

        if(Verdad_o_Reto.equals("verdad")){
            generarRandomVerdad();
            String verdad = VoR.getVerdades().get(n_Verdad);
            Texto.setText(verdad);
        }
        else {
            generarRandomReto();
            String reto = VoR.getVerdades().get(n_Reto);
            Texto.setText(reto);
        }

        i = 0;
        init();
    }

    private void init() {
        generarRandomPlayer();
        //False -> Verdad. True -> Reto
        if(i > 0){
            if(es_un_reto){
                generarRandomReto();
                String reto = VoR.getRetos().get(n_Reto);
                Texto.setText(reto);
            }
            else {
                generarRandomVerdad();
                String verdad = VoR.getVerdades().get(n_Verdad);
                Texto.setText(verdad);
            }
        }
        ++i;
        SiguienteJugador.setText(Players.get(n_Player));
        JugadorJugando.setText(Primer_jugador);

        VerdadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Primer_jugador = Players.get(n_Player);
                es_un_reto = false;
                init();
            }
        });

        RetoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Primer_jugador = Players.get(n_Player);
                es_un_reto = true;
                init();
            }
        });
    }

    public void generarRandomPlayer() {
        boolean ha_salido = false;
        double m = Math.random()*Players.size()+0;
        n_Player = (int) m;
        String n_string = Integer.toString(n_Player);

        if(numeross_Player.size()==Players.size()) {
            ha_salido=false;
            ArrayList<String> VaciamosList = new ArrayList<String >();
            numeross_Player = VaciamosList;
        }

        if (numeross_Player.size()==0) {
            numeross_Player.add(n_string);
            ha_salido = false;
        }

        else {
            for (int k = 0; k < numeross_Player.size(); ++k) {
                if (numeross_Player.get(k).equals(n_string)) ha_salido = true;
            }
        }
        Log.d("tamaño de NUMEROS es:", ""+ numeross_Player.size());
        if(ha_salido) generarRandomPlayer();
        else numeross_Player.add(n_string);
    }


    public void generarRandomVerdad() {
        boolean ha_salido = false;
        double m = Math.random()*VerdadList.size()+0;
        n_Verdad = (int) m;
        String n_string = Integer.toString(n_Verdad);

        if(numeross_Verdad.size()==VerdadList.size()){
            ha_salido=false;
            ArrayList<String> VaciamosList = new ArrayList<String >();
            numeross_Verdad = VaciamosList;
        }

        if (numeross_Verdad.size()==0) {
            numeross_Verdad.add(n_string);
            ha_salido = false;
        }
        else {
            for (int k = 0; k < numeross_Verdad.size(); ++k) {
                if (numeross_Verdad.get(k).equals(n_string)) ha_salido = true;
            }
        }
        Log.d("tamaño de NUMEROS es:", ""+numeross_Verdad.size());
        if(ha_salido) generarRandomVerdad();
        else numeross_Verdad.add(n_string);
    }

    public void generarRandomReto() {
        boolean ha_salido = false;
        double m = Math.random()*RetosList.size()+0;
        n_Reto = (int) m;
        String n_string = Integer.toString(n_Reto);

        if(numeross_Reto.size()==RetosList.size()) {
            ha_salido=false;
            ArrayList<String> VaciamosList = new ArrayList<String >();
            numeross_Reto = VaciamosList;
        }

        if (numeross_Reto.size()==0) {
            numeross_Reto.add(n_string);
            ha_salido = false;
        }
        else {
            for (int k = 0; k < numeross_Reto.size(); ++k) {
                if (numeross_Reto.get(k).equals(n_string)) ha_salido = true;
            }
        }
        Log.d("tamaño de NUMEROS es:", ""+numeross_Reto.size());
        if(ha_salido) generarRandomReto();
        else numeross_Reto.add(n_string);
    }
}