package com.example.jandrullue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class YoNunca extends AppCompatActivity {

    private View layout;
    private TextView Preguntas;
    private ImageView HomeButton;
    private int i;
    private int n;
    private ArrayList<String> YoNuncaPreguntasPrivate;
    private ArrayList<String> numeross = new ArrayList<>();

    private String Level;
    private String Pack;

    public YoNunca() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        i = 0;
        YoNuncaPregs YoNuncaPreguntas = new YoNuncaPregs();
      //  ArrayList<String> YoNuncaPreguntas = new ArrayList<String>();

        Level = getIntent().getExtras().getString("Level");
        Pack = getIntent().getExtras().getString("Pack");

        Log.d("El Valor de Level es:", ""+Level);
        Log.d("El Valor de Pack es:", ""+Pack);

        if(Level.equals("Chill")){
            if(Pack.equals("Pack1")) {
                YoNuncaPreguntasPrivate = YoNuncaPreguntas.getChillPack1();
                init(YoNuncaPreguntas.getChillPack1());
            }
            else{
                YoNuncaPreguntasPrivate = YoNuncaPreguntas.getChillPack2();
                init(YoNuncaPreguntas.getChillPack2());
            }
        }
        else if(Level.equals("Medium")) {
            if(Pack.equals("Pack1")){
                YoNuncaPreguntasPrivate = YoNuncaPreguntas.getMediumPack1();
                init(YoNuncaPreguntas.getMediumPack1());
            }
            else {
                YoNuncaPreguntasPrivate = YoNuncaPreguntas.getMediumPack2();
                init(YoNuncaPreguntas.getMediumPack2());
            }
        }
        else {
            if(Pack.equals("Pack1")){
                YoNuncaPreguntasPrivate = YoNuncaPreguntas.getHotPack1();
                init(YoNuncaPreguntas.getHotPack1());
            }
            else {
                YoNuncaPreguntasPrivate = YoNuncaPreguntas.getHotPack2();
                init(YoNuncaPreguntas.getHotPack2());
            }
        }

    }

    private void init( ArrayList<String> YoNuncaPreguntas) {

        Log.d("El Valor de i es:", ""+i);
        generarRandom();
        //int n = numAleatorio.nextInt();
        Log.d("el numero random es: ", "el numero random es: "+ n);
        Log.d("el tamaño es:", "el tamaño es : "+ YoNuncaPreguntas.size());

        HomeButton = findViewById(R.id.HomeButton);
        Preguntas = (TextView) findViewById(R.id.Preguntas);
        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"font/Androgyne_TB.otf");
        Preguntas.setTypeface(robotoLight);
        Preguntas.setText(YoNuncaPreguntas.get(n));
        Preguntas.setTextColor(Color.parseColor("#000000"));
        layout = findViewById(R.id.Layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((i+1)==YoNuncaPreguntas.size()) {
                    Intent intent = new Intent(YoNunca.this, Fin.class);
                    startActivity(intent);
                }
                ++i;
                init(YoNuncaPreguntas);
            }
        });
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(YoNunca.this);
                dialogo1.setMessage("¿Deseas abandonar la partida?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent(YoNunca.this, GamesModalities.class);
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

    public void generarRandom() {
        boolean ha_salido = false;
        double m = Math.random()*YoNuncaPreguntasPrivate.size()+0;
        n = (int) m;
        String n_string = Integer.toString(n);

        if (numeross.size()==0) {
            ha_salido = false;
        }
        else if(numeross.size()==YoNuncaPreguntasPrivate.size()) ha_salido=false;
        else {
            for (int k = 0; k < numeross.size(); ++k) {
                if (numeross.get(k).equals(n_string)) ha_salido = true;
            }
        }
        Log.d("tamaño de NUMEROS es:", ""+numeross.size());
        if(ha_salido) generarRandom();
        else numeross.add(n_string);
        /*
        while (ha_salido & !numeross.get(k).equals(n_string)) {
            ++k;
            if (k == YoNuncaPreguntasPrivate.size() - 1) ha_salido = false;
        }
        //if(!ha_salido) numeross.add(n_string);
        //else generarRandom();
 */
    }


}