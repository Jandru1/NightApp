package com.example.jandrullue;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;

public class PlayerClass implements Serializable {

    //0 -> hombre || 1 -> mujer
    private HashMap<String,Integer> PlayersSex = new HashMap<String, Integer>();

    public PlayerClass(){}

    public  HashMap<String,Integer> getPlayersSex() {
        return this.PlayersSex;
    }

    public void addPlayer(String nombre, int sexo){
        this.PlayersSex.put(nombre, sexo);
    }

    public int getSexo(String nombre) {
        return this.PlayersSex.get(nombre);
    }

    public void removePlayer(String nombre) {
        Log.d("Valor es",""+this.PlayersSex.get(nombre));
        this.PlayersSex.remove(nombre);
    }
}
