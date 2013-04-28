package Sovelluslogiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JButton;

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
    private ArrayList<Koordinaatti> kaytetytKoordinaatit;

    public Ruudukko(int sivunPituus) {
        this.ruudukko = new Koordinaatti[sivunPituus][sivunPituus];
        this.sivunPituus = sivunPituus;
        this.kaytetytKoordinaatit = new ArrayList<>();
        this.laivojenKoordinaatit = new HashMap<>();

    }

    /**
     * alustaRuudukko() toteutettu testausta varten. Normaalisti alustus
     * tapahtuu LaivojenLisäyksen yhteydessä, jossa kuhunkin koordinaattiin
     * liitetään yksilöllinen JButton.
     *
     * @param nappula
     */
    public void alustaRuudukko(JButton nappula) {
        for (int i = 0; i < this.sivunPituus; i++) {
            for (int j = 0; j < this.sivunPituus; j++) {
                ruudukko[i][j] = new Koordinaatti(i, j, nappula);
            }
        }
    }

    /**
     * HashMappiin tallenetaan avaimena Koordinaatti-olioita joihin kiinnitetään
     * Laivaolioita.
     *
     * @param laivanSisaltavaKoordinaatti
     * @param laiva
     */
    public void putLaivanKoordinaatti(Koordinaatti laivanSisaltavaKoordinaatti, Laiva laiva) {
        this.laivojenKoordinaatit.put(laivanSisaltavaKoordinaatti, laiva);

    }

    public HashMap<Koordinaatti, Laiva> getLaivojenKoordinaatit() {

        return laivojenKoordinaatit;
    }

    public void koordinaattiKaytetty(Koordinaatti k) {
        this.kaytetytKoordinaatit.add(k);
    }

    public int getSivunPituus() {
        return this.sivunPituus;
    }

    public boolean annetutKoordinaatitOk(int x, int y) {
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

        if (!this.annetutKoordinaatitOk(x, y)) {
            return false;
        }

        Koordinaatti k = koordinaattiTaulukosta(x, y);
        if (this.kaytetytKoordinaatit.contains(k)) {
            return false;
        } else {
            return true;
        }
    }

    public void koordinaattiTaulukkoon(Koordinaatti koordinaatti) {
        int x = koordinaatti.getX();
        int y = koordinaatti.getY();
        this.ruudukko[x][y] = koordinaatti;

    }

    public Koordinaatti koordinaattiTaulukosta(int x, int y) {
        Koordinaatti k;
        k = this.ruudukko[x][y];

        return k;
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
