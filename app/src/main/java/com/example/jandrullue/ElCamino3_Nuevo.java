package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ElCamino3_Nuevo extends AppCompatActivity {

    private boolean level1_superado = false;
    private boolean level2_superado = false;
    private boolean level3_superado = false;
    private boolean level4_superado = false;

    private ImageView Carta1L1;
    private ImageView Carta1L2;
    private ImageView Carta2L1;
    private ImageView Carta1L3;
    private ImageView Carta2L3;
    private ImageView Carta3L3;
    private ImageView Carta1L4;
    private ImageView Carta2L4;
    private ImageView Carta3L4;
    private ImageView Carta4L4;
    private ImageView Carta1L5;
    private ImageView Carta2L5;
    private ImageView Carta3L5;
    private ImageView Carta1L6;
    private ImageView Carta2L6;
    private ImageView Carta1L7;

    private ArrayList<String> Jugadores;

    private Button SiButton;
    private Button NoButton;

    private Button TraspasarButton;

    private TextView JugadorTV;
    private TextView CartaFinal;
    private TextView Avanzar_o_no;
    private TextView F_o_L;

    private int Level;
    private int n;

    private String Perdedor;

    private BarajaPoker Baraja = new BarajaPoker();
    private ArrayList<String> numeross = new ArrayList<>();

    private View layout;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino3__nuevo);

        //Carta1 = findViewById(R.id.C1L1);
        /*
        Carta2 = findViewById(R.id.C2Button2);
        Carta3 = findViewById(R.id.C3Button2);
        Carta4 = findViewById(R.id.C4Button2);
        Carta5 = findViewById(R.id.C7Button2);
        Carta6 = findViewById(R.id.c7Button3);
        Carta7 = findViewById(R.id.C8Button2);
        Carta8 = findViewById(R.id.C9Button2);
        Carta9 = findViewById(R.id.C10Button2);
        Carta10 = findViewById(R.id.C11Button2);

         */
/*
        SiButton = findViewById(R.id.SiButton2);
        NoButton = findViewById(R.id.NoButton2);
        TraspasarButton = findViewById(R.id.TraspasarButton2);
        JugadorTV = findViewById(R.id.player2);
        CartaFinal = findViewById(R.id.CartaFinalTV2);
        Avanzar_o_no = findViewById(R.id.Avanzar_o_noTV2);
        F_o_L = findViewById(R.id.FoLTV2);
        spinner = (Spinner) findViewById(R.id.spinner2);
        JugadorTV = findViewById(R.id.player2);
        CartaFinal = findViewById(R.id.CartaFinalTV2);
        Avanzar_o_no = findViewById(R.id.Avanzar_o_noTV2);
        F_o_L = findViewById(R.id.FoLTV2);

        layout = findViewById(R.id.ElCamino3L2);

        Jugadores = getIntent().getStringArrayListExtra("Jugadores");

        // String[] valores = {"Soy una persona mayor", "Problemas inmunológicos", "Otros"};
        String [] valores = Jugadores.toArray(new String[Jugadores.size()]);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));

        layout = findViewById(R.id.ElCamino3L2);

        Perdedor = getIntent().getExtras().getString("Perdedor");
        Level = getIntent().getExtras().getInt("Level");

        init(Level);

 */

    }

    private void init(int level) {
        Log.d ("Perdedor:", ""+Perdedor);
/*
        JugadorTV.setText(Perdedor);
        Carta1.setVisibility(View.INVISIBLE);
        Carta2.setVisibility(View.INVISIBLE);
        Carta3.setVisibility(View.INVISIBLE);
        Carta4.setVisibility(View.INVISIBLE);
        Carta5.setVisibility(View.INVISIBLE);
        Carta6.setVisibility(View.INVISIBLE);
        Carta7.setVisibility(View.INVISIBLE);
        SiButton.setVisibility(View.INVISIBLE);
        NoButton.setVisibility(View.INVISIBLE);
        TraspasarButton.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);
        CartaFinal.setVisibility(View.INVISIBLE);
        Avanzar_o_no.setVisibility(View.INVISIBLE);
        F_o_L.setVisibility(View.INVISIBLE);
        Avanzar_o_no.setTextSize(38);

        if(level==1) Level1();
        else if (level == 2) Level2();
        else if (level == 3) Level3();
        else if (level == 4) Level4();
        else if (level == 5) Level5();
        else if (level == 6) Level6();
        else if (level == 7) Level7();
        else {
            Intent intent = new Intent(ElCamino3_Nuevo.this, ElCaminoCampeon.class);
            intent.putExtra("Ganador", ""+Perdedor);
            startActivity(intent);
        }
        */
        Carta1L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarRandom();
                String carta = Baraja.getBaraja().get(n);
                boolean Figura = es_Figura(carta);
                if(Figura){
                    F_o_L.setText("Lástima!");
                    Avanzar_o_no.setText("Debes volver a empezar");
                    Level = 1;
                    layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            init(Level);
                        }
                    });
                }
                else {
                    boolean es_7 = es_7(carta);
                    if (es_7) {
                        traspasar_El_Camino();
                    }
                    else {
                        F_o_L.setText("Felicidades!");
                        Avanzar_o_no.setText("Puedes avanzar al nivel " + (Level + 1) + "!");
                        ++Level;
                        layout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                init(Level);
                            }
                        });
                    }
                }
            }
        });
    }
