package com.example.jandrullue;

import java.io.Serializable;
import java.util.HashMap;

public class ShotsCounter implements Serializable {

    private HashMap<String, Integer> Shots = new HashMap<String, Integer>();

    public ShotsCounter() { }

    public int getShots(String player) { return this.Shots.get(player); }

    public void SumShot(String player) {
        int a = this.Shots.get(player);
        ++a;
        this.Shots.put(player,a);
    }

    public HashMap<String, Integer> getShotsMap() {
        return this.Shots;
    }
    public void addPlayer(String player) {

    }

}
