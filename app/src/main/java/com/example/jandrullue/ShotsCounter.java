package com.example.jandrullue;

public class ShotsCounter {

    private int Shots;
    private String Player;

    public ShotsCounter() { }

    public int getShots() { return this.Shots; }

    public String getPlayer() { return this.Player; }

    public void setShots(int shots) { this.Shots = shots; }

    public void setPlayer(String player) { this.Player = player; }

    public void SumShot() { Shots++; }

}
