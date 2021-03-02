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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ElCamino_2_1 extends AppCompatActivity {

    private ImageView Carta1;
    private ImageView Carta2;
    private ImageView Carta3;
    private ImageView ShotsButton;

    private ImageButton SiguienteButtonn;

    private Button MostrasJugadoresButton;

    private ArrayList<String> Jugadores = new ArrayList<>();
    private ArrayList<String> numeross = new ArrayList<>();

    private TextView ShotsText;
    private TextView RondaTV;
    private TextView InfoText;
    private TextView Jugadores_paraCartas;

    private TextView Jugador1;
    private TextView Jugador2;
    private TextView Jugador3;
    private TextView Jugador4;
    private TextView Jugador5;
    private TextView Jugador6;
    private TextView Jugador7;
    private TextView Jugador8;
    private TextView Jugador9;

    private ImageView CartaAntigua1;
    private ImageView CartaAntigua2;
    private ImageView CartaAntigua3;
    private ImageView CartaAntigua4;

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
    private ImageView InfoButton;

    private ShotsCounter Shots = new ShotsCounter();
    private PlayerClass PlayerClass = new PlayerClass();

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
        SiguienteButtonn = findViewById(R.id.sig);
        HomeButton = findViewById(R.id.HomeButton2);
        InfoButton = findViewById(R.id.infoButtton4);
        MostrasJugadoresButton = findViewById(R.id.ShowPlayersButton);

        SiguienteButtonn.setVisibility(View.INVISIBLE);

        ShotsText = findViewById(R.id.ShotsText);
        ShotsButton = findViewById(R.id.ShotsButton);
        RondaTV = findViewById(R.id.RondaTV);
        InfoText = findViewById(R.id.textView4);

        Jugador1 = findViewById(R.id.Player1TV);
        Jugador2 = findViewById(R.id.Player2TV);
        Jugador3 = findViewById(R.id.Player3TV);
        Jugador4 = findViewById(R.id.Player4TV);
        Jugador5 = findViewById(R.id.Player5TV);
        Jugador6 = findViewById(R.id.Player6TV);
        Jugador7 = findViewById(R.id.Player7TV);
        Jugador8 = findViewById(R.id.Player8TV);
        Jugador9 = findViewById(R.id.Player9TV);

        CartaAntigua1 = findViewById(R.id.CartaAntigua1);
        CartaAntigua2 = findViewById(R.id.CartaAntigua2);
        CartaAntigua3 = findViewById(R.id.CartaAntigua3);
        CartaAntigua4 = findViewById(R.id.CartaAntigua4);

        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        ShotsText.setTypeface(robotoLight);
        RondaTV.setTypeface(robotoLight);
        InfoText.setTypeface(robotoLight);
        MostrasJugadoresButton.setTypeface(robotoLight);
        Jugador1.setTypeface(robotoLight);
        Jugador2.setTypeface(robotoLight);
        Jugador3.setTypeface(robotoLight);
        Jugador4.setTypeface(robotoLight);
        Jugador5.setTypeface(robotoLight);
        Jugador6.setTypeface(robotoLight);
        Jugador7.setTypeface(robotoLight);
        Jugador8.setTypeface(robotoLight);
        Jugador9.setTypeface(robotoLight);

        ShotsText.setVisibility(View.INVISIBLE);

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }
        numeross = getIntent().getStringArrayListExtra("numeross");

        RondaTV.setText("Ronda "+Ronda);

        InfoButt();
        ShowCardsPlayersButt();

        init();
    }

    private void ShowCardsPlayersButt() {
        setPlayersInvisible();
        MostrasJugadoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MostrasJugadoresButton.getText().equals("Mostrar Jugadores")) {
                    for (int i = 0; i < Jugadores.size(); ++i) {
                        if (i == 0) Jugador1.setText(Jugadores.get(i));
                        else if (i == 1) Jugador2.setText(Jugadores.get(i));
                        else if (i == 2) Jugador3.setText(Jugadores.get(i));
                        else if (i == 3) Jugador4.setText(Jugadores.get(i));
                        else if (i == 4) Jugador5.setText(Jugadores.get(i));
                        else if (i == 5) Jugador6.setText(Jugadores.get(i));
                        else if (i == 6) Jugador7.setText(Jugadores.get(i));
                        else if (i == 7) Jugador8.setText(Jugadores.get(i));
                        else if (i == 8) Jugador9.setText(Jugadores.get(i));
                    }
                    setplayersVisibilityCorrectly();

                    Carta1.setVisibility(View.INVISIBLE);
                    Carta2.setVisibility(View.INVISIBLE);
                    Carta3.setVisibility(View.INVISIBLE);

                    MostrasJugadoresButton.setText("Ocultar Jugadores");

                    showCardsByPlayer();

                }
                else {

                    MostrasJugadoresButton.setText("Mostrar Jugadores");

                    Jugador1.setVisibility(View.INVISIBLE);
                    Jugador2.setVisibility(View.INVISIBLE);
                    Jugador3.setVisibility(View.INVISIBLE);
                    Jugador4.setVisibility(View.INVISIBLE);
                    Jugador5.setVisibility(View.INVISIBLE);
                    Jugador6.setVisibility(View.INVISIBLE);
                    Jugador7.setVisibility(View.INVISIBLE);
                    Jugador8.setVisibility(View.INVISIBLE);
                    Jugador9.setVisibility(View.INVISIBLE);

                    Carta1.setVisibility(View.VISIBLE);
                    Carta2.setVisibility(View.VISIBLE);
                    Carta3.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setplayersVisibilityCorrectly() {
        if(Jugadores.size()>0){
            Jugador1.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>1){
            Jugador2.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>2){
            Jugador3.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>3){
            Jugador4.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>4){
            Jugador5.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>5){
            Jugador6.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>6){
            Jugador7.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>7){
            Jugador8.setVisibility(View.VISIBLE);
        }
        if(Jugadores.size()>8){
            Jugador9.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void showCardsByPlayer() {
        Jugador1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador1);
            }
        });
        Jugador2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador2);
            }
        });
        Jugador3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador3);
            }
        });
        Jugador4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador4);
            }
        });
        Jugador5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador5);
            }
        });
        Jugador6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador6);
            }
        });
        Jugador7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador7);
            }
        });
        Jugador8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador8);
            }
        });
        Jugador9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return showcards(event, Jugador9);
            }
        });
    }

    private boolean showcards(MotionEvent event, TextView Playerrrr) {

        boolean  presionado = false;
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            presionado = true;

            setPlayersInvisible();

            CartaAntigua1.setVisibility(View.VISIBLE);
            CartaAntigua2.setVisibility(View.VISIBLE);
            CartaAntigua3.setVisibility(View.VISIBLE);
            CartaAntigua4.setVisibility(View.VISIBLE);

            setPlayersInvisible();

            String jugador = Playerrrr.getText().toString();

            Log.d("El jugador es ",""+jugador);

            int aux = -1;
            for(int i = 0; i < Jugadores.size();++i) {
                if(jugador.equals(Jugadores.get(i))) aux = i;
            }

            bundle = getIntent().getExtras().getBundle("BarajaPers "+aux);
            Log.d("El valor de aux es ",""+aux);
            if(bundle!=null) {
                BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
            }

            CartaAntigua1.setImageResource(R.drawable.carta_por_detras_descartada);
            CartaAntigua2.setImageResource(R.drawable.carta_por_detras_descartada);
            CartaAntigua3.setImageResource(R.drawable.carta_por_detras_descartada);
            CartaAntigua4.setImageResource(R.drawable.carta_por_detras_descartada);

            for(int j = 0; j < BP.getBaraja().size(); ++j) {
                String carta = BP.getBaraja().get(j);
                Log.d("La carta es ",""+carta);
                BarajaPoker Baraja = new BarajaPoker();
                int aux2 = 0;
                for(int i = 0; i < Baraja.getBaraja().size();++i) {
                    if(Baraja.getBaraja().get(i).equals(carta)) aux2 = i;
                }
                String imagen_carta = Baraja.getCartas().get(aux2);
                int resID = getResources().getIdentifier(imagen_carta , "drawable", getPackageName());

                if(j == 0) CartaAntigua1.setImageResource(resID);
                else if(j == 1) CartaAntigua2.setImageResource(resID);
                else if(j == 2) CartaAntigua3.setImageResource(resID);
                else if(j == 3) CartaAntigua4.setImageResource(resID);
            }

        }
        else if(event.getAction() == MotionEvent.ACTION_UP) {
            presionado = false;
            CartaAntigua1.setVisibility(View.INVISIBLE);
            CartaAntigua2.setVisibility(View.INVISIBLE);
            CartaAntigua3.setVisibility(View.INVISIBLE);
            CartaAntigua4.setVisibility(View.INVISIBLE);
            setplayersVisibilityCorrectly();
        }
        return presionado;
    }

    private void setPlayersVisible() {
        Jugador1.setVisibility(View.VISIBLE);
        Jugador2.setVisibility(View.VISIBLE);
        Jugador3.setVisibility(View.VISIBLE);
        Jugador4.setVisibility(View.VISIBLE);
        Jugador5.setVisibility(View.VISIBLE);
        Jugador6.setVisibility(View.VISIBLE);
        Jugador7.setVisibility(View.VISIBLE);
        Jugador8.setVisibility(View.VISIBLE);
        Jugador9.setVisibility(View.VISIBLE);
    }

    private void setPlayersInvisible() {
        Jugador1.setVisibility(View.INVISIBLE);
        Jugador2.setVisibility(View.INVISIBLE);
        Jugador3.setVisibility(View.INVISIBLE);
        Jugador4.setVisibility(View.INVISIBLE);
        Jugador5.setVisibility(View.INVISIBLE);
        Jugador6.setVisibility(View.INVISIBLE);
        Jugador7.setVisibility(View.INVISIBLE);
        Jugador8.setVisibility(View.INVISIBLE);
        Jugador9.setVisibility(View.INVISIBLE);
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
                    InfoText.setText("La Fase2 del Camino consiste en 4 rondas. En cada ronda se enseñaran 3 cartas. Si tienes alguna carta con el mismo número que las mostradas, te desharás de ella y repartiras trago. ¡El que se quede con más cartas al final jugará ElCamino!");
                    InfoText.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    Carta1.setVisibility(View.INVISIBLE);
                    Carta2.setVisibility(View.INVISIBLE);
                    Carta3.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility(View.INVISIBLE);
                    SiguienteButtonn.setVisibility(View.INVISIBLE);
                    RondaTV.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    MostrasJugadoresButton.setVisibility(View.INVISIBLE);
                    setPlayersInvisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);
                    InfoText.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    MostrasJugadoresButton.setVisibility(View.VISIBLE);
                    RondaTV.setVisibility(View.VISIBLE);

                    if(Carta3Enseñada & Carta2Enseñada & Carta1Enseñada) SiguienteButtonn.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);

                    if (MostrasJugadoresButton.getText().equals("Mostrar Jugadores")) {
                        Carta1.setVisibility(View.VISIBLE);
                        Carta2.setVisibility(View.VISIBLE);
                        Carta3.setVisibility(View.VISIBLE);
                    }
                    else {
                        MostrasJugadoresButton.setVisibility(View.VISIBLE);
                        setplayersVisibilityCorrectly();
                    }
                }
                return presionado;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {

        CartaAntigua1.setVisibility(View.INVISIBLE);
        CartaAntigua2.setVisibility(View.INVISIBLE);
        CartaAntigua3.setVisibility(View.INVISIBLE);
        CartaAntigua4.setVisibility(View.INVISIBLE);

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_2_1.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_2_1.this, GamesModalities.class);
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
        ShotsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean  presionado = false;
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    presionado = true;
                    ShotsText.setText("\n");
                    ShotsText.append("Tragos"+"\n"+ "\n");
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
                    InfoButton.setVisibility(View.INVISIBLE);
                    MostrasJugadoresButton.setVisibility(View.INVISIBLE);
                    setPlayersInvisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);
                    RondaTV.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    MostrasJugadoresButton.setVisibility(View.VISIBLE);

                    if (Carta3Enseñada & Carta2Enseñada & Carta1Enseñada)
                        SiguienteButtonn.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    if (MostrasJugadoresButton.getText().equals("Mostrar Jugadores")) {
                        Carta1.setVisibility(View.VISIBLE);
                        Carta2.setVisibility(View.VISIBLE);
                        Carta3.setVisibility(View.VISIBLE);
                    }
                    else {
                        MostrasJugadoresButton.setVisibility(View.VISIBLE);
                        setplayersVisibilityCorrectly();
                    }
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
                i.putExtra("Jugadores", PlayerClass);
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