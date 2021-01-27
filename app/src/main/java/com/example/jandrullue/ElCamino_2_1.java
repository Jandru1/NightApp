package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCamino_2_1 extends AppCompatActivity {

    private Button Carta1;
    private Button Carta2;
    private Button Carta3;
    private Button SiguienteButtonn;

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private TextView pregunta;
    private TextView ultima_carta;

    private TextView jugador_jugando;
    private TextView cartaTextView;

    private TextView Carta1TV;
    private TextView Carta2TV;
    private TextView Carta3TV;

    private int k = 0;
    private int n;

    private BarajaPoker Baraja = new BarajaPoker();
    private Bundle bundle;

    private String carta_anterior1 = null;
    private String carta_anterior2 = null;

    private Intent intent;

    private BarajaPersonalizada BP = null;

    boolean Carta1IsClicked = false;
    boolean Carta2IsClicked = false;
    boolean Carta3IsClicked = false;

    private int Ronda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_2);

        Ronda = getIntent().getExtras().getInt("Ronda");

        Carta1 = findViewById(R.id.Carta1_1Button);
        Carta2 = findViewById(R.id.Carta1_2Button);
        Carta3 = findViewById(R.id.Carta1_3Button);
        SiguienteButtonn = findViewById(R.id.Sig);

        SiguienteButtonn.setVisibility(View.INVISIBLE);

        Carta1TV = findViewById(R.id.Carta1_1TV);
        Carta2TV = findViewById(R.id.Carta1_2TV);
        Carta3TV = findViewById(R.id.Carta1_3TV);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        init();
    }

    private void init() {

        Carta1TV.setVisibility(View.INVISIBLE);
        Carta2TV.setVisibility(View.INVISIBLE);
        Carta3TV.setVisibility(View.INVISIBLE);

        Carta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta1IsClicked = true;
                generarRandom();
                Carta1.setVisibility(View.INVISIBLE);
                Carta1TV.setVisibility(View.VISIBLE);
                Carta1TV.setText(Baraja.getBaraja().get(n));
                Aparece_SigBut();

            }
        });
        Carta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta2IsClicked = true;
                generarRandom();
                Carta2.setVisibility(View.INVISIBLE);
                Carta2TV.setVisibility(View.VISIBLE);
                Carta2TV.setText(Baraja.getBaraja().get(n));
                Aparece_SigBut();

            }
        });
        Carta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta3IsClicked = true;
                generarRandom();
                Carta3.setVisibility(View.INVISIBLE);
                Carta3TV.setVisibility(View.VISIBLE);
                Carta3TV.setText(Baraja.getBaraja().get(n));
                Aparece_SigBut();
            }
        });

        SiguienteButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElCamino_2_1.this, ElCamino2_Aux.class);
                i.putStringArrayListExtra("Players", Jugadores);
                i.putStringArrayListExtra("numeross", numeross);
                for(int j = 0; j < Jugadores.size(); ++j) {
                    bundle = getIntent().getExtras().getBundle("BarajaPers "+j);
                    if(bundle!=null) {
                        BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
                        for(int l = 0; l < BP.getBaraja().size();++l) {
                            Log.d("2_1 Carta"+l+"JUG"+j+"RONDA"+Ronda, ""+BP.getBaraja().get(l));
                        }
                        Bundle b = new Bundle();
                        b.putSerializable("BarajaPersonalizada", BP);
                        i.putExtra("BarajaPers " + j , b);
                    }
                }
                i.putExtra("Carta1", Carta1TV.getText());
                i.putExtra("Carta2", Carta2TV.getText());
                i.putExtra("Carta3", Carta3TV.getText());
                i.putExtra("Ronda", Ronda);
                startActivity(i);
            }
        });
    }

    private void Aparece_SigBut() {
        if(Carta1IsClicked & Carta2IsClicked & Carta3IsClicked){
            SiguienteButtonn.setVisibility(View.VISIBLE);
        }
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