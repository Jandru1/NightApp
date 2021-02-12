package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCaminoPerdedor extends AppCompatActivity {

    private BarajaPoker Baraja = new BarajaPoker();

    private Bundle bundle;
    private BarajaPersonalizada BP;

    private Button CartaButton;
    private ImageButton SiguienteButton;

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();
    private ArrayList<BarajaPersonalizada> Perdedores = new ArrayList<>();

    private int n;

    private TextView PerdedoresTV;
    private TextView TextView;
    private TextView QueHacerTV;

    private ImageView HomeButton;

    private ShotsCounter Shots;

    private ArrayList<String> CartasPequesDeCadaUno = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_perdedor);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");
        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        PerdedoresTV = findViewById(R.id.PerdedorTV);
        TextView = findViewById(R.id.PerdedorTV2);
        HomeButton = findViewById(R.id.HomeButton3P);

        CartaButton = findViewById(R.id.Cartabutton);
        SiguienteButton = findViewById(R.id.Siguien);
        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        PerdedoresTV.setTypeface(robotoLight);
        TextView.setTypeface(robotoLight);
        int max = -1;
        for (int i = 0; i < Jugadores.size(); ++i) {
            bundle = getIntent().getExtras().getBundle("BarajaPers " + i);
            if (bundle != null) {
                BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
                for (int j = 0; j < BP.getBaraja().size(); ++j) {
                    Log.d("PERD Carta" + j + "JUG" + i, "" + BP.getBaraja().get(j));
                }
                if (BP.getBaraja().size() > max) {
                    max = BP.getBaraja().size();
                    if (Perdedores.size() != 0) Perdedores.clear();
                    Perdedores.add(BP);
                } else if (BP.getBaraja().size() == max) {
                    Perdedores.add(BP);
                }
            }
        }
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCaminoPerdedor.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCaminoPerdedor.this, GamesModalities.class);
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
    //    todos_tienen_la_misma_carta();
        get_perdedor();
    }
//REPASAR MUCHISIMO
    private void todos_tienen_la_misma_carta() {
        boolean la_tienen = false;
        BarajaPersonalizada b1 = Perdedores.get(0);
        ArrayList<String> Coordenadas_a_borrar = new ArrayList<>();
        for (int j = 0; j < b1.getBaraja().size(); ++j) {
            String carta = b1.get_num(j);
            ArrayList<String> Todos = new ArrayList<>();
            for (int i = 1; i < Perdedores.size(); ++i) {
                BarajaPersonalizada b2 = Perdedores.get(i);
                boolean este_lo_tiene = false;
                for (int k = 0; k < b2.getBaraja().size(); ++k) {
                    boolean nomas = false;
                    if (b2.get_num(k).equals(carta) & nomas) {
                        este_lo_tiene = true;
                        Todos.add(String.valueOf(j)+String.valueOf(i) + String.valueOf(k));
                        nomas = true;
                    }
                }
                if (!este_lo_tiene) la_tienen = false;
            }
            if (Todos.size() == Perdedores.size()) {
                la_tienen = true;
                for (int i = 0; i < Todos.size(); ++i) {
                    Coordenadas_a_borrar.add(Todos.get(i));
                }
            }
        }
        for(int i = 0; i < Coordenadas_a_borrar.size();++i) {
            String a = Coordenadas_a_borrar.get(i).substring(0,1);
            String b = Coordenadas_a_borrar.get(i).substring(1,2);
            String c = Coordenadas_a_borrar.get(i).substring(2);

            if (i==0) Perdedores.get(0).getBaraja().remove(Integer.parseInt(a));
            Perdedores.get(Integer.parseInt(b)).getBaraja().remove(Integer.parseInt(c));
        }
    }

