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
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trivial extends AppCompatActivity {

    private String dificultad;
    private HashMap<Integer,String> Preguntas;
    private HashMap<Integer,String> Respuestas;
    private TrivialClass Trivial = new TrivialClass();
    private int n;
    private ArrayList<String> numeross = new ArrayList<>();
    private ArrayList<String> Jugadores;
    private TextView PreguntaTV;
    private TextView PlayerTV;
    private int k = 0;
    private View layout;
    private ShotsCounter Shots = new ShotsCounter();
    private Button AciertoButton;
    private Button FalloButton;
    private Button R1Button;
    private Button R2Button;
    private Button R3Button;
    private Button R4Button;
    private Button RespuestaButton;
    private ImageView HomeButton;
    private ImageView ShotsButton;
    private TextView ShotsText;
    private String Momento;
    private boolean VoF;
    int pregunta_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivial);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerTV = findViewById(R.id.jugadortv);
        PreguntaTV = findViewById(R.id.PreguntaTV);
        layout = findViewById(R.id.Trivial);
        AciertoButton = findViewById(R.id.VButton);
        FalloButton = findViewById(R.id.FButton);
        R1Button = findViewById(R.id.Respuesta1Button);
        R2Button = findViewById(R.id.Respuesta2Button);
        R3Button = findViewById(R.id.Respuesta3Button);
        R4Button = findViewById(R.id.Respuesta4Button);
        ShotsButton = findViewById(R.id.shotsButton);
        ShotsText = findViewById(R.id.shotsText);
        HomeButton = findViewById(R.id.homeButton);
        RespuestaButton = findViewById(R.id.AnswerButton);

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
        Jugadores = getIntent().getStringArrayListExtra("playerList");
        dificultad = getIntent().getExtras().getString("Dificultad");

        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        AciertoButton.setTypeface(robotoLight);
        FalloButton.setTypeface(robotoLight);
        R1Button.setTypeface(robotoLight);
        R2Button.setTypeface(robotoLight);
        R3Button.setTypeface(robotoLight);
        R4Button.setTypeface(robotoLight);
        ShotsText.setTypeface(robotoLight);
        RespuestaButton.setTypeface(robotoLight);
        PlayerTV.setTypeface(robotoLight);
        PreguntaTV.setTypeface(robotoLight);

        ShotsButton.setImageResource(R.drawable.chupitos_redondeado);

        if(dificultad.equals("facil")) {
            Preguntas = Trivial.getPreguntasTrivialFaciles();
            Respuestas = Trivial.getRespuestasTrivialFaciles();
        }
        else if(dificultad.equals("medio")) {
            Preguntas = Trivial.getPreguntasTrivialMedio();
            Respuestas = Trivial.getRespuestasTrivialMedio();
        }
        else if(dificultad.equals("dificil")) {
            Preguntas = Trivial.getPreguntasTrivialDificil();
            Respuestas = Trivial.getRespuestasTrivialDificil();
        }
        init();
    }

    private void init() {
        generarRandom();
        comprobarK();
        ShotsButt();
        HomeBut();
        VoF = EsVerdadoOFalso(Preguntas.get(n));
        /*
        if(!VoF) PreguntaTV.setText(Preguntas.get(n));
        else {
            String pregunta = getPreguntaVoF(Preguntas.get(n));
            PreguntaTV.setText(pregunta);
        }

         */
        ++pregunta_num;
        PreguntaTV.setText(Preguntas.get(n));
        PlayerTV.setText(Jugadores.get(k));

        //SIN OPCIONES
        R1Button.setVisibility(View.INVISIBLE);
        R2Button.setVisibility(View.INVISIBLE);
        R3Button.setVisibility(View.INVISIBLE);
        R4Button.setVisibility(View.INVISIBLE);
        AciertoButton.setVisibility(View.INVISIBLE);
        FalloButton.setVisibility(View.INVISIBLE);
        init2();
        //HASTA AQUI
        //setVisibilitiesCorrectly(VoF);
        /*
        if(!VoF) {
            Momento = "Opciones";
            R1Button.setText(Respuestas.get(n));
            R2Button.setText(Respuestas.get(n) + "A");
            R3Button.setText(Respuestas.get(n) + "B");
            R4Button.setText(Respuestas.get(n)+ "C");
            getTextButton();
        }
        else {
            Momento = "VoF";
            getVoF();
        }
         */
    }

    private void init2() {
        Momento = "SinRespuesta";
        RespuestaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Momento = "ConRespuesta";
                RespuestaButton.setVisibility(View.INVISIBLE);
                String RespuestaCorrecta = Respuestas.get(n);
                PreguntaTV.setText(RespuestaCorrecta);
                AciertoButton.setVisibility(View.VISIBLE);
                FalloButton.setVisibility(View.VISIBLE);
                AciertoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(pregunta_num==Preguntas.size()) terminarTrivial();
                        else {
                            RespuestaButton.setVisibility(View.VISIBLE);
                            ++k;
                            init();
                        }
                    }
                });
                FalloButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(pregunta_num==Preguntas.size()) terminarTrivial();
                        else {
                            RespuestaButton.setVisibility(View.VISIBLE);
                            Shots.SumShot(Jugadores.get(k));
                            ++k;
                            init();
                        }
                    }
                });
            }
        });
    }

    private void HomeBut() {

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Trivial.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(Trivial.this, GamesModalities.class);
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
                    all_invisible();
                    //  ShotsButton.setVisibility(View.INVISIBLE);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    presionado = false;
                    ShotsText.setVisibility(View.INVISIBLE);
                    all_visible();
                    HomeButton.setVisibility(View.VISIBLE);
                    ShotsButton.setVisibility(View.VISIBLE);
                }
                return presionado;
            }
        });
    }

    private void all_invisible() {
        PlayerTV.setVisibility(View.INVISIBLE);
        PreguntaTV.setVisibility(View.INVISIBLE);
        AciertoButton.setVisibility(View.INVISIBLE);
        FalloButton.setVisibility(View.INVISIBLE);
        R1Button.setVisibility(View.INVISIBLE);
        R2Button.setVisibility(View.INVISIBLE);
        R3Button.setVisibility(View.INVISIBLE);
        R4Button.setVisibility(View.INVISIBLE);
        RespuestaButton.setVisibility(View.INVISIBLE);
    }

    private void all_visible() {
        PlayerTV.setVisibility(View.VISIBLE);
        PreguntaTV.setVisibility(View.VISIBLE);
        if(Momento.equals("SinRespuesta")) {
            /*
            R1Button.setVisibility(View.VISIBLE);
            R2Button.setVisibility(View.VISIBLE);
            R3Button.setVisibility(View.VISIBLE);
            R4Button.setVisibility(View.VISIBLE);
             */
            RespuestaButton.setVisibility(View.VISIBLE);
        }
        else if (Momento.equals("ConRespuesta")) {
            AciertoButton.setVisibility(View.VISIBLE);
            FalloButton.setVisibility(View.VISIBLE);
        }
    }

    private String getPreguntaVoF(String s) {
        String ffinal = null;
        ffinal = s.substring(4);
        return ffinal;
    }

    private void getVoF() {
        AciertoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar_Respuesta("Verdadero");
            }
        });
        FalloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar_Respuesta("Falso");
            }
        });
    }

    private void Comprobar_Respuesta(String Respuesta) {
        Momento = "Respuesta";
        String RespuestaCorrecta = Respuestas.get(n);
        getTextButton();
        R1Button.setVisibility(View.INVISIBLE);
        R2Button.setVisibility(View.INVISIBLE);
        R3Button.setVisibility(View.INVISIBLE);
        R4Button.setVisibility(View.INVISIBLE);
        AciertoButton.setVisibility(View.INVISIBLE);
        FalloButton.setVisibility(View.INVISIBLE);
        if(Respuesta.equals(RespuestaCorrecta)) PreguntaTV.setText("Correcto! Repartes 1 trago");
        else {
            PreguntaTV.setText("Incorrecto! La respuesta correcta era: "+RespuestaCorrecta + ". Bebes 1 trago ");
            Shots.SumShot(Jugadores.get(k));
        }
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++k;
                init();
            }
        });
    }

    private void getTextButton() {

        R1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar_Respuesta(R1Button.getText().toString());
            }
        });
        R2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar_Respuesta(R2Button.getText().toString());
            }
        });
        R3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar_Respuesta(R3Button.getText().toString());
            }
        });
        R4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprobar_Respuesta(R4Button.getText().toString());
            }
        });
}

    private void setVisibilitiesCorrectly(boolean vof) {
        if (vof) {
            R1Button.setVisibility(View.INVISIBLE);
            R2Button.setVisibility(View.INVISIBLE);
            R3Button.setVisibility(View.INVISIBLE);
            R4Button.setVisibility(View.INVISIBLE);
            AciertoButton.setVisibility(View.VISIBLE);
            FalloButton.setVisibility(View.VISIBLE);
        }
        else {
            R1Button.setVisibility(View.VISIBLE);
            R2Button.setVisibility(View.VISIBLE);
            R3Button.setVisibility(View.VISIBLE);
            R4Button.setVisibility(View.VISIBLE);
            AciertoButton.setVisibility(View.INVISIBLE);
            FalloButton.setVisibility(View.INVISIBLE);
        }
    }

    private boolean EsVerdadoOFalso(String s) {
        boolean es_v_o_f = false;
        if(s.startsWith("VOF")){ //NO ES NEPUI
            Log.d("Miramos bien si es VoF", ""+ "JEJEJEJEJE");
            es_v_o_f = true;
        }

        if (es_v_o_f) return true;
        else return false;
    }

    private void comprobarK() {

        if(k==Jugadores.size()) k = 0;
    }

    public void generarRandom() {
        boolean ha_salido = false;
        double m = Math.random()*Preguntas.size()+0;
        n = (int) m;
        String n_string = Integer.toString(n);
        String quecoño = "";
        if (numeross.size()==0) {
            Log.d("Entro en el 1r if",""+quecoño);
            ha_salido = false;
        }
        else if(numeross.size()==Preguntas.size()){
            Log.d("Entro en el 2o if",""+quecoño);
            ha_salido=false;
        }
        else {
            Log.d("Entro en el 3r if",""+quecoño);
            for (int k = 0; k < numeross.size(); ++k) {
                if (numeross.get(k).equals(n_string)) ha_salido = true;
            }
        }
        Log.d("El numero random es: " , ""+n);
        if(ha_salido) generarRandom();
        else numeross.add(n_string);
    }

    private void terminarTrivial() {
        Intent intent = new Intent(Trivial.this, GamesModalities.class);
        startActivity(intent);
    }
}