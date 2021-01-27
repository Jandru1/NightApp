package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCamino_1_3 extends AppCompatActivity {

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private Button DentroButton;
    private Button FueraButton;
    private Button SiguienteButtonn;

    private TextView pregunta;
    private TextView anteriores_cartas_fueron;

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
        setContentView(R.layout.activity_el__camino_1_3);

        DentroButton = findViewById(R.id.DentroButton);
        FueraButton = findViewById(R.id.FueraButton);
        SiguienteButtonn = findViewById(R.id.SiguienteBut);

        anteriores_cartas_fueron = findViewById(R.id.TextView3);
        pregunta = findViewById(R.id.TextView4);

        jugador_jugando = findViewById(R.id.PlayerText);
        cartaTextView = findViewById(R.id.Cartas);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        intent = new Intent(ElCamino_1_3.this, ElCamino_1_4.class);

        Primer_caso();
    }

    private void Primer_caso() {
        jugador_jugando.setText(Jugadores.get(k));
        pregunta.setText("¿La siguiente estara dentro o fuera del intervalo?");
        anteriores_cartas_fueron.setText("Tus anteriores cartas fueron:");
        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);

        if(bundle!=null) {
            BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
            carta_anterior1 = BP.getBaraja().get(0);
            carta_anterior2 = BP.getBaraja().get(1);
            cartaTextView.setText(carta_anterior1 + " y " + carta_anterior2);
        }

        DentroButton.setVisibility(View.VISIBLE);
        FueraButton.setVisibility(View.VISIBLE);
        SiguienteButtonn.setVisibility(View.INVISIBLE);

        DentroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dentro_o_fuera = "dentro";
                enseñar_carta(dentro_o_fuera);
            }
        });

        FueraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dentro_o_fuera = "fuera";
                enseñar_carta(dentro_o_fuera);
            }
        });


    }

    private void enseñar_carta(String dentro_o_fuera) {
        generarRandom(); //Hay que descartar los que ya salieron antes!!!!
        String carta = Baraja.getBaraja().get(n);
        Log.d("CARTA 3: "+ carta + "Jugador", " "+Jugadores.get(k));

        String num_nuevo = Baraja.get_num(n);
        String num_antiguo1 = Baraja.get_num_por_carta(carta_anterior1);
        String num_antiguo2 = Baraja.get_num_por_carta(carta_anterior2);

        DentroButton.setVisibility(View.INVISIBLE);
        FueraButton.setVisibility(View.INVISIBLE);
        SiguienteButtonn.setVisibility(View.VISIBLE);

        int num_antiguo1_int = Integer.parseInt(transform_JQK(num_antiguo1));
        int num_antiguo2_int = Integer.parseInt(transform_JQK(num_antiguo2));
        int num_nuevo_int = Integer.parseInt(transform_JQK(num_nuevo));

        boolean soniguales = false;

        if (num_antiguo1.equals(num_nuevo) || num_antiguo2.equals(num_nuevo)){
            soniguales=true;
            enseñar_carta(dentro_o_fuera);
        }
        else if (dentro_o_fuera.equals("dentro")) {
            if (num_antiguo1_int > num_nuevo_int & num_antiguo2_int < num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ num_nuevo +". Repartes 3 tragos");
            }
            else if (num_antiguo1_int < num_nuevo_int & num_antiguo2_int > num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ num_nuevo +". Repartes 3 tragos");
            }
            else pregunta.setText("Lástima! La carta es un " + num_nuevo + "!");

        }
        else if (dentro_o_fuera.equals("fuera")) {
            if (num_antiguo1_int > num_nuevo_int & num_antiguo2_int > num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ num_nuevo +". Repartes 3 tragos");
            }
            else if (num_antiguo1_int < num_nuevo_int & num_antiguo2_int < num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ num_nuevo +". Repartes 3 tragos");
            }
            else pregunta.setText("Lástima! La carta es un " + num_nuevo + "!");
        }
        if(!soniguales) {
            BP.añadir_carta(carta);
            Bundle b = new Bundle();
            b.putSerializable("BarajaPersonalizada", BP);
            intent.putExtra("BarajaPers " + k, b);
        }
        SiguienteButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k+1 == Jugadores.size()) {
                    intent.putStringArrayListExtra("Players", Jugadores);
                    intent.putStringArrayListExtra("numeross", numeross);
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