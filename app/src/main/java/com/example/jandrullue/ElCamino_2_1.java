package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ElCamino_2_1 extends AppCompatActivity {

    private ImageView Carta1;
    private ImageView Carta2;
    private ImageView Carta3;
    private ImageView ShotsButton;
    private Button SiguienteButtonn;

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private TextView Carta1TV;
    private TextView Carta2TV;
    private TextView Carta3TV;
    private TextView ShotsText;
    private TextView RondaTV;

    private int k = 0;
    private int q = 0;
    private int j = 0;
    private int n;

    private BarajaPoker Baraja = new BarajaPoker();
    private Bundle bundle;

    private BarajaPersonalizada BP = null;

    boolean Carta1IsClicked = false;
    boolean Carta2IsClicked = false;
    boolean Carta3IsClicked = false;

    private int Ronda;
    private ImageView HomeButton;

    private ShotsCounter Shots = new ShotsCounter();

    private boolean Carta1Enseñada = false;
    private boolean Carta2Enseñada = false;
    private boolean Carta3Enseñada = false;

    private ArrayList<String> Cartas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        Ronda = getIntent().getExtras().getInt("Ronda");
        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        for (Map.Entry<String, Integer> entry : Shots.getShotsMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Log.d("Hashmap "+ key, ""+value);
        }

        Carta1 = findViewById(R.id.Carta1);
        Carta2 = findViewById(R.id.Carta2);
        Carta3 = findViewById(R.id.Carta3);
        SiguienteButtonn = findViewById(R.id.Sig);
        HomeButton = findViewById(R.id.HomeButton2);

        SiguienteButtonn.setVisibility(View.INVISIBLE);

        ShotsText = findViewById(R.id.ShotsText);
        ShotsButton = findViewById(R.id.ShotsButton);
        RondaTV = findViewById(R.id.RondaTV);

        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        ShotsText.setTypeface(robotoLight);
        RondaTV.setTypeface(robotoLight);

        ShotsText.setVisibility(View.INVISIBLE);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        RondaTV.setText("Ronda "+Ronda);

        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_2_1.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_2_1.this, GamesModalities.class);
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
        ShotsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean  presionado = false;
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    presionado = true;
                    ShotsText.setText("");
                    for (Map.Entry<String,Integer> entry : Shots.getShotsMap().entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        ShotsText.append(key + ": " + value + "\n"+ "\n"+ "\n");
                        // do stuff
                    }
                    ShotsText.setVisibility(View.VISIBLE);
                    Carta1.setVisibility(View.INVISIBLE);
                    Carta2.setVisibility(View.INVISIBLE);
                    Carta3.setVisibility(View.INVISIBLE);
                    SiguienteButtonn.setVisibility(View.INVISIBLE);
                    RondaTV.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);

                  //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);
                    Carta1.setVisibility(View.VISIBLE);
                    Carta2.setVisibility(View.VISIBLE);
                    Carta3.setVisibility(View.VISIBLE);
                    RondaTV.setVisibility(View.VISIBLE);

                    if(Carta3Enseñada & Carta2Enseñada & Carta1Enseñada) SiguienteButtonn.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                }
                return presionado;
            }
        });
        Carta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j==0) {
                    ++j;
                    Carta1IsClicked = true;
                    generarRandom();
                    String carta = Baraja.getBaraja().get(n);
                    Cartas.add(carta);
                    SetImageToCarta(carta, Carta1);
                    Carta1Enseñada = true;
                    Aparece_SigBut();
                }
            }
        });

        Carta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(q==0) {
                    ++q;
                    Carta2IsClicked = true;
                    generarRandom();
                    String carta = Baraja.getBaraja().get(n);
                    Cartas.add(carta);
                    SetImageToCarta(carta, Carta2);
                    Carta2Enseñada = true;
                    Aparece_SigBut();
                }
            }
        });

        Carta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==0) {
                    ++k;
                    Carta3IsClicked = true;
                    generarRandom();
                    String carta = Baraja.getBaraja().get(n);
                    Cartas.add(carta);
                    SetImageToCarta(carta, Carta3);
                    Carta3Enseñada = true;
                    Aparece_SigBut();
                }
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
                Log.d("CARTAS pos 0:", ""+Cartas.get(0));
                Log.d("CARTAS pos 1:", ""+Cartas.get(1));
                Log.d("CARTAS:", ""+Cartas.get(2));
                i.putExtra("Carta1", Cartas.get(0));
                i.putExtra("Carta2", Cartas.get(1));
                i.putExtra("Carta3", Cartas.get(2));

                i.putExtra("Ronda", Ronda);
                i.putExtra("Shots", Shots);
                startActivity(i);
            }
        });
    }

    private void SetImageToCarta(String carta, ImageView CartaIV) {
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