/*
    private void Level7() {
        Level1();
    }

    private void Level6() {
        Level2();
    }

    private void Level5() {
        Level3();
    }

    private void Level4() {
        Carta6.setVisibility(View.VISIBLE);
        Carta2.setVisibility(View.VISIBLE);
        Carta3.setVisibility(View.VISIBLE);
        Carta7.setVisibility(View.VISIBLE);
        Carta6.setText("Carta 1");
        Carta2.setText("Carta 2");
        Carta3.setText("Carta 3");
        Carta7.setText("Carta 3");

        Carta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta6.setVisibility(View.INVISIBLE);
                Carta2.setVisibility(View.INVISIBLE);
                Carta3.setVisibility(View.INVISIBLE);
                Carta7.setVisibility(View.INVISIBLE);
                onClickCarta();

            }
        });
        Carta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta6.setVisibility(View.INVISIBLE);
                Carta2.setVisibility(View.INVISIBLE);
                Carta3.setVisibility(View.INVISIBLE);
                Carta7.setVisibility(View.INVISIBLE);
                onClickCarta();
            }
        });
        Carta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta6.setVisibility(View.INVISIBLE);
                Carta2.setVisibility(View.INVISIBLE);
                Carta3.setVisibility(View.INVISIBLE);
                Carta7.setVisibility(View.INVISIBLE);
                onClickCarta();
            }
        });
        Carta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta6.setVisibility(View.INVISIBLE);
                Carta2.setVisibility(View.INVISIBLE);
                Carta3.setVisibility(View.INVISIBLE);
                Carta7.setVisibility(View.INVISIBLE);
                onClickCarta();
            }
        });
    }

    private void Level3() {
        Carta4.setVisibility(View.VISIBLE);
        Carta1.setVisibility(View.VISIBLE);
        Carta5.setVisibility(View.VISIBLE);
        Carta4.setText("Carta 1");
        Carta1.setText("Carta 2");
        Carta5.setText("Carta 3");

        Carta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta4.setVisibility(View.INVISIBLE);
                Carta5.setVisibility(View.INVISIBLE);
                Carta1.setVisibility(View.INVISIBLE);
                onClickCarta();

            }
        });

        Carta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta4.setVisibility(View.INVISIBLE);
                Carta5.setVisibility(View.INVISIBLE);
                Carta1.setVisibility(View.INVISIBLE);
                onClickCarta();

            }
        });

        Carta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta4.setVisibility(View.INVISIBLE);
                Carta5.setVisibility(View.INVISIBLE);
                Carta1.setVisibility(View.INVISIBLE);
                onClickCarta();

            }
        });


    }

    private void Level2() {
        Carta2.setVisibility(View.VISIBLE);
        Carta3.setVisibility(View.VISIBLE);
        Carta2.setText("Carta 1");
        Carta3.setText("Carta 2");

        Carta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta2.setVisibility(View.INVISIBLE);
                Carta3.setVisibility(View.INVISIBLE);

                onClickCarta();
            }
        });
        Carta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta2.setVisibility(View.INVISIBLE);
                Carta3.setVisibility(View.INVISIBLE);
                onClickCarta();
            }
        });
    }

    private void Level1() {
        Carta1.setVisibility(View.VISIBLE);
        Carta1.setText("Carta 1");
        Carta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta1.setVisibility(View.INVISIBLE);
                onClickCarta();
            }
        });
    }

 */

    private void onClickCarta() {
        CartaFinal.setVisibility(View.VISIBLE);
        Avanzar_o_no.setVisibility(View.VISIBLE);
        F_o_L.setVisibility(View.VISIBLE);
        generarRandom();
        String carta = Baraja.getBaraja().get(n);
        CartaFinal.setText(carta);
        boolean Figura = es_Figura(carta);
        if(Figura){
            F_o_L.setText("Lástima!");
            Avanzar_o_no.setText("Debes volver a empezar");
            Level = 1;
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    init(Level);
                }
            });
        }
        else {
            boolean es_7 = es_7(carta);
            if (es_7) {
                traspasar_El_Camino();
            }
            else {
                F_o_L.setText("Felicidades!");
                Avanzar_o_no.setText("Puedes avanzar al nivel " + (Level + 1) + "!");
                ++Level;
                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        init(Level);
                    }
                });
            }
        }
    }

    private void traspasar_El_Camino() {
        SiButton.setVisibility(View.VISIBLE);
        NoButton.setVisibility(View.VISIBLE);
        F_o_L.setText("Felicidades!");
        Avanzar_o_no.setTextSize(28);
        Avanzar_o_no.setText("Puedes traspasar El Camino! ¿Quieres hacerlo? Sino, puedes avanzar al nivel " + (Level + 1) + "!");

        NoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++Level;
                init(Level);
            }
        });

        SiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F_o_L.setVisibility(View.INVISIBLE);
                CartaFinal.setVisibility(View.INVISIBLE);
                Avanzar_o_no.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.VISIBLE);
                SpinnerSelected();
            }
        });
    }

    private void SpinnerSelected() {
        if (!spinner.getSelectedItem().toString().equals("")) {
            TraspasarButton.setVisibility(View.VISIBLE);
            TraspasarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Level = 1;
                    Perdedor =  spinner.getSelectedItem().toString();
                    init(Level);
                }
            });
        }

    }

    private boolean es_7(String s) {
        boolean a = false;
        String b;
        if(s.substring(0,1).equals("1")) { b = s.substring(0,2);}
        else b = s.substring(0,1);
        if(b.equals("7")) a = true;
        return a;
    }

    private boolean es_Figura(String s) {
        boolean a = false;
        String b;
        if(s.substring(0,1).equals("1")) { b = s.substring(0,2);}
        else b = s.substring(0,1);
        if(b.equals("A") || b.equals("J") || b.equals("K") || b.equals("Q")) a = true;
        Log.d("El numero es un :", ""+b);
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