package Sovelluslogiikka;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class Ruudukko {

    private Koordinaatti[][] ruudukko;
    private int sivunPituus;
    private HashMap<Koordinaatti, Laiva> laivojenKoordinaatit;


    public Ruudukko(int sivunPituus) {
        this.ruudukko = new Koordinaatti[sivunPituus][sivunPituus];
        this.sivunPituus = sivunPituus;

        this.laivojenKoordinaatit = new HashMap<>();

    }

    public void putLaivanKoordinaatti(Koordinaatti laivanSisaltavaKoordinaatti, Laiva laiva) {
        this.laivojenKoordinaatit.put(laivanSisaltavaKoordinaatti, laiva);

    }

    public HashMap<Koordinaatti, Laiva> getLaivojenKoordinaatit() {
        return laivojenKoordinaatit;
    }

    public int getSivunPituus() {
        return this.sivunPituus;
    }

    private boolean annetutKoordinaatitOk(int x, int y) {
        if (x >= this.sivunPituus || y >= this.sivunPituus) {
            return false;
        }
        if (x < 0 || y < 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean koordinaattiVapaana(int x, int y) {
        if (this.annetutKoordinaatitOk(x, y) && this.ruudukko[x][y] == null) {
            return true;

        } else { 
            return false;
        }
    }

    public boolean koordinaattiTaulukkoon(int x, int y) {
        if (annetutKoordinaatitOk(x, y)) {
            if (this.ruudukko[x][y] == null) {
                this.ruudukko[x][y] = new Koordinaatti(x, y);
                return true;
            }
           
            else 
                         
                return false;
            }
        System.out.println("Antamasi arvot eivät mahdu taulukkoon. Taulukon koko on " + sivunPituus + "x" + sivunPituus);
        return false;
        }
    

    public Koordinaatti koordinaattiTaulukosta(int x, int y) {
        Koordinaatti viiteTaulukonAlkionMahdolliseenKoordinaattiin;
        viiteTaulukonAlkionMahdolliseenKoordinaattiin = this.ruudukko[x][y];
        
        return viiteTaulukonAlkionMahdolliseenKoordinaattiin;
    }

    public String tulostaLaivojenKoordinaatit() {
        String rivi = this.laivojenKoordinaatit.toString();
        return rivi;
    }

    public void tulostaRuudukko() {
        for (int i = 0; i < this.sivunPituus; i++) {
            for (int j = 0; j < this.sivunPituus; j++) {
                System.out.print(ruudukko[i][j] + " ");
            }
            System.out.println("");
        }
    }


}
