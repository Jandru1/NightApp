package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.IDNA;
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

public class ElCamino_1_3 extends AppCompatActivity {

    private ArrayList<String> Jugadores;
    private ArrayList<String> numeross = new ArrayList<>();

    private ImageButton DentroButton;
    private ImageButton FueraButton;

    private View SiguienteButtonn;

    private TextView pregunta;
    private TextView anteriores_cartas_fueron;
    private TextView jugador_jugando;
    private TextView ShotsText;
    private TextView InfoText;

    private int k = 0;
    private int n;

    private BarajaPoker Baraja = new BarajaPoker();
    private Bundle bundle;

    private String carta_anterior1 = null;
    private String carta_anterior2 = null;

    private Intent intent;

    private BarajaPersonalizada BP = null;

    private ImageView HomeButton;
    private ImageView CartaIV1;
    private ImageView CartaIV2;
    private ImageView CartaIV3;
    private ImageView ShotsButton;
    private ImageView InfoButton;

    private ShotsCounter Shots = new ShotsCounter();

    private boolean clickado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el__camino_1_3);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        DentroButton = findViewById(R.id.DentroButton);
        FueraButton = findViewById(R.id.FueraButton);
        SiguienteButtonn = findViewById(R.id.ElCamino1_3);

        HomeButton = findViewById(R.id.HomeButton1_3);
        ShotsButton = findViewById(R.id.shotsButton5);
        ShotsText = findViewById(R.id.shotsText5);

        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        anteriores_cartas_fueron = findViewById(R.id.TextView3);
        pregunta = findViewById(R.id.TextView4);

        jugador_jugando = findViewById(R.id.PlayerText);

        CartaIV1 = findViewById(R.id.CartaIV1);
        CartaIV2 = findViewById(R.id.CartaIV2);
        CartaIV3 = findViewById(R.id.CartaIV3);
        InfoButton = findViewById(R.id.infoButtton2);
        InfoText = findViewById(R.id.textView8);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        pregunta.setTypeface(robotoLight);
        jugador_jugando.setTypeface(robotoLight);
        anteriores_cartas_fueron.setTypeface(robotoLight);
        ShotsText.setTypeface(robotoLight);
        InfoText.setTypeface(robotoLight);

        Jugadores = getIntent().getStringArrayListExtra("Players");
        numeross = getIntent().getStringArrayListExtra("numeross");

        intent = new Intent(ElCamino_1_3.this, ElCamino_1_4.class);

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_1_3.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_1_3.this, GamesModalities.class);
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

        InfoButt();
        ShotsButt();
        Primer_caso();
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
                    InfoText.setText("La Fase1 del Camino consiste en lo siguiente: a cada jugador se le preguntará cómo cree que será su carta y se lo mostrará diferentes opciones. Si falla, beberá, y si acierta repartirá un número de tragos dependiendo del nivel en el que esté!!");
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility(View.INVISIBLE);
                    jugador_jugando.setVisibility(View.INVISIBLE);
                    InfoButton.setVisibility(View.INVISIBLE);
                    all_invisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    jugador_jugando.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    InfoText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    all_visible();
                }
                return presionado;
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
                    HomeButton.setVisibility(View.INVISIBLE);
                    jugador_jugando.setVisibility(View.INVISIBLE);
                    InfoButton.setVisibility(View.INVISIBLE);

                    all_invisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    jugador_jugando.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);

                    all_visible();
                }
                return presionado;
            }
        });
    }

    private void all_visible() {
        if(clickado){
            CartaIV1.setVisibility(View.VISIBLE);
            CartaIV2.setVisibility(View.VISIBLE);
            CartaIV3.setVisibility(View.VISIBLE);
            pregunta.setVisibility(View.VISIBLE);
            anteriores_cartas_fueron.setVisibility(View.VISIBLE);
        }
        else {
            CartaIV1.setVisibility(View.VISIBLE);
            CartaIV2.setVisibility(View.VISIBLE);
            pregunta.setVisibility(View.VISIBLE);
            anteriores_cartas_fueron.setVisibility(View.VISIBLE);
            DentroButton.setVisibility(View.VISIBLE);
            FueraButton.setVisibility(View.VISIBLE);
        }

    }

    private void all_invisible() {
        CartaIV1.setVisibility(View.INVISIBLE);
        CartaIV2.setVisibility(View.INVISIBLE);
        CartaIV3.setVisibility(View.INVISIBLE);
        pregunta.setVisibility(View.INVISIBLE);
        anteriores_cartas_fueron.setVisibility(View.INVISIBLE);
        DentroButton.setVisibility(View.INVISIBLE);
        FueraButton.setVisibility(View.INVISIBLE);
    }

    private void Primer_caso() {
        clickado = false;
        CartaIV3.setVisibility(View.INVISIBLE);

        jugador_jugando.setText(Jugadores.get(k));
        pregunta.setText("¿La siguiente estará dentro del intervalo?");
        anteriores_cartas_fueron.setText("Tus anteriores cartas fueron:");
        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);

        if(bundle!=null) {
            BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
            carta_anterior1 = BP.getBaraja().get(0);
            carta_anterior2 = BP.getBaraja().get(1);
            SetImageInCarta(carta_anterior1, CartaIV1);
            SetImageInCarta(carta_anterior2, CartaIV2);
        }

        DentroButton.setVisibility(View.VISIBLE);
        FueraButton.setVisibility(View.VISIBLE);

        DentroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String dentro_o_fuera = "dentro";
                enseñar_carta(dentro_o_fuera);
            }
        });

        FueraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String dentro_o_fuera = "fuera";
                enseñar_carta(dentro_o_fuera);
            }
        });
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

    private void enseñar_carta(String dentro_o_fuera) {
        generarRandom(); //Hay que descartar los que ya salieron antes!!!!
        String carta = Baraja.getBaraja().get(n);

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
                pregunta.setText("Felicidades! Un "+ carta +". Repartes 3 tragos");
            }
            else if (num_antiguo1_int < num_nuevo_int & num_antiguo2_int > num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ carta +". Repartes 3 tragos");
            }
            else {
                Shots.SumShot(Jugadores.get(k));
                Shots.SumShot(Jugadores.get(k));
                Shots.SumShot(Jugadores.get(k));
                pregunta.setText("Lástima! La carta es un " + carta + ". Bebes 3 tragos!");
            }

        }
        else if (dentro_o_fuera.equals("fuera")) {
            if (num_antiguo1_int > num_nuevo_int & num_antiguo2_int > num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ carta +". Repartes 3 tragos");
            }
            else if (num_antiguo1_int < num_nuevo_int & num_antiguo2_int < num_nuevo_int) {
                pregunta.setText("Felicidades! Un "+ carta +". Repartes 3 tragos");
            }
            else {
                pregunta.setText("Lástima! La carta es un " + carta + ". Bebes 3 tragos!");
                Shots.SumShot(Jugadores.get(k));
                Shots.SumShot(Jugadores.get(k));
                Shots.SumShot(Jugadores.get(k));
            }
        }
        if(!soniguales) {
            CartaIV3.setVisibility(View.VISIBLE);
            SetImageInCarta(carta, CartaIV3);
            Log.d("CARTA 3: "+ carta + "Jugador", " "+Jugadores.get(k));
            BP.añadir_carta(carta);
            Bundle b = new Bundle();
            b.putSerializable("BarajaPersonalizada", BP);
            intent.putExtra("BarajaPers " + k, b);
        }
        SiguienteButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickado) {
                    if (k + 1 == Jugadores.size()) {
                        intent.putStringArrayListExtra("Players", Jugadores);
                        intent.putStringArrayListExtra("numeross", numeross);
                        intent.putExtra("Shots", Shots);
                        startActivity(intent);
                    } else {
                        ++k;
                        Primer_caso();
                    }
                }
            }
        });
    }

    private String transform_JQK(String s) {
        String a = null;
        if (s.equals("J")) a = "11";
        else if (s.equals("Q")) a = "12";
        else if (s.equals("K")) a = "13";
        else if (s.equals("A")) a = "1";
        else a = s;
        return a;
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