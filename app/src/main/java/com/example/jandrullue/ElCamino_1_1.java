package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
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

public class ElCamino_1_1 extends AppCompatActivity {

    private ArrayList<String> Jugadores = new ArrayList<>();
    private ArrayList<String> numeross = new ArrayList<>();

    private int n;
    private int k = 0;

    private ImageButton RojoButton;
    private ImageButton NegroButton;
    private View SiguienteButton;

    private ImageView HomeButton;
    private ImageView CartaIV;
    private ImageView ShotsButton;
    private ImageView InfoButton;

    private TextView pregunta;
    private TextView player;
    private TextView ShotsText;
    private TextView InfoText;

    private Intent intent;
    private BarajaPoker Baraja = new BarajaPoker();

    private ShotsCounter Shots = new ShotsCounter();
    private PlayerClass PlayerClass = new PlayerClass();

    private boolean clickado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_camino_1_1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }
        RojoButton = findViewById(R.id.RojoButton);
        NegroButton = findViewById(R.id.NegroButton);
        SiguienteButton = findViewById(R.id.ElCamino1_1);
        HomeButton = findViewById(R.id.HomeButton1_1);
        pregunta = findViewById(R.id.RojoONegro);
        player = findViewById(R.id.Player);
        CartaIV = findViewById(R.id.CIV);
        InfoButton = findViewById(R.id.InfoButtton);
        InfoText = findViewById(R.id.textView6);

        ShotsText = findViewById(R.id.shotsText3);
        ShotsButton = findViewById(R.id.shotsButton3);
        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        pregunta.setTypeface(robotoLight);
        player.setTypeface(robotoLight);
        ShotsText.setTypeface(robotoLight);
        InfoText.setTypeface(robotoLight);

        intent = new Intent(ElCamino_1_1.this, ElCamino_1_2.class);
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
                    HomeButton.setVisibility(View.INVISIBLE);
                    player.setVisibility(View.INVISIBLE);
                    ShotsButton.setVisibility(View.INVISIBLE);
                    all_invisible();
                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    player.setVisibility(View.VISIBLE);
                    ShotsText.setVisibility(View.INVISIBLE);
                    InfoText.setVisibility(View.INVISIBLE);
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
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
                    ShotsText.append("Tragos"+"\n"+ "\n");
                    for (Map.Entry<String,Integer> entry : Shots.getShotsMap().entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        ShotsText.append(key + ": " + value + "\n"+ "\n"+ "\n");
                        // do stuff
                    }
                    InfoButton.setVisibility(View.INVISIBLE);
                    ShotsText.setVisibility(View.VISIBLE);
                    HomeButton.setVisibility(View.INVISIBLE);
                    player.setVisibility(View.INVISIBLE);
                    InfoButton.setVisibility(View.INVISIBLE);
                    all_invisible();

                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    player.setVisibility(View.VISIBLE);
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
            CartaIV.setVisibility(View.VISIBLE);
            pregunta.setVisibility(View.VISIBLE);
            NegroButton.setVisibility(View.INVISIBLE);
            RojoButton.setVisibility(View.INVISIBLE);
        }
        else {
            CartaIV.setVisibility(View.VISIBLE);
            pregunta.setVisibility(View.VISIBLE);
            NegroButton.setVisibility(View.VISIBLE);
            RojoButton.setVisibility(View.VISIBLE);
        }
    }

    private void all_invisible() {
        CartaIV.setVisibility(View.INVISIBLE);
        pregunta.setVisibility(View.INVISIBLE);
        NegroButton.setVisibility(View.INVISIBLE);
        RojoButton.setVisibility(View.INVISIBLE);
    }

    private void Primer_caso() {
        clickado = false;
        CartaIV.setImageResource(R.drawable.cartapordetras);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ElCamino_1_1.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(ElCamino_1_1.this, GamesModalities.class);
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

        player.setText(Jugadores.get(k));
        pregunta.setText("¿De qué color es la carta?");
        RojoButton.setVisibility(View.VISIBLE);
        NegroButton.setVisibility(View.VISIBLE);

        RojoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String color = "rojo";
                enseñar_carta(color);
            }
        });

        NegroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickado = true;
                String color = "negro";
                enseñar_carta(color);
            }
        });
    }

    private void enseñar_carta(String color) {
        generarRandom();

        String carta = Baraja.getBaraja().get(n);
        Log.d("CARTA 1: ", ""+carta);

        String color_carta = getColorCarta(carta);
        RojoButton.setVisibility(View.INVISIBLE);
        NegroButton.setVisibility(View.INVISIBLE);
        SiguienteButton.setVisibility(View.VISIBLE);

        if(!color.equals(color_carta)){
            String color_respuesta = null;
            if (color.equals("negro")) color_respuesta = "rojo";
            if (color.equals("rojo")) color_respuesta = "negro";
            pregunta.setText("Lástima!" + "   " + "Tu carta es un " + carta + ". Bebes 1 trago!");
            Shots.SumShot(Jugadores.get(k));
        }

        else {
            pregunta.setText("Felicidades! Tu carta es un " + carta + ". Repartes 1 trago");
        }
        SetImageInCarta(carta,CartaIV);
        BarajaPersonalizada BarajaPers = new BarajaPersonalizada();
        BarajaPers.añadir_carta(carta);
        BarajaPers.setplayer(Jugadores.get(k));
        Bundle b = new Bundle();
        b.putSerializable("BarajaPersonalizada", BarajaPers);

        intent.putExtra("BarajaPers " + k , b);

        SiguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickado) {
                    if (k + 1 == Jugadores.size()) {
                        intent.putExtra("Jugadores", PlayerClass);
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

    private String getColorCarta(String carta) {
        String color = null;
        String tipo = null;

        for(int i = 0; i < carta.length(); ++i) {
            if (carta.startsWith("de", i)){
                tipo = carta.substring(i+3);
            }
        }
        if(tipo.equals("corazones") || tipo.equals("diamantes")) color = "rojo";
        else if(tipo.equals("treboles") || tipo.equals("picas")) color = "negro";
        return color;
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