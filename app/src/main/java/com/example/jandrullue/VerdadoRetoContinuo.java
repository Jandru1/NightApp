package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class VerdadoRetoContinuo extends AppCompatActivity {

    private ArrayList<String> PlayersList = new ArrayList<String>();
    private ArrayList<String> VerdadList = new ArrayList<String>();;
    private ArrayList<String> RetosList = new ArrayList<String>();;

    private ArrayList<String> numeross_Player = new ArrayList<>();
    private ArrayList<String> numeross_Verdad = new ArrayList<>();
    private ArrayList<String> numeross_Reto = new ArrayList<>();

    private TextView SiguienteJugador;
    private TextView JugadorJugando;
    private TextView Texto;
    private TextView nada;

    private ImageView HomeButton;

    private int n_Player;
    private int n_Verdad;
    private int n_Reto;

    private String Verdad_o_Reto;
    private String Primer_jugador;
    private String JugadorXDef;

    private Button VerdadButton;
    private Button RetoButton;

    private boolean es_un_reto;
    private int i;

    private VerdadoRetoClass VoR = new VerdadoRetoClass();

    private PlayerClass PlayerClass = new PlayerClass();

    private boolean hetero = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdado_reto_continuo);
        VerdadList = VoR.getVerdades();
        RetosList = VoR.getRetos();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Log.d("HASHMAP JUGADOR"+key+"+",""+entry.getValue());
            PlayersList.add(key);
        }

        Verdad_o_Reto = getIntent().getExtras().getString("VerdadOReto");
        Primer_jugador = getIntent().getExtras().getString("PrimerJugador");

        SiguienteJugador = findViewById(R.id.JugadorSiguiente);
        JugadorJugando = findViewById(R.id.JugadorJugando);
        Texto = findViewById(R.id.RetoOVerdad);
        nada = findViewById(R.id.nada);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        SiguienteJugador.setTypeface(robotoLight);
        JugadorJugando.setTypeface(robotoLight);
        Texto.setTypeface(robotoLight);
        nada.setTypeface(robotoLight);

        Log.d("El Primer jugador es", ""+ Primer_jugador);
        Log.d("El Primer VoR es:", ""+ Verdad_o_Reto);

        VerdadButton = findViewById(R.id.verdadButton);
        RetoButton = findViewById(R.id.retoButton);
        HomeButton = findViewById(R.id.HomeButton);

        Typeface robotoLight2 = Typeface.createFromAsset(getAssets(),"font/het_ja_woord.ttf");
        VerdadButton.setTypeface(robotoLight2);
        RetoButton.setTypeface(robotoLight2);

        if(Verdad_o_Reto.equals("verdad")){
            generarRandomVerdad();
            String verdad = VoR.getVerdades().get(n_Verdad);
            Texto.setText(verdad);
        }
        else {
            generarRandomReto();
            String reto = VoR.getRetos().get(n_Reto);
            if (ComprobarReto(reto)){
                String nuevo_reto = JugadorX(reto, Primer_jugador);
                reto = nuevo_reto;
            };
            Texto.setText(reto);
        }
        i = 0;
        init();
    }

    private void init() {
        Log.d("jugador jugando ", ""+Primer_jugador);
        generarRandomPlayer();
        //False -> Verdad. True -> Reto
        if(i > 0){
            if(es_un_reto){
                generarRandomReto();
                String reto = VoR.getRetos().get(n_Reto);
                if (ComprobarReto(reto)){
                    String nuevo_reto = JugadorX(reto, Primer_jugador);
                    reto = nuevo_reto;
                };
                Texto.setText(reto);
            }
            else {
                generarRandomVerdad();
                String verdad = VoR.getVerdades().get(n_Verdad);
                Texto.setText(verdad);
            }
        }
        ++i;

        SiguienteJugador.setText(PlayersList.get(n_Player));
        JugadorJugando.setText(Primer_jugador);

        VerdadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Primer_jugador = PlayersList.get(n_Player);
                es_un_reto = false;
                init();
            }
        });

        RetoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Primer_jugador = PlayersList.get(n_Player);
                es_un_reto = true;
                init();
            }
        });

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(VerdadoRetoContinuo.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(VerdadoRetoContinuo.this, GamesModalities.class);
                        intent.putExtra("Jugadores", PlayerClass);
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
    }

    private boolean ComprobarReto(String reto) {
        boolean jugador_x = false;
        if(reto.startsWith("NEPUI")){
            Log.d("Accedemos bien a NEPUI", ""+ "JEJEJEJEJE");
            jugador_x = true;
        }

        if (jugador_x) return true;
        else return false;
    }

    private String JugadorX(String reto, String jugador) {
        String nuevo_reto = "";
        Log.d("El reto es ", ""+reto);
        for(int i = 0; i < reto.length();++i){
            if(reto.startsWith("JUGADORX", i)){
                generarRandomJugadorX(jugador);
                nuevo_reto = reto.substring(6,i) + JugadorXDef + reto.substring(i+8);
                Log.d("nuevo reto :", ""+ nuevo_reto);
            }
        }
        return nuevo_reto;
    }

    public void generarRandomJugadorX(String jugador) {
        String Player_X = "ASDFF";
        if(hetero) {
            double m = Math.random() * PlayersList.size() + 0;
            int n = (int) m;
            Log.d("El jugador jugando es:", "" + jugador);
            Log.d("El jugadorX es:", "" + n);
            Log.d("Con nombre:", "+" + PlayersList.get(n) + "+");
            if (PlayersList.get(n).equals(jugador)) generarRandomJugadorX(jugador);
            else {
                int sexo1 = -1;
                int sexo2 = -2;
                boolean HayMujer = false;
                boolean HayHombre = false;
                for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    if (value == 0) HayHombre = true;
                    else if (value == 1) HayMujer = true;
                    if (key.equals(PlayersList.get(n))) sexo1 = entry.getValue();
                    else if (key.equals(jugador)) sexo2 = entry.getValue();
                }
                Log.d("sexo1", "" + sexo1);
                Log.d("sexo2", "" + sexo2);
                if (sexo1 == sexo2 & HayHombre & HayMujer) generarRandomJugadorX(jugador);
                else {
                    Log.d("jugador random ", "" + PlayersList.get(n));
                    String a = PlayersList.get(n);
                    Player_X = a;
                    JugadorXDef = Player_X;
                    Log.d("PlayerList en " + n + " es:", "" + Player_X);
                }
            }
        }
        else {
            double m = Math.random() * PlayersList.size() + 0;
            int n = (int) m;
            if (PlayersList.get(n).equals(jugador)) generarRandomJugadorX(jugador);
            else {
                Player_X = PlayersList.get(n);
                JugadorXDef = Player_X;
            }
        }
    }

    public void generarRandomPlayer() {
        boolean ha_salido = false;
        double m = Math.random()*PlayersList.size()+0;
        n_Player = (int) m;
        String n_string = Integer.toString(n_Player);

        if(numeross_Player.size()==PlayersList.size()) {
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
        if(ha_salido) generarRandomReto();
        else numeross_Reto.add(n_string);
    }
}