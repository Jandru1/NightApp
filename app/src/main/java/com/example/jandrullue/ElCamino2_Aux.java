package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class ElCamino2_Aux extends AppCompatActivity {

    private TextView PlayerTV;
    private TextView Deshacer_cartasTV;

    private Button SiguienteButton;

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private int k = 0;

    private Bundle bundle;

    private BarajaPersonalizada BP = null;

    private String Carta_a_deshacer1 = null;
    private String Carta_a_deshacer2 = null;
    private String Carta_a_deshacer3 = null;
    private String Carta_a_deshacer4 = null;

    private int Ronda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino2__aux);

        PlayerTV = findViewById(R.id.JugadorTV);
        Deshacer_cartasTV = findViewById(R.id.TV);

        SiguienteButton = findViewById(R.id.Sigui);
        Ronda = getIntent().getExtras().getInt("Ronda");
        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);
        if(bundle!=null) {
             BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
        }
        Deshacer_Cartas(k, BP);
    }

    private void Deshacer_Cartas(int x, BarajaPersonalizada BP) {

        PlayerTV.setText(Jugadores.get(x));

        int cartas_a_deshacer = 0;

        for(int j = 0; j < BP.getBaraja().size(); ++j) {
          //  Log.d("El tamaño de baraja es:", String.valueOf(BP.getBaraja().size()));
            String a = BP.get_num(j);
            String b1 = getnum(getIntent().getExtras().getString("Carta1"));
            String b2 = getnum(getIntent().getExtras().getString("Carta2"));
            String b3 = getnum(getIntent().getExtras().getString("Carta3"));

            if(a.equals(b1)){
                ++cartas_a_deshacer;
                if(cartas_a_deshacer ==1)  Carta_a_deshacer1 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==2)  Carta_a_deshacer2 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==3)  Carta_a_deshacer3 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==4)  Carta_a_deshacer4 = BP.getBaraja().get(j);
                a = "null";
                BP.getBaraja().remove(j);
            }
            if(a.equals(b2)){
                ++cartas_a_deshacer;
                if(cartas_a_deshacer ==1)  Carta_a_deshacer1 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==2)  Carta_a_deshacer2 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==3)  Carta_a_deshacer3 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==4)  Carta_a_deshacer4 = BP.getBaraja().get(j);
                a = "null";
                BP.getBaraja().remove(j);
            }
            if(a.equals(b3)){
                ++cartas_a_deshacer;
                if(cartas_a_deshacer ==1)  Carta_a_deshacer1 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==2)  Carta_a_deshacer2 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==3)  Carta_a_deshacer3 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==4)  Carta_a_deshacer4 = BP.getBaraja().get(j);
                a = "null";
                BP.getBaraja().remove(j);
            }
        }
        if(cartas_a_deshacer>0){
            if (cartas_a_deshacer==1) Deshacer_cartasTV.setText("Felicidades! Te puedes deshacer del "+ Carta_a_deshacer1 + " y repartir "+cartas_a_deshacer*Ronda+ " tragos!");
            if (cartas_a_deshacer==2) Deshacer_cartasTV.setText("Felicidades! Te puedes deshacer del "+ Carta_a_deshacer1 + " y del " + Carta_a_deshacer2 + " y repartir "+cartas_a_deshacer*Ronda+ " tragos!");
            if (cartas_a_deshacer==3) Deshacer_cartasTV.setText("Felicidades! Te puedes deshacer del "+ Carta_a_deshacer1 + ", del " + Carta_a_deshacer2 + " y del " + Carta_a_deshacer3 + " y repartir "+cartas_a_deshacer*Ronda+ " tragos!");
            if (cartas_a_deshacer==4) Deshacer_cartasTV.setText("Felicidades! Te puedes deshacer del "+ Carta_a_deshacer1 + ", del " + Carta_a_deshacer2 + ", del " + Carta_a_deshacer3 + " y del " + Carta_a_deshacer4 + " y repartir "+cartas_a_deshacer*Ronda+ " tragos!");

        }
        else Deshacer_cartasTV.setText("Lastima! No puedes deshacerte de ninguna");

        SiguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k+1 == Jugadores.size()) {
                    if (Ronda == 4) {
                        Intent intent = new Intent(ElCamino2_Aux.this, ElCaminoPerdedor.class);
                        intent.putStringArrayListExtra("Players", Jugadores);
                        intent.putStringArrayListExtra("numeross", numeross);
                        for (int j = 0; j < Jugadores.size(); ++j) {
                            bundle = getIntent().getExtras().getBundle("BarajaPers " + j);
                            if (bundle != null) {
                                BarajaPersonalizada BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
                                Bundle b = new Bundle();
                                b.putSerializable("BarajaPersonalizada", BP);
                                intent.putExtra("BarajaPers " + j, b);
                            }
                        }
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(ElCamino2_Aux.this, ElCamino_2_1.class);
                        intent.putStringArrayListExtra("Players", Jugadores);
                        intent.putStringArrayListExtra("numeross", numeross);
                        intent.putExtra("Ronda", Ronda + 1);

                        for (int j = 0; j < Jugadores.size(); ++j) {
                            bundle = getIntent().getExtras().getBundle("BarajaPers " + j);
                            if (bundle != null) {
                                BarajaPersonalizada BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
                                Bundle b = new Bundle();
                                b.putSerializable("BarajaPersonalizada", BP);
                                intent.putExtra("BarajaPers " + j, b);
                            }
                        }
                        startActivity(intent);
                    }
                }
                else {
                    ++k;
                    bundle = getIntent().getExtras().getBundle("BarajaPers "+k);
                    BarajaPersonalizada BP = new BarajaPersonalizada();
                    if(bundle!=null) {
                        BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
                    }
                    Deshacer_Cartas(k, BP);
                }

            }
        });
    }

    private String getnum(String s) {
        if(s.substring(0,1).equals("1")) { s = s.substring(0,2);}
        else s = s.substring(0,1);
        return s;
    }
}