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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ElCamino_2_1 extends AppCompatActivity {

    private Button Carta1;
    private Button Carta2;
    private Button Carta3;
    private Button SiguienteButtonn;
    private ImageView ShotsButton;

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private TextView Carta1TV;
    private TextView Carta2TV;
    private TextView Carta3TV;
    private TextView ShotsText;
    private TextView RondaTV;

    private int k = 0;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_2);

        Ronda = getIntent().getExtras().getInt("Ronda");
        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        for (Map.Entry<String, Integer> entry : Shots.getShotsMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Log.d("Hashmap "+ key, ""+value);
        }

        Carta1 = findViewById(R.id.Carta1_1Button);
        Carta2 = findViewById(R.id.Carta1_2Button);
        Carta3 = findViewById(R.id.Carta1_3Button);
        SiguienteButtonn = findViewById(R.id.Sig);
        HomeButton = findViewById(R.id.HomeButton2);

        SiguienteButtonn.setVisibility(View.INVISIBLE);

        Carta1TV = findViewById(R.id.Carta1_1TV);
        Carta2TV = findViewById(R.id.Carta1_2TV);
        Carta3TV = findViewById(R.id.Carta1_3TV);
        ShotsText = findViewById(R.id.ShotsText);
        ShotsButton = findViewById(R.id.ShotsButton);
        RondaTV = findViewById(R.id.RondaTV);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        ShotsText.setTypeface(robotoLight);
        Carta1TV.setTypeface(robotoLight);
        Carta2TV.setTypeface(robotoLight);
        Carta3TV.setTypeface(robotoLight);
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
                    HomeButton.setVisibility(View.INVISIBLE);

                    Carta1TV.setVisibility(View.INVISIBLE);
                    Carta2TV.setVisibility(View.INVISIBLE);
                    Carta3TV.setVisibility(View.INVISIBLE);
                  //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);

                    if (Carta1Enseñada) {
                        Carta1.setVisibility(View.INVISIBLE);
                        Carta1TV.setVisibility(View.VISIBLE);
                    }
                    else {
                        Carta1.setVisibility(View.VISIBLE);
                        Carta1TV.setVisibility(View.INVISIBLE);
                    }
                    if (Carta2Enseñada){
                        Carta2.setVisibility(View.INVISIBLE);
                        Carta2TV.setVisibility(View.VISIBLE);
                    }
                    else {
                        Carta2.setVisibility(View.VISIBLE);
                        Carta2TV.setVisibility(View.INVISIBLE);
                    }
                    if (Carta3Enseñada) {
                        Carta3.setVisibility(View.INVISIBLE);
                        Carta3TV.setVisibility(View.VISIBLE);
                    }
                    else {
                        Carta3.setVisibility(View.VISIBLE);
                        Carta3TV.setVisibility(View.INVISIBLE);
                    }
                    if(Carta3Enseñada & Carta2Enseñada & Carta1Enseñada) SiguienteButtonn.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                }
                return presionado;
            }
        });

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
                Carta1Enseñada = true;
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
                Carta2Enseñada = true;
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
                Carta3Enseñada = true;
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
                i.putExtra("Shots", Shots);
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