//HASTA AQUI
    private void get_perdedor() {
        Log.d("PERDEDORES", ""+Perdedores.size());
        CartaButton.setVisibility(View.INVISIBLE);
        if(Perdedores.size()==1)  {
            PerdedoresTV.setText(Perdedores.get(0).getplayer() + " ha perdido y deberá jugar El Camino!!");
            SiguienteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ElCaminoPerdedor.this, ElCamino3_Nuevo.class);
                    intent.putExtra("Level", 1);
                    intent.putStringArrayListExtra("Jugadores", Jugadores);
                    String Perdedor = Perdedores.get(0).getplayer();
                    intent.putExtra("Perdedor", Perdedor);
                    intent.putExtra("Shots", Shots);
                    startActivity(intent);
                }
            });
        }
        else {
            /*
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
             */
            compararCartas();
        }
    }

    private void compararCartas() {
        for(int i = 0; i < Perdedores.size();++i) {
            Log.d("Perdedor "+i, ""+Perdedores.get(i).getplayer());
            BarajaPersonalizada BP = Perdedores.get(i);
            int min = 15;
            String carta = null;
            for(int j = 0; j < BP.getBaraja().size();++j) {
                int num = Integer.parseInt(transform_JQK(BP.get_num(j)));
                if (num < min) {
                    min = num;
                    carta = BP.getBaraja().get(j);
                } else if (num==min) {
                    carta = comprobarPalo(carta,BP.getBaraja().get(j));
                }
                Log.d("carta "+j, ""+BP.getBaraja().get(j));
            }
            Log.d("La carta min es", ""+carta);
            CartasPequesDeCadaUno.add(carta);
        }
        int min = 15;
        String carta_def = null;
        for(int x = 0; x < CartasPequesDeCadaUno.size();++x) {
            Log.d("Carta min de "+x, ""+CartasPequesDeCadaUno.get(x));
            if (Integer.parseInt(transform_JQK(getnum(CartasPequesDeCadaUno.get(x))))< min) {
                min = Integer.parseInt(transform_JQK(getnum(CartasPequesDeCadaUno.get(x))));
                carta_def = CartasPequesDeCadaUno.get(x);
            } else if (Integer.parseInt(transform_JQK(getnum(CartasPequesDeCadaUno.get(x))))==min) {
                carta_def = comprobarPalo(carta_def,CartasPequesDeCadaUno.get(x));
            }
        }
        Log.d("La carta más peque es", ""+carta_def);

        int aux1 = -1;
        int aux2 = -1;
        for(int i = 0; i < Perdedores.size();++i) {
            BarajaPersonalizada BP = Perdedores.get(i);
            for(int j = 0; j < BP.getBaraja().size();++j) {
                    if (BP.getBaraja().get(j).equals(carta_def)){
                        aux1 = i;
                        aux2 = j;
                    }
            }
        }

        PerdedoresTV.setText(Perdedores.get(aux1).getplayer() + " ha perdido y deberá jugar El Camino!!");
        SiguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElCaminoPerdedor.this, ElCamino3_Nuevo.class);
                intent.putExtra("Level", 1);
                intent.putStringArrayListExtra("Jugadores", Jugadores);
                String Perdedor = Perdedores.get(0).getplayer();
                intent.putExtra("Perdedor", Perdedor);
                intent.putExtra("Shots", Shots);
                startActivity(intent);
            }
        });
    }

    private String comprobarPalo(String carta1, String carta2) {
        String palo1 = get_palo(carta1);
        String palo2 = get_palo(carta2);
        int valor1 = valor_por_palo(palo1);
        int valor2 = valor_por_palo(palo2);
        if(valor2 > valor1) return carta1;
        else return carta2;
    }

    private int valor_por_palo(String palo1) {
        if(palo1.equals("treboles")) return 0;
        if(palo1.equals("picas")) return 1;
        if(palo1.equals("corazones")) return 2;
        if(palo1.equals("diamantes")) return 3;
        return 6;
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

    private String get_palo(String s) {
        if(s.substring(0,1).equals("1")) { s = s.substring(6);}
        else s = s.substring(5);
        return s;
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