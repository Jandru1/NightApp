package com.example.jandrullue;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BarajaPersonalizada implements Serializable {

    private String player_name;
    private ArrayList<String> Baraja = new ArrayList<>();

    public BarajaPersonalizada() { };

    public ArrayList<String> getBaraja() { return this.Baraja;}

    public void añadir_carta(String carta) {
        this.Baraja.add(carta);
    }

    public String getplayer() {
        return this.player_name;
    }

    public void setplayer(String s) {
        this.player_name = s;
    }
}
