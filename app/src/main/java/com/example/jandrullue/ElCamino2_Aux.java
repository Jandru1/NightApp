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

    private Button MostrasJugadoresButton;

    private TextView PlayerTV;
    private TextView Deshacer_cartasTV;
    private TextView ShotsText;
    private TextView InfoText;

    private ImageButton SiguienteButton;
    private ImageView ShotsButton;

    private ArrayList<String> Jugadores = new ArrayList<>();
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
    private PlayerClass PlayerClass;

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

        Jugador1 = findViewById(R.id.Player1TV2);
        Jugador2 = findViewById(R.id.Player2TV2);
        Jugador3 = findViewById(R.id.Player3TV2);
        Jugador4 = findViewById(R.id.Player4TV2);
        Jugador5 = findViewById(R.id.Player5TV2);
        Jugador6 = findViewById(R.id.Player6TV2);
        Jugador7 = findViewById(R.id.Player7TV2);
        Jugador8 = findViewById(R.id.Player8TV2);
        Jugador9 = findViewById(R.id.Player9TV2);

        CartaAntigua1 = findViewById(R.id.CartaAntigua12);
        CartaAntigua2 = findViewById(R.id.CartaAntigua22);
        CartaAntigua3 = findViewById(R.id.CartaAntigua32);
        CartaAntigua4 = findViewById(R.id.CartaAntigua42);

        MostrasJugadoresButton = findViewById(R.id.ShowPlayersButton2);


        Ronda = getIntent().getExtras().getInt("Ronda");
        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }
        numeross = getIntent().getStringArrayListExtra("numeross");

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        Deshacer_cartasTV.setTypeface(robotoLight);
        PlayerTV.setTypeface(robotoLight);
        ShotsText.setTypeface(robotoLight);
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

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        bundle = getIntent().getExtras().getBundle("BarajaPers "+k);
        if(bundle!=null) {
            BP = (BarajaPersonalizada) bundle.getSerializable("BarajaPersonalizada");
        }

        InfoButt();
        ShowCardsPlayersButt();


        Deshacer_Cartas(k, BP);
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

                    PlayerTV.setVisibility(View.INVISIBLE);
                    Deshacer_cartasTV.setVisibility(View.INVISIBLE);

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

                    PlayerTV.setVisibility(View.VISIBLE);
                    Deshacer_cartasTV.setVisibility(View.VISIBLE);
                }
            }
        });
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
                    InfoText.setText("La Fase2 del Camino consiste en 4 rondas. En cada ronda se enseñaran 3 cartas. Si tienes alguna carta con el mismo número que as mostradas, te desharás de ella y repartiras trago. ¡El que se quede con más cartas al final jugará ElCamino!");
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    PlayerTV.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility(View.INVISIBLE);
                    all_invisible();
                    MostrasJugadoresButton.setVisibility(View.INVISIBLE);
                    setPlayersInvisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    InfoText.setVisibility(View.INVISIBLE);
                    MostrasJugadoresButton.setVisibility(View.VISIBLE);

                    if (MostrasJugadoresButton.getText().equals("Mostrar Jugadores")) {
                        PlayerTV.setVisibility(View.VISIBLE);
                        Deshacer_cartasTV.setVisibility(View.VISIBLE);
                    }
                    else {
                        MostrasJugadoresButton.setVisibility(View.VISIBLE);
                        setplayersVisibilityCorrectly();
                    }
                    all_visible();
                }
                return presionado;
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void Deshacer_Cartas(int x, BarajaPersonalizada BP) {

        CartaAntigua1.setVisibility(View.INVISIBLE);
        CartaAntigua2.setVisibility(View.INVISIBLE);
        CartaAntigua3.setVisibility(View.INVISIBLE);
        CartaAntigua4.setVisibility(View.INVISIBLE);

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino2_Aux.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino2_Aux.this, GamesModalities.class);
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
                BP.getBaraja().set(j, "BORRAR");
            }
        }
        limpiar_baraja(BP);
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
                        intent.putExtra("Jugadores", PlayerClass);
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
                        intent.putExtra("Jugadores", PlayerClass);
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
                    ShotsText.setText("\n");
                    ShotsText.append("Tragos"+"\n"+ "\n");
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
                    MostrasJugadoresButton.setVisibility(View.INVISIBLE);
                    setPlayersInvisible();
                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                    InfoButton.setVisibility(View.VISIBLE);
                    MostrasJugadoresButton.setVisibility(View.VISIBLE);

                    if (MostrasJugadoresButton.getText().equals("Mostrar Jugadores")) {
                        PlayerTV.setVisibility(View.VISIBLE);
                        Deshacer_cartasTV.setVisibility(View.VISIBLE);
                    }
                    else {
                        MostrasJugadoresButton.setVisibility(View.VISIBLE);
                        setplayersVisibilityCorrectly();
                    }
                    all_visible();
                }
                return presionado;
            }
        });
    }

    private void all_visible() {
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