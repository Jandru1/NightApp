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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ElCamino_1_4 extends AppCompatActivity {

    private ArrayList<String> Jugadores = new ArrayList<>();
    private ArrayList<String> numeross = new ArrayList<>();

    private ImageView CartaIV;
    private ImageView ShotsButton;

    private ImageButton DiamanteButton;
    private ImageButton CorazonesButton;
    private ImageButton PicasButton;
    private ImageButton TrebolesButton;
    private View SiguienteButtonn;

    private TextView pregunta;
    private TextView ultima_carta;
    private TextView LastimaTV;
    private TextView jugador_jugando;
    private TextView ShotsText;
    private TextView InfoText;

    private int k = 0;
    private int n;

    private BarajaPoker Baraja = new BarajaPoker();
    private Bundle bundle;

    private Intent intent;

    private BarajaPersonalizada BP = null;

    private ImageView HomeButton;
    private ImageView InfoButton;

    private ShotsCounter Shots = new ShotsCounter();
    private PlayerClass PlayerClass = new PlayerClass();

    private boolean clickado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_1_4);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        DiamanteButton = findViewById(R.id.DiamanteButton);
        PicasButton = findViewById(R.id.PicasButton);
        CorazonesButton = findViewById(R.id.CorazonesButton);
        TrebolesButton = findViewById(R.id.TrebolesButton);
        SiguienteButtonn = findViewById(R.id.ElCamino1_4);

        HomeButton = findViewById(R.id.HomeButton1_4);

        ShotsButton = findViewById(R.id.shotsButton6);
        ShotsText = findViewById(R.id.shotsText6);
        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        CartaIV = findViewById(R.id.Cartatv);

        ultima_carta = findViewById(R.id.UltimaCartaTextView);
        pregunta = findViewById(R.id.PaloTextView);
        jugador_jugando = findViewById(R.id.jugadorTextView);
        LastimaTV = findViewById(R.id.LastimaTV);
        InfoButton = findViewById(R.id.infoButtton3);
        InfoText = findViewById(R.id.textView9);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        jugador_jugando.setTypeface(robotoLight);
        pregunta.setTypeface(robotoLight);
        ultima_carta.setTypeface(robotoLight);
        LastimaTV.setTypeface(robotoLight);
        ShotsText.setTypeface(robotoLight);
        InfoText.setTypeface(robotoLight);

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }

        numeross = getIntent().getStringArrayListExtra("numeross");

        intent = new Intent(ElCamino_1_4.this, ElCamino_2_1.class);

        ShotsButt();
        InfoButt();

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
                    InfoText.setText("La Fase1 del Camino consiste en lo siguiente: a cada jugador se le preguntará cómo cree que será su carta y se le mostrarán diferentes opciones. ¡Si falla, beberá, y si acierta repartirá un número de tragos dependiendo del nivel en el que esté!!");
                    ShotsText.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility((View.INVISIBLE));
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
                    ShotsText.setText("\n");
                    ShotsText.append("Tragos"+ "\n" + "\n");
                    for (Map.Entry<String,Integer> entry : Shots.getShotsMap().entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        ShotsText.append(key + ": " + value + "\n"+ "\n"+ "\n");
                        // do stuff
                    }
                    ShotsText.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    jugador_jugando.setVisibility(View.INVISIBLE);
                    all_invisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    jugador_jugando.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    all_visible();
                }
                return presionado;
            }
        });
    }

    private void all_visible() {

        if (clickado){
            CartaIV.setVisibility(View.VISIBLE);
            ultima_carta.setVisibility(View.VISIBLE);
            LastimaTV.setVisibility(View.VISIBLE);

        }
        else {
            pregunta.setVisibility(View.VISIBLE);
            DiamanteButton.setVisibility(View.VISIBLE);
            CorazonesButton.setVisibility(View.VISIBLE);
            TrebolesButton.setVisibility(View.VISIBLE);
            PicasButton.setVisibility(View.VISIBLE);
            CartaIV.setVisibility(View.VISIBLE);
            ultima_carta.setVisibility(View.VISIBLE);
        }

    }

    private void all_invisible() {
        pregunta.setVisibility(View.INVISIBLE);
        DiamanteButton.setVisibility(View.INVISIBLE);
        CorazonesButton.setVisibility(View.INVISIBLE);
        TrebolesButton.setVisibility(View.INVISIBLE);
        PicasButton.setVisibility(View.INVISIBLE);
        CartaIV.setVisibility(View.INVISIBLE);
        ultima_carta.setVisibility(View.INVISIBLE);
        LastimaTV.setVisibility(View.INVISIBLE);
    }

    private void Primer_caso() {

        clickado = false;
        pregunta.setVisibility(View.VISIBLE);
        CartaIV.setImageResource(R.drawable.cartapordetras);
        LastimaTV.setVisibility(View.INVISIBLE);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_1_4.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_1_4.this, GamesModalities.class);
                        intent.putExtra("Jugadores", PlayerClass);
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
        pregunta.setText("¿A qué palo pertenece?");
        ultima_carta.setText("Tu última carta!");
        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);

        if(bundle!=null) {
            BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
        }

        DiamanteButton.setVisibility(View.VISIBLE);
        CorazonesButton.setVisibility(View.VISIBLE);
        TrebolesButton.setVisibility(View.VISIBLE);
        PicasButton.setVisibility(View.VISIBLE);

        DiamanteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String palo = "diamantes";
                enseñar_carta(palo);
            }
        });

        CorazonesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String palo = "corazones";
                enseñar_carta(palo);
            }
        });

        PicasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String palo = "picas";
                enseñar_carta(palo);
            }
        });

        TrebolesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String palo = "treboles";
                enseñar_carta(palo);
            }
        });
    }

    private void enseñar_carta(String palo) {
        generarRandom(); //Hay que descartar los que ya salieron antes!!!!
        String carta = Baraja.getBaraja().get(n);
        Log.d("CARTA 4: ", ""+carta);

        String palo_final = Baraja.get_palo(n);

        if(palo.equals(palo_final)) {
            LastimaTV.setVisibility(View.VISIBLE);
            LastimaTV.setText("Felicidades!"+/* Un "+ carta +"*/" Repartes 4 tragos");
            pregunta.setVisibility(View.INVISIBLE);
        }
        else {
            LastimaTV.setVisibility(View.VISIBLE);
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
            Shots.SumShot(Jugadores.get(k));
            LastimaTV.setText("Lástima!"+/* La carta es un " + carta + */". Bebes 4 tragos!");
            pregunta.setVisibility(View.INVISIBLE);
        }
        SetImageInCarta(carta, CartaIV);
        DiamanteButton.setVisibility(View.INVISIBLE);
        CorazonesButton.setVisibility(View.INVISIBLE);
        TrebolesButton.setVisibility(View.INVISIBLE);
        PicasButton.setVisibility(View.INVISIBLE);
        SiguienteButtonn.setVisibility(View.VISIBLE);

        BP.añadir_carta(carta);
        Bundle b = new Bundle();
        b.putSerializable("BarajaPersonalizada", BP);

        intent.putExtra("BarajaPers " + k , b);

        SiguienteButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickado) {
                    if (k + 1 == Jugadores.size()) {
                        intent.putExtra("Jugadores", PlayerClass);
                        intent.putStringArrayListExtra("numeross", numeross);
                        intent.putExtra("Ronda", 1);
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