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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trivial extends AppCompatActivity {

    private String dificultad;
    private HashMap<Integer,String> Preguntas;
    private HashMap<Integer,String> Respuestas;
    private HashMap<Integer,String> RespuestasIncorrectas;
    private TrivialClass Trivial = new TrivialClass();
    private int n;
    private ArrayList<String> numeross = new ArrayList<>();
    private ArrayList<String> Jugadores = new ArrayList<>();
    private TextView PreguntaTV;
    private TextView PlayerTV;
    private int k = 0;
    private View layout;
    private ShotsCounter Shots = new ShotsCounter();
    private PlayerClass PlayerClass = new PlayerClass();
    private Button AciertoButton;
    private Button FalloButton;
    private Button R1Button;
    private Button R2Button;
    private Button R3Button;
    private Button R4Button;
    private Button RespuestaButton;
    private ImageView HomeButton;
    private ImageView ShotsButton;
    private ImageView BackButton;
    private TextView ShotsText;
    private String Momento;
    private boolean VoF;
    int pregunta_num = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivial);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        PlayerTV = findViewById(R.id.jugadortv);
        PreguntaTV = findViewById(R.id.PreguntaTVtext);
        layout = findViewById(R.id.constraintLayoutASDF);
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
        BackButton = findViewById(R.id.BackButton);

        Shots = (ShotsCounter) getIntent().getSerializableExtra("Shots");
        PlayerClass = (PlayerClass) getIntent().getSerializableExtra("Jugadores");

        for (Map.Entry<String, Integer> entry : PlayerClass.getPlayersSex().entrySet()) {
            String key = entry.getKey();
            Jugadores.add(key);
        }
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
            RespuestasIncorrectas = Trivial.getRespuestasIncorrectasFacil();
            checkWithOrWithouOptions();
        }

        else if(dificultad.equals("medio")) {
            Preguntas = Trivial.getPreguntasTrivialMedio();
            Respuestas = Trivial.getRespuestasTrivialMedio();
            RespuestasIncorrectas = Trivial.getRespuestasIncorrectasMedio();
            checkWithOrWithouOptions();
        }

        else if(dificultad.equals("dificil")) {
            Preguntas = Trivial.getPreguntasTrivialDificil();
            Respuestas = Trivial.getRespuestasTrivialDificil();
            RespuestasIncorrectas = Trivial.getRespuestasIncorrectasDificil();
            checkWithOrWithouOptions();
        }
        //init_sin_opciones();
        //init_con_opciones();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void checkWithOrWithouOptions() {

        Log.d("Tamaño de Preguntas", ""+Preguntas.size());

        generarRandom();
        comprobarK();
        ShotsButt();
        HomeBut();
        BackButt();
        ++pregunta_num;
        PlayerTV.setText(Jugadores.get(k));
        if(dificultad.equals("dificil")){
            PreguntaTV.setText(Preguntas.get(n));
            init_sin_opciones();
        }
        else {

            boolean sin_options = EsConOptions(Preguntas.get(n));

            if (sin_options) {
                String pregunta_sin_opciones = getPreguntaSinOptions(Preguntas.get(n));
                PreguntaTV.setText(pregunta_sin_opciones);
                AciertoButton.setText("Acierto");
                FalloButton.setText("Fallo");
                init_sin_opciones();
            } else {
                PreguntaTV.setText(Preguntas.get(n));
                init_con_opciones();
            }
        }

    }

    private void BackButt() {
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trivial.this, TrivialDifficulties.class);
                intent.putExtra("Jugadores", PlayerClass);
                intent.putExtra("Shots", Shots);
                startActivity(intent);
            }
        });
    }

    private boolean EsConOptions(String s) {
        boolean sinOptions = false;
        if(s.startsWith(" IMBECIL")){ //NO ES NEPUI
            Log.d("Miramo bien sinopciones", ""+ "JEJEJEJEJE");
            sinOptions = true;
        }
        return sinOptions;
    }

    private String getPreguntaSinOptions(String s) {
        String ffinal = null;
        ffinal = s.substring(8);
        return ffinal;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void init_con_opciones() {
        RespuestaButton.setVisibility(View.INVISIBLE);
        AciertoButton.setText("V");
        FalloButton.setText("F");

        VoF = EsVerdadoOFalso(Preguntas.get(n));

        if(!VoF) PreguntaTV.setText(Preguntas.get(n));
        else {
            String pregunta = getPreguntaVoF(Preguntas.get(n));
            PreguntaTV.setText(pregunta);
        }
        setVisibilitiesCorrectly(VoF);
        if(!VoF) {
            Momento = "Opciones";
            setWrongAnswers();
            getTextButton();
        }
        else {
            Momento = "VoF";
            getVoF();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setWrongAnswers() {
        //MAS BIEN CONTAR LONGITUD DEL STRING!!!! Respuestas.get(n).lenght < ....
        int num_palabras = cuenta_palabras(Respuestas.get(n));
        Log.d("Numero de palabras : ", ""+num_palabras);
        String respuesta_final = Respuestas.get(n).substring(1,Respuestas.get(n).length()-1);
        int longitud = respuesta_final.length();

        String primera_respuesta_incorrecta = null;
        String segunda_respuesta_incorrecta = null;
        String tercera_respuesta_incorrecta = null;

        boolean con_primera = false;
        boolean con_segunda = false;
        boolean con_tercera = false;

        int m = 0;
        for(int i = 0; i < RespuestasIncorrectas.get(n).length();++i) {
            if(RespuestasIncorrectas.get(n).startsWith("||", i)){
                if(!con_primera & !con_segunda & !con_tercera){
                    con_primera = true;
                    Log.d("El valor de 1 'i' es : ", ""+i);
                    m = i;
                    primera_respuesta_incorrecta = RespuestasIncorrectas.get(n).substring(1,i-1);
                }
                else if(con_primera & !con_segunda & !con_tercera) {
                    Log.d("El valor de 2 'i' es : ", ""+i);
                    con_segunda = true;
                    segunda_respuesta_incorrecta = RespuestasIncorrectas.get(n).substring(m+3,i-1);
                    tercera_respuesta_incorrecta = RespuestasIncorrectas.get(n).substring(i+3,RespuestasIncorrectas.get(n).length()-1);
                }
            }
        }
        Log.d("Primera respuesta es : ", ""+primera_respuesta_incorrecta);
        Log.d("Segunda respuesta es : ", ""+segunda_respuesta_incorrecta);
        Log.d("Tercera respuesta es : ", ""+tercera_respuesta_incorrecta);

        double x = Math.random()*4+0;
        int x_random = (int) x;
        Log.d("random respuestas es", " "+x_random);

        if(x_random == 0){
            R1Button.setText(Respuestas.get(n));
            R2Button.setText(primera_respuesta_incorrecta);
            R3Button.setText(tercera_respuesta_incorrecta);
            R4Button.setText(segunda_respuesta_incorrecta);
        }
        else if(x_random == 1) {
            R1Button.setText(tercera_respuesta_incorrecta);
            R2Button.setText(Respuestas.get(n));
            R3Button.setText(segunda_respuesta_incorrecta);
            R4Button.setText(primera_respuesta_incorrecta);
        }
        else if(x_random == 2){
            R1Button.setText(primera_respuesta_incorrecta);
            R2Button.setText(segunda_respuesta_incorrecta);
            R3Button.setText(Respuestas.get(n));
            R4Button.setText(tercera_respuesta_incorrecta);
        }
        else {
            R1Button.setText(segunda_respuesta_incorrecta);
            R2Button.setText(tercera_respuesta_incorrecta);
            R3Button.setText(primera_respuesta_incorrecta);
            R4Button.setText(Respuestas.get(n));
        }

        check_longitud(R1Button);
        check_longitud(R2Button);
        check_longitud(R3Button);
        check_longitud(R4Button);

        /*
        R1Button.setText(Respuestas.get(n));
        R2Button.setText(Respuestas.get(n) + "A");
        R3Button.setText(Respuestas.get(n) + "B");
        R4Button.setText(Respuestas.get(n)+ "C");
         */
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void check_longitud(Button button) {

        int longitud = button.getText().toString().length();

        if(longitud < 13){//(num_palabras == 1){
            button.setMaxLines(1);
        }
        else if(longitud < 25){//(num_palabras < 3){
            button.setMaxLines(2);

        }
        else if(longitud < 37){//(num_palabras < 5){
            button.setMaxLines(3);

        }
        else if(longitud < 49){//(num_palabras < 7) {
            button.setMaxLines(4);

        }
        else {
            Log.d("Entro en el else","");
            button.setMaxLines(9);
        }
    }

    private int cuenta_palabras(String frase) {
        int m = 0;
        for(int i = 0; i < frase.length();++i) {
            if(frase.substring(i,i+1)!= " ") {
                m = i;
                i = 10000000;
            }
        }
        int palabras = 0;
        for(int i = m; i < frase.length();++i) {
            if (frase.substring(i,i+1).equals(" ")) ++palabras;
        }
        return palabras-1;
    }

    private void init_sin_opciones() {
        R1Button.setVisibility(View.INVISIBLE);
        R2Button.setVisibility(View.INVISIBLE);
        R3Button.setVisibility(View.INVISIBLE);
        R4Button.setVisibility(View.INVISIBLE);
        AciertoButton.setVisibility(View.INVISIBLE);
        FalloButton.setVisibility(View.INVISIBLE);
        RespuestaButton.setVisibility(View.VISIBLE);
        init2();
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
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        if(pregunta_num==Preguntas.size()) terminarTrivial();
                        else {
                            RespuestaButton.setVisibility(View.VISIBLE);
                            ++k;
                            checkWithOrWithouOptions();
                        }
                    }
                });
                FalloButton.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        if(pregunta_num==Preguntas.size()) terminarTrivial();
                        else {
                            RespuestaButton.setVisibility(View.VISIBLE);
                            Shots.SumShot(Jugadores.get(k));
                            ++k;
                            checkWithOrWithouOptions();
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
                    ShotsText.append("Tragos / Errores"+"\n"+ "\n");
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
                    BackButton.setVisibility(View.VISIBLE);
                }
                return presionado;
            }
        });
    }

    private void all_invisible() {
        PlayerTV.setVisibility(View.INVISIBLE);
        HomeButton.setVisibility(View.INVISIBLE);
        PreguntaTV.setVisibility(View.INVISIBLE);
        AciertoButton.setVisibility(View.INVISIBLE);
        FalloButton.setVisibility(View.INVISIBLE);
        R1Button.setVisibility(View.INVISIBLE);
        R2Button.setVisibility(View.INVISIBLE);
        R3Button.setVisibility(View.INVISIBLE);
        R4Button.setVisibility(View.INVISIBLE);
        RespuestaButton.setVisibility(View.INVISIBLE);
        BackButton.setVisibility(View.INVISIBLE);
    }

    private void all_visible() {
        PlayerTV.setVisibility(View.VISIBLE);
        PreguntaTV.setVisibility(View.VISIBLE);
        HomeButton.setVisibility(View.VISIBLE);
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
        else if(Momento.equals("Respuesta")) {

        }
        else if(Momento.equals("Opciones")){

            R1Button.setVisibility(View.VISIBLE);
            R2Button.setVisibility(View.VISIBLE);
            R3Button.setVisibility(View.VISIBLE);
            R4Button.setVisibility(View.VISIBLE);
        }
        else if(Momento.equals("VoF")){
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
        // getTextButton();
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
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("pregunta_num", ""+pregunta_num);
                Log.d("Preguntas_Size", ""+Preguntas.size());
                if(pregunta_num==Preguntas.size()) terminarTrivial();

                else if(Momento.equals("Respuesta")) {
                    ++k;
                    checkWithOrWithouOptions();
                }
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
        Intent intent = new Intent(Trivial.this, TrivialCampeon.class);
        intent.putExtra("Shots", Shots);
        intent.putExtra("Jugadores", PlayerClass);
        startActivity(intent);
    }
}