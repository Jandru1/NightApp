package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ElCamino_1_2 extends AppCompatActivity {

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private Button MayorButton;
    private Button MenorButton;
    private Button SiguienteButtonn;

    private TextView pregunta;
    private TextView anterior_carta_fue;
    private TextView jugador_jugando;
    private TextView cartaTextView;

    private int k = 0;
    private int n;

    private BarajaPoker Baraja = new BarajaPoker();
    private Bundle bundle;

    private String carta_anterior = null;

    private Intent intent;

    private BarajaPersonalizada BP = null;
    private ImageView HomeButton;

    private ShotsCounter Shots = new ShotsCounter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
        for (Map.Entry<String, Integer> entry : Shots.getShotsMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Log.d("Hashmap "+ key, ""+value);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_1_2);

        MayorButton = findViewById(R.id.MayorButton);
        MenorButton = findViewById(R.id.MenorButton);
        SiguienteButtonn = findViewById(R.id.Siguiente);
        HomeButton = findViewById(R.id.HomeButton1_2);
        anterior_carta_fue = findViewById(R.id.TextView);
        pregunta = findViewById(R.id.TextView2);

        jugador_jugando = findViewById(R.id.PlaerText);
        cartaTextView = findViewById(R.id.Carta);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        jugador_jugando.setTypeface(robotoLight);
        cartaTextView.setTypeface(robotoLight);
        anterior_carta_fue.setTypeface(robotoLight);
        cartaTextView.setTypeface(robotoLight);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        intent = new Intent(ElCamino_1_2.this, ElCamino_1_3.class);

        Primer_caso();
    }

    private void Primer_caso() {
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_1_2.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_1_2.this, GamesModalities.class);
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
        jugador_jugando.setText(Jugadores.get(k));
        pregunta.setText("¿La siguiente es mayor o menor?");
        anterior_carta_fue.setText("Tu anterior carte fue:");
        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);

        if(bundle!=null) {
            BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
            carta_anterior = BP.getBaraja().get(0);
            cartaTextView.setText(carta_anterior);
        }

        MayorButton.setVisibility(View.VISIBLE);
        MenorButton.setVisibility(View.VISIBLE);
        SiguienteButtonn.setVisibility(View.INVISIBLE);

        MayorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mayor_o_menor = "mayor";
                enseñar_carta(mayor_o_menor);
            }
        });

        MenorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mayor_o_menor = "menor";
                enseñar_carta(mayor_o_menor);
            }
        });


    }

    private void enseñar_carta(String mayor_o_menor) {
        generarRandom(); //Hay que descartar los que ya salieron antes!!!!
        String carta = Baraja.getBaraja().get(n);
        Log.d("CARTA 2: ", carta);
        String num_nuevo = Baraja.get_num(n);
        String num_antiguo = Baraja.get_num_por_carta(carta_anterior);

        MayorButton.setVisibility(View.INVISIBLE);
        MenorButton.setVisibility(View.INVISIBLE);
        SiguienteButtonn.setVisibility(View.VISIBLE);

        int num_antiguo_int = Integer.parseInt(transform_JQK(num_antiguo));
        int num_nuevo_int = Integer.parseInt(transform_JQK(num_nuevo));

        boolean soniguales = false;

        if (num_antiguo.equals(num_nuevo)){
            soniguales = true;
            enseñar_carta(mayor_o_menor);
        }
        else if(mayor_o_menor.equals("mayor") & num_antiguo_int>num_nuevo_int){
            pregunta.setText("Lástima! La carta es un " + carta + ". Bebes 2 tragos!");
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
        }
        else if(mayor_o_menor.equals("menor") & num_antiguo_int<num_nuevo_int){
            pregunta.setText("Lástima! La carta es un " + carta + ". Bebes 2 tragos!");
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
        }
        else if(mayor_o_menor.equals("mayor") & num_antiguo_int<num_nuevo_int){
            pregunta.setText("Felicidades! Un " + carta + ". Repartes 2 tragos!");
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
        }
        else if(mayor_o_menor.equals("menor") & num_antiguo_int>num_nuevo_int){
            pregunta.setText("Felicidades! Un "+ carta +". Repartes 2 tragos!");
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
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