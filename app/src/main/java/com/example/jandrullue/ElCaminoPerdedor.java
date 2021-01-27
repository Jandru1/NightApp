package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCaminoPerdedor extends AppCompatActivity {

    private BarajaPoker Baraja = new BarajaPoker();

    private Bundle bundle;
    private BarajaPersonalizada BP;

    private Button CartaButton;
    private Button SiguienteButton;

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();
    private ArrayList<BarajaPersonalizada> Perdedores = new ArrayList<>();

    private int n;

    private TextView PerdedoresTV;
    private TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_perdedor);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        PerdedoresTV=findViewById(R.id.PerdedorTV);
        TextView=findViewById(R.id.PerdedorTV2);

        CartaButton = findViewById(R.id.Cartabutton);
        SiguienteButton = findViewById(R.id.Siguien);

        int min = 5;
        for(int i = 0; i < Jugadores.size();++i) {
            bundle = getIntent().getExtras().getBundle("BarajaPers " + i);
            if (bundle != null) {
                BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
                for(int j = 0; j < BP.getBaraja().size();++j) {
                    Log.d("PERD Carta"+j+"JUG"+i, ""+BP.getBaraja().get(j));
                }

                if (BP.getBaraja().size() < min) {
                    min = BP.getBaraja().size();
                    if (Perdedores.size()!=0) Perdedores.clear();
                    Perdedores.add(BP);
                }
                else if (BP.getBaraja().size()== min) {
                    Perdedores.add(BP);
                }
            }
        }
        get_perdedor();
    }

    private void get_perdedor() {
        Log.d("PERDEDORES", ""+Perdedores.size());
        if(Perdedores.size()==1)  {
            CartaButton.setVisibility(View.INVISIBLE);
            PerdedoresTV.setText(Perdedores.get(0).getplayer() + " ha perdido y deberá jugar El Camino!!");
            SiguienteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ElCaminoPerdedor.this, ElCamino3.class);
                    startActivity(intent);
                }
            });
        }
        else {
            SiguienteButton.setVisibility(View.INVISIBLE);
            PerdedoresTV.setVisibility(View.INVISIBLE);
            CartaButton.setVisibility(View.VISIBLE);
            CartaButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    generarRandom();
                    CartaButton.setVisibility(View.INVISIBLE);
                    PerdedoresTV.setVisibility(View.VISIBLE);
                    PerdedoresTV.setText(Baraja.getBaraja().get(n));
                    SiguienteButton.setVisibility(View.VISIBLE);
                    alguien_la_tiene(Baraja.getBaraja().get(n));
                }
            });
            SiguienteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    get_perdedor();
                }
            });
        }
    }

    private void alguien_la_tiene(String carta) {
        boolean alguien_se_salva = false;
        ArrayList<String>Salvados = new ArrayList<>();
        for(int i = 0; i < Perdedores.size();++i) {
            BarajaPersonalizada b1 = Perdedores.get(i);
            for(int j = 0; j < b1.getBaraja().size();++j) {
                Log.d("La carta que toca es:", ""+b1.get_num(j)) ;
                if (getnum(carta).equals(b1.get_num(j))){
                    Salvados.add(b1.getplayer());
                    Perdedores.remove(i);
                    alguien_se_salva = true;
                }
            }
        }
        if(alguien_se_salva) {
            String salvados_final = null;
            if(Salvados.size()==1) salvados_final = "Se salva ";
            if(Salvados.size()> 1) salvados_final = "Se salvan ";
            for (int j = 0; j < Salvados.size();++j) {
                if(j==Salvados.size()-1) salvados_final += Salvados.get(j) + "!";
                else salvados_final+= Salvados.get(j) + " y ";

            }
            TextView.setText(salvados_final);
        }
        else TextView.setText("Nadie se salva! Toca volver a tirar.");
    }

    private String getnum(String s) {
        if(s.substring(0,1).equals("1")) { s = s.substring(0,2);}
        else s = s.substring(0,1);
        return s;
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