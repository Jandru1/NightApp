package com.example.jandrullue;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BarajaPoker {

    private ArrayList<String> Baraja = new ArrayList<>();

    public BarajaPoker() {

        this.Baraja.add("A de corazones");
        this.Baraja.add("A de diamantes");
        this.Baraja.add("A de treboles");
        this.Baraja.add("A de picas");

        this.Baraja.add("2 de corazones");
        this.Baraja.add("2 de diamantes");
        this.Baraja.add("2 de treboles");
        this.Baraja.add("2 de picas");

        this.Baraja.add("3 de corazones");
        this.Baraja.add("3 de diamantes");
        this.Baraja.add("3 de treboles");
        this.Baraja.add("3 de picas");

        this.Baraja.add("4 de corazones");
        this.Baraja.add("4 de diamantes");
        this.Baraja.add("4 de treboles");
        this.Baraja.add("4 de picas");

        this.Baraja.add("5 de corazones");
        this.Baraja.add("5 de diamantes");
        this.Baraja.add("5 de treboles");
        this.Baraja.add("5 de picas");

        this.Baraja.add("6 de corazones");
        this.Baraja.add("6 de diamantes");
        this.Baraja.add("6 de treboles");
        this.Baraja.add("6 de picas");

        this.Baraja.add("7 de corazones");
        this.Baraja.add("7 de diamantes");
        this.Baraja.add("7 de treboles");
        this.Baraja.add("7 de picas");

        this.Baraja.add("8 de corazones");
        this.Baraja.add("8 de diamantes");
        this.Baraja.add("8 de treboles");
        this.Baraja.add("8 de picas");

        this.Baraja.add("9 de corazones");
        this.Baraja.add("9 de diamantes");
        this.Baraja.add("9 de treboles");
        this.Baraja.add("9 de picas");

        this.Baraja.add("10 de corazones");
        this.Baraja.add("10 de diamantes");
        this.Baraja.add("10 de treboles");
        this.Baraja.add("10 de picas");

        this.Baraja.add("J de corazones");
        this.Baraja.add("J de diamantes");
        this.Baraja.add("J de treboles");
        this.Baraja.add("J de picas");

        this.Baraja.add("Q de corazones");
        this.Baraja.add("Q de diamantes");
        this.Baraja.add("Q de treboles");
        this.Baraja.add("Q de picas");

        this.Baraja.add("K de corazones");
        this.Baraja.add("K de diamantes");
        this.Baraja.add("K de treboles");
        this.Baraja.add("K de picas");

    }

    public ArrayList<String> getBaraja(){ return this.Baraja; }

    public String get_num(int n) {
        String s = this.Baraja.get(n);
        return get_num_por_carta(s);
    }
    public String get_num_por_carta(String s) {
        if(s.substring(0,1).equals("1")) { s = s.substring(0,2);}
        else s = s.substring(0,1);
        return s;
        /*
        else if (s.substring(0,1).equals("J")){ s = "11";}
        else if (s.substring(0,1).equals("Q")){ s = "12";}
        else if (s.substring(0,1).equals("K")){ s = "13";}
        else if (s.substring(0,1).equals("A")){ s = "14";}
        else s = s.substring(0,1);
        return Integer.parseInt(s);

         */
    }
}
