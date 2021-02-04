package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ElCamino3_Nuevo extends AppCompatActivity {

    private boolean level1_superado = false;
    private boolean level2_superado = false;
    private boolean level3_superado = false;
    private boolean level4_superado = false;
    private boolean level5_superado = false;
    private boolean level6_superado = false;
    private boolean level7_superado = false;

    private ImageView Carta1L1;
    private ImageView Carta1L2;
    private ImageView Carta2L2;
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
    private ImageView HomeButton;

    private ScrollView ScrollView;

    private ArrayList<String> Jugadores;

    private TextView TragosTV;
    private TextView PlayerTV;

    private int Level;
    private int n;

    private String Perdedor;

    private BarajaPoker Baraja = new BarajaPoker();
    private ArrayList<String> numeross = new ArrayList<>();

    private View layout;

    private boolean quefuncioneellayout;

    private ArrayList<ImageView> Cartas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino3__nuevo);
        Level = 1;
        //Carta1 = findViewById(R.id.C1L1);

        Carta1L1 = findViewById(R.id.C1L1);
        Carta1L2 = findViewById(R.id.C1L2);
        Carta1L3 = findViewById(R.id.C1L3);
        Carta1L4 = findViewById(R.id.C1L4);
        Carta1L5 = findViewById(R.id.C1L5);
        Carta1L6 = findViewById(R.id.C1L6);
        Carta1L7 = findViewById(R.id.C1L7);
        Carta2L2 = findViewById(R.id.C2L2);
        Carta2L3 = findViewById(R.id.C2L3);
        Carta2L4 = findViewById(R.id.C2L4);
        Carta2L5 = findViewById(R.id.C2L5);
        Carta2L6 = findViewById(R.id.C2L6);
        Carta3L3 = findViewById(R.id.C3L3);
        Carta3L4 = findViewById(R.id.C3L4);
        Carta3L5 = findViewById(R.id.C3L5);
        Carta4L4 = findViewById(R.id.C4L4);

        HomeButton = findViewById(R.id.HomeButton32);

        Cartas_ArrayList();
        
        layout = findViewById(R.id.ElCamino3L2);
        ScrollView = findViewById(R.id.ElCaminoScrollView);

        TragosTV = findViewById(R.id.TragosTV);
        PlayerTV = findViewById(R.id.playerTV);

        Jugadores = getIntent().getStringArrayListExtra("Jugadores");
        Perdedor = getIntent().getExtras().getString("Perdedor");

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        TragosTV.setTypeface(robotoLight);
        PlayerTV.setTypeface(robotoLight);

        init2(Level);
    }

    private void Cartas_ArrayList() {
        Cartas.add(Carta1L1);
        Cartas.add(Carta1L2);
        Cartas.add(Carta2L2);
        Cartas.add(Carta1L3);
        Cartas.add(Carta2L3);
        Cartas.add(Carta3L3);
        Cartas.add(Carta1L4);
        Cartas.add(Carta2L4);
        Cartas.add(Carta3L4);
        Cartas.add(Carta4L4);
        Cartas.add(Carta1L5);
        Cartas.add(Carta2L5);
        Cartas.add(Carta3L5);
        Cartas.add(Carta1L6);
        Cartas.add(Carta2L6);
        Cartas.add(Carta1L7);

    }

    private void enable_all() {
        Carta1L1.setEnabled(true);
        Carta1L2.setEnabled(true);
        Carta2L2.setEnabled(true);
        Carta1L3.setEnabled(true);
        Carta2L3.setEnabled(true);
        Carta3L3.setEnabled(true);
        Carta1L4.setEnabled(true);
        Carta2L4.setEnabled(true);
        Carta3L4.setEnabled(true);
        Carta4L4.setEnabled(true);
        Carta1L5.setEnabled(true);
        Carta2L5.setEnabled(true);
        Carta3L5.setEnabled(true);
        Carta1L6.setEnabled(true);
        Carta2L6.setEnabled(true);
        Carta1L7.setEnabled(true);
    }

    private void enable_level1() {
        Carta1L1.setEnabled(true);
        Carta1L2.setEnabled(false);
        Carta2L2.setEnabled(false);
        Carta1L3.setEnabled(false);
        Carta2L3.setEnabled(false);
        Carta3L3.setEnabled(false);
        Carta1L4.setEnabled(false);
        Carta2L4.setEnabled(false);
        Carta3L4.setEnabled(false);
        Carta4L4.setEnabled(false);
        Carta1L5.setEnabled(false);
        Carta2L5.setEnabled(false);
        Carta3L5.setEnabled(false);
        Carta1L6.setEnabled(false);
        Carta2L6.setEnabled(false);
        Carta1L7.setEnabled(false);
    }

    private void enable_level2() {
        Carta1L1.setEnabled(false);
        Carta1L2.setEnabled(true);
        Carta2L2.setEnabled(true);
        Carta1L3.setEnabled(false);
        Carta2L3.setEnabled(false);
        Carta3L3.setEnabled(false);
        Carta1L4.setEnabled(false);
        Carta2L4.setEnabled(false);
        Carta3L4.setEnabled(false);
        Carta4L4.setEnabled(false);
        Carta1L5.setEnabled(false);
        Carta2L5.setEnabled(false);
        Carta3L5.setEnabled(false);
        Carta1L6.setEnabled(false);
        Carta2L6.setEnabled(false);
        Carta1L7.setEnabled(false);
    }

    private void enable_level3() {
        Carta1L1.setEnabled(false);
        Carta1L2.setEnabled(false);
        Carta2L2.setEnabled(false);
        Carta1L3.setEnabled(true);
        Carta2L3.setEnabled(true);
        Carta3L3.setEnabled(true);
        Carta1L4.setEnabled(false);
        Carta2L4.setEnabled(false);
        Carta3L4.setEnabled(false);
        Carta4L4.setEnabled(false);
        Carta1L5.setEnabled(false);
        Carta2L5.setEnabled(false);
        Carta3L5.setEnabled(false);
        Carta1L6.setEnabled(false);
        Carta2L6.setEnabled(false);
        Carta1L7.setEnabled(false);
    }

    private void enable_level4() {
        Carta1L1.setEnabled(false);
        Carta1L2.setEnabled(false);
        Carta2L2.setEnabled(false);
        Carta1L3.setEnabled(false);
        Carta2L3.setEnabled(false);
        Carta3L3.setEnabled(false);
        Carta1L4.setEnabled(true);
        Carta2L4.setEnabled(true);
        Carta3L4.setEnabled(true);
        Carta4L4.setEnabled(true);
        Carta1L5.setEnabled(false);
        Carta2L5.setEnabled(false);
        Carta3L5.setEnabled(false);
        Carta1L6.setEnabled(false);
        Carta2L6.setEnabled(false);
        Carta1L7.setEnabled(false);
    }

    private void enable_level5() {
        Carta1L1.setEnabled(false);
        Carta1L2.setEnabled(false);
        Carta2L2.setEnabled(false);
        Carta1L3.setEnabled(false);
        Carta2L3.setEnabled(false);
        Carta3L3.setEnabled(false);
        Carta1L4.setEnabled(false);
        Carta2L4.setEnabled(false);
        Carta3L4.setEnabled(false);
        Carta4L4.setEnabled(false);
        Carta1L5.setEnabled(true);
        Carta2L5.setEnabled(true);
        Carta3L5.setEnabled(true);
        Carta1L6.setEnabled(false);
        Carta2L6.setEnabled(false);
        Carta1L7.setEnabled(false);
    }

    private void enable_level6() {
        Carta1L1.setEnabled(false);
        Carta1L2.setEnabled(false);
        Carta2L2.setEnabled(false);
        Carta1L3.setEnabled(false);
        Carta2L3.setEnabled(false);
        Carta3L3.setEnabled(false);
        Carta1L4.setEnabled(false);
        Carta2L4.setEnabled(false);
        Carta3L4.setEnabled(false);
        Carta4L4.setEnabled(false);
        Carta1L5.setEnabled(false);
        Carta2L5.setEnabled(false);
        Carta3L5.setEnabled(false);
        Carta1L6.setEnabled(true);
        Carta2L6.setEnabled(true);
        Carta1L7.setEnabled(false);
    }

    private void enable_level7() {
        Carta1L1.setEnabled(false);
        Carta1L2.setEnabled(false);
        Carta2L2.setEnabled(false);
        Carta1L3.setEnabled(false);
        Carta2L3.setEnabled(false);
        Carta3L3.setEnabled(false);
        Carta1L4.setEnabled(false);
        Carta2L4.setEnabled(false);
        Carta3L4.setEnabled(false);
        Carta4L4.setEnabled(false);
        Carta1L5.setEnabled(false);
        Carta2L5.setEnabled(false);
        Carta3L5.setEnabled(false);
        Carta1L6.setEnabled(false);
        Carta2L6.setEnabled(false);
        Carta1L7.setEnabled(true);
    }

    private void init2(int level) {
        HomeBut();
        quefuncioneellayout = false;
        TragosTV.setVisibility(View.INVISIBLE);
        PlayerTV.setText(Perdedor);
        if(level==1) {
            enable_level1();
            Level1();
        }
        else if(level==2) {
            enable_level2();
            Level2();
        }
        else if (level==3) {
            enable_level3();
            Level3();
        }
        else if (level==4) {
            enable_level4();
            Level4();
        }
        else if (level==5) {
            enable_level5();
            Level5();
        }
        else if (level==6) {
            enable_level6();
            Level6();
        }
        else if (level==7) {
            enable_level7();
            Level7();
        }
    }

    private void HomeBut() {
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino3_Nuevo.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino3_Nuevo.this, GamesModalities.class);
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

    private void AllImagesToBegin() {
        Carta1L1.setImageResource(R.drawable.cartapordetras);
        Carta1L2.setImageResource(R.drawable.cartapordetras);
        Carta2L2.setImageResource(R.drawable.cartapordetras);
        Carta1L3.setImageResource(R.drawable.cartapordetras);
        Carta2L3.setImageResource(R.drawable.cartapordetras);
        Carta3L3.setImageResource(R.drawable.cartapordetras);
        Carta1L4.setImageResource(R.drawable.cartapordetras);
        Carta2L4.setImageResource(R.drawable.cartapordetras);
        Carta3L4.setImageResource(R.drawable.cartapordetras);
        Carta4L4.setImageResource(R.drawable.cartapordetras);
        Carta1L5.setImageResource(R.drawable.cartapordetras);
        Carta2L5.setImageResource(R.drawable.cartapordetras);
        Carta3L5.setImageResource(R.drawable.cartapordetras);
        Carta1L6.setImageResource(R.drawable.cartapordetras);
        Carta2L6.setImageResource(R.drawable.cartapordetras);
        Carta1L7.setImageResource(R.drawable.cartapordetras);
    }

    private void Nivel_Superado(int level) {
        if(level == 1)level1_superado = true;
        else if(level == 2)level2_superado = true;
        else if(level == 3)level3_superado = true;
        else if(level == 4)level4_superado = true;
        else if(level == 5)level5_superado = true;
        else if(level == 6)level6_superado = true;
        else if(level == 7)level7_superado = true;
    }

    private void Level7() {
        Carta1L7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L7);
            }
        });
    }

    private void Level6() {
        Carta1L6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L6);

            }
        });

        Carta2L6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta2L6);
            }
        });
    }

    private void Level5() {
        Carta1L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L5);

            }
        });

        Carta2L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta2L5);
            }
        });

        Carta3L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta3L5);
            }
        });
    }

    private void Level4() {
        Carta1L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L4);

            }
        });
        Carta2L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta2L4);
            }
        });
        Carta3L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta3L4);
            }
        });
        Carta4L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta4L4);
            }
        });
    }

    private void Level3() {
        Carta1L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L3);
            }
        });
        Carta2L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta2L3);
            }
        });

        Carta3L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta3L3);
            }
        });
    }

    private void Level2() {
        Carta1L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L2);
            }
        });
        Carta2L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta2L2);
            }
        });
    }

    private void Level1() {
        Carta1L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCarta(Carta1L1);
            }
        });
    }

    private void onClickCarta(ImageView Carta) {
        generarRandom();
        String carta = Baraja.getBaraja().get(n);
        SetImageInCarta(carta, Carta);
        Log.d("La carta es un: ", ""+carta);
        boolean Figura = es_Figura(carta);
        if(Figura){
           // TragosTV.setVisibility(View.VISIBLE);
          //  TragosTV.setText("Bebes "+Level+ " tragos!!");
            Toast.makeText(ElCamino3_Nuevo.this,"Bebes "+Level+ " tragos!",Toast.LENGTH_SHORT).show();
            level1_superado = false;
            Level = 1;
            quefuncioneellayout = true;
            All_Cartas_Do_Begin();
        }
        else {
            boolean es_7 = es_7(carta);
            if (es_7) {
                traspasar_El_Camino();
            }
            else {
                Nivel_Superado(Level);
                ++Level;
                // Carta.setImageResource(R.drawable.homebutton);
                init2(Level);
            }
        }
    }

    private void SetImageInCarta(String carta, ImageView CartaIV) {
        Log.d("Entro en SetImageCarta","aaa");
        BarajaPoker Baraja = new BarajaPoker();
        int aux = 0;
        for(int i = 0; i < Baraja.getBaraja().size();++i) {
            if(Baraja.getBaraja().get(i).equals(carta)) aux = i;
        }
        String imagen_carta = Baraja.getCartas().get(aux);
        int resID = getResources().getIdentifier(imagen_carta , "drawable", getPackageName());
        CartaIV.setImageResource(resID);
    }

    private void All_Cartas_Do_Begin() {
        enable_all();
        for(int i = 0; i < Cartas.size();++i) {
            Cartas.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AllImagesToBegin();
                    init2(Level);
                }
            });
        }
        if (quefuncioneellayout) {
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AllImagesToBegin();
                    init2(Level);
                }
            });
        }
    }

    private void traspasar_El_Camino() {
        enable_all();
        for(int i = 0; i < Cartas.size();++i) {
            Cartas.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino3_Nuevo.this);
                    dialogo1.setMessage("¿A quien quieres traspasar El Camino?");
                    dialogo1.setCancelable(false);
                    View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                    dialogo1.setTitle("Un 7!");
                    Spinner spinner = view.findViewById(R.id.SpinnerDialog);
                    String [] valores = Jugadores.toArray(new String[Jugadores.size()]);
                    spinner.setAdapter(new ArrayAdapter<String>(ElCamino3_Nuevo.this, android.R.layout.simple_spinner_item, valores));
                    dialogo1.setPositiveButton("Traspasar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            if (!spinner.getSelectedItem().toString().equals("")) {
                                Level = 1;
                                Perdedor =  spinner.getSelectedItem().toString();
                                AllImagesToBegin();
                                Log.d("Dentro de Spiner", ""+Perdedor);
                                init2(Level);
                            }
                        }
                    });
                    dialogo1.setNegativeButton("Sigo jugando", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            Nivel_Superado(Level);
                            ++Level;
                            // Carta.setImageResource(R.drawable.homebutton);
                            init2(Level);
                        }
                    });
                    dialogo1.setView(view);
                    AlertDialog ad = dialogo1.create();
                    ad.show();
                }
            });
        }
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino3_Nuevo.this);
                dialogo1.setMessage("¿A quien quieres traspasar El Camino?");
                dialogo1.setCancelable(false);
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                dialogo1.setTitle("Un 7!");
                Spinner spinner = view.findViewById(R.id.SpinnerDialog);
                String [] valores = Jugadores.toArray(new String[Jugadores.size()]);
                spinner.setAdapter(new ArrayAdapter<String>(ElCamino3_Nuevo.this, android.R.layout.simple_spinner_item, valores));
                dialogo1.setPositiveButton("Traspasar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        if (!spinner.getSelectedItem().toString().equals("")) {
                            Level = 1;
                            Perdedor =  spinner.getSelectedItem().toString();
                            AllImagesToBegin();
                            Log.d("Dentro de Spiner", ""+Perdedor);
                            init2(Level);
                        }
                    }
                });
                dialogo1.setNegativeButton("Sigo jugando", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Nivel_Superado(Level);
                        ++Level;
                        // Carta.setImageResource(R.drawable.homebutton);
                        init2(Level);
                    }
                });
                dialogo1.setView(view);
                AlertDialog ad = dialogo1.create();
                ad.show();
            }
        });
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
        //Log.d("El numero es un :", ""+b);
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