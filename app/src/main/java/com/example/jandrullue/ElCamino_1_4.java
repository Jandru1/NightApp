package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCamino_1_4 extends AppCompatActivity {

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private Button DiamanteButton;
    private Button CorazonesButton;
    private Button PicasButton;
    private Button TrebolesButton;
    private Button SiguienteButtonn;

    private TextView pregunta;
    private TextView ultima_carta;

    private TextView jugador_jugando;
    private TextView cartaTextView;

    private int k = 0;
    private int n;

    private BarajaPoker Baraja = new BarajaPoker();
    private Bundle bundle;

    private String carta_anterior1 = null;
    private String carta_anterior2 = null;

    private Intent intent;

    private BarajaPersonalizada BP = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_1_4);

        DiamanteButton = findViewById(R.id.DiamanteButton);
        PicasButton = findViewById(R.id.PicasButton);
        CorazonesButton = findViewById(R.id.CorazonesButton);
        TrebolesButton = findViewById(R.id.TrebolesButton);
        SiguienteButtonn = findViewById(R.id.SigBut);

        ultima_carta = findViewById(R.id.UltimaCartaTextView);
        pregunta = findViewById(R.id.PaloTextView);
        jugador_jugando = findViewById(R.id.jugadorTextView);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        intent = new Intent(ElCamino_1_4.this, ElCamino_2_1.class);

        Primer_caso();
    }

    private void Primer_caso() {
        jugador_jugando.setText(Jugadores.get(k));
        pregunta.setText("¿A qué palo pertenece?");
        ultima_carta.setText("Tu última carta!");
        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);

        if(bundle!=null) {
            BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
        }

        DiamanteButton.setVisibility(View.VISIBLE);
        CorazonesButton.setVisibility(View.VISIBLE);
        TrebolesButton.setVisibility(View.VISIBLE);
        PicasButton.setVisibility(View.VISIBLE);
        SiguienteButtonn.setVisibility(View.INVISIBLE);

        DiamanteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palo = "diamantes";
                enseñar_carta(palo);
            }
        });

        CorazonesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palo = "corazones";
                enseñar_carta(palo);
            }
        });

        PicasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palo = "picas";
                enseñar_carta(palo);
            }
        });

        TrebolesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palo = "treboles";
                enseñar_carta(palo);
            }
        });


    }

    private void enseñar_carta(String palo) {
        generarRandom(); //Hay que descartar los que ya salieron antes!!!!
        String carta = Baraja.getBaraja().get(n);
        Log.d("CARTA 4: ", ""+carta);

        String palo_final = Baraja.get_palo(n);

        if(palo.equals(palo_final)) {
            pregunta.setText("Felicidades! Un "+ carta +". Repartes 3 tragos");
        }
        else pregunta.setText("Lástima! La carta es un " + carta + "!");

        DiamanteButton.setVisibility(View.INVISIBLE);
        CorazonesButton.setVisibility(View.INVISIBLE);
        TrebolesButton.setVisibility(View.INVISIBLE);
        PicasButton.setVisibility(View.INVISIBLE);
        SiguienteButtonn.setVisibility(View.VISIBLE);

        BP.añadir_carta(carta);
        Bundle b = new Bundle();
        b.putSerializable("BarajaPersonalizada", BP);

        intent.putExtra("BarajaPers " + k , b);

        SiguienteButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k+1 == Jugadores.size()) {
                    intent.putStringArrayListExtra("Players", Jugadores);
                    intent.putStringArrayListExtra("numeross", numeross);
                    intent.putExtra("Ronda", 1);
                    startActivity(intent);
                }
                else {
                    ++k;
                    Primer_caso();
                }
            }
        });
    }

    private String transform_JQK(String s) {
        String a = null;
        if (s.equals("J")) a = "11";
        else if (s.equals("Q")) a = "12";
        else if (s.equals("K")) a = "13";
        else if (s.equals("A")) a = "14";
        else a = s;
        return a;
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