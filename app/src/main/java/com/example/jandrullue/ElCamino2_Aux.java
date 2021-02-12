package com.example.jandrullue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Map;

public class ElCamino2_Aux extends AppCompatActivity {

    private TextView PlayerTV;
    private TextView Deshacer_cartasTV;
    private TextView ShotsText;
    private TextView InfoText;

    private ImageButton SiguienteButton;
    private ImageView ShotsButton;

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
    private ImageView HomeButton;
    private ImageView InfoButton;

    private ShotsCounter Shots;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino2__aux);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerTV = findViewById(R.id.JugadorTV);
        Deshacer_cartasTV = findViewById(R.id.TV);
        HomeButton = findViewById(R.id.HomeButton2Aux);
        InfoButton = findViewById(R.id.infoButtton5);
        InfoText = findViewById(R.id.textView5);

        ShotsButton = findViewById(R.id.shotsButton7);
        ShotsText = findViewById(R.id.shotsText7);
        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);
        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        SiguienteButton = findViewById(R.id.Sigui);
        Ronda = getIntent().getExtras().getInt("Ronda");
        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        Deshacer_cartasTV.setTypeface(robotoLight);
        PlayerTV.setTypeface(robotoLight);
        ShotsText.setTypeface(robotoLight);
        InfoText.setTypeface(robotoLight);

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);
        if(bundle!=null) {
             BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
        }

        InfoButt();

        Deshacer_Cartas(k, BP);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void InfoButt() {

        InfoButton.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean  presionado = false;
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    presionado = true;
                    InfoText.setVisibility(View.VISIBLE);
                    InfoText.setText("La Fase2 del Camino consiste en 4 rondas. En cada ronda se enseñaran 3 cartas. Si tienes alguna carta con el mismo número que as mostradas, repartiras trago. El que se quede más cartas al final jugará ElCamino!");
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    PlayerTV.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility(View.INVISIBLE);
                    all_invisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    PlayerTV.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    InfoText.setVisibility(View.INVISIBLE);
                    all_visible();
                }
                return presionado;
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void Deshacer_Cartas(int x, BarajaPersonalizada BP) {
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino2_Aux.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino2_Aux.this, GamesModalities.class);
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

        ShotsButt();

        PlayerTV.setText(Jugadores.get(x));

        int cartas_a_deshacer = 0;

        for(int j = 0; j < BP.getBaraja().size(); ++j) {
          //  Log.d("El tamaño de baraja es:", String.valueOf(BP.getBaraja().size()));
            String a = BP.get_num(j);
            String b1 = getnum(getIntent().getExtras().getString("Carta1"));
            String b2 = getnum(getIntent().getExtras().getString("Carta2"));
            String b3 = getnum(getIntent().getExtras().getString("Carta3"));

            boolean equal_to_someone = false;

            if(a.equals(b1)){
                ++cartas_a_deshacer;
                if(cartas_a_deshacer ==1)  Carta_a_deshacer1 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==2)  Carta_a_deshacer2 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==3)  Carta_a_deshacer3 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==4)  Carta_a_deshacer4 = BP.getBaraja().get(j);
                a = "null";
                equal_to_someone = true;
            }
            if(a.equals(b2)){
                ++cartas_a_deshacer;
                if(cartas_a_deshacer ==1)  Carta_a_deshacer1 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==2)  Carta_a_deshacer2 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==3)  Carta_a_deshacer3 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==4)  Carta_a_deshacer4 = BP.getBaraja().get(j);
                a = "null";
                equal_to_someone = true;
            }
            if(a.equals(b3)){
                ++cartas_a_deshacer;
                if(cartas_a_deshacer ==1)  Carta_a_deshacer1 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==2)  Carta_a_deshacer2 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==3)  Carta_a_deshacer3 = BP.getBaraja().get(j);
                else if(cartas_a_deshacer ==4)  Carta_a_deshacer4 = BP.getBaraja().get(j);
                a = "null";
                equal_to_someone = true;
            }
            if(equal_to_someone){
                //BP.getBaraja().set(j, "BORRAR");
            }
        }
        //limpiar_baraja(BP);
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
                        intent.putExtra("Shots", Shots);
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
                        intent.putExtra("Shots", Shots);
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

    @SuppressLint("ClickableViewAccessibility")
    private void ShotsButt() {
        ShotsButton.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
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
                    InfoButton.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    PlayerTV.setVisibility(View.INVISIBLE);
                    InfoButton.setVisibility(View.INVISIBLE);
                    all_invisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    PlayerTV.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    all_visible();
                }
                return presionado;
            }
        });
    }

    private void all_visible() {
        Deshacer_cartasTV.setVisibility(View.VISIBLE);
        SiguienteButton.setVisibility(View.VISIBLE);
    }

    private void all_invisible() {
        Deshacer_cartasTV.setVisibility(View.INVISIBLE);
        SiguienteButton.setVisibility(View.INVISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void limpiar_baraja(BarajaPersonalizada bp) {
        bp.getBaraja().removeIf((a) -> a.equals("BORRAR"));
        for (int i = 0; i < bp.getBaraja().size();++i) {
            Log.d("La baraja tiene :", bp.getBaraja().get(i));
        }
    }

    private String getnum(String s) {
        if(s.substring(0,1).equals("1")) { s = s.substring(0,2);}
        else s = s.substring(0,1);
        return s;
    }
}