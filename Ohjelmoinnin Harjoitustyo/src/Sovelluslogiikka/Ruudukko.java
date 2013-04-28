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

    /**
     *luodaan koordinaattitaulukko ja lista käytetyistä koordinaateista ja 
     * Hashmap millä löytyy Laiva joka sijaitsee jossain koordinaatissa.
     * @param sivunPituus
     */
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

    /**
     *
     * @return
     */
    public HashMap<Koordinaatti, Laiva> getLaivojenKoordinaatit() {

        return laivojenKoordinaatit;
    }

    /**
     *Lisää koordinaatin listaan.
     * @param k
     */
    public void koordinaattiKaytetty(Koordinaatti k) {
        this.kaytetytKoordinaatit.add(k);
    }

    /**
     *
     * @return
     */
    public int getSivunPituus() {
        return this.sivunPituus;
    }

    /**
     *Tarkistaa koordinaatit mitä Laivanlisäysmetodi ehdottaa.
     * @param x ensimmäinen koordinaatti
     * @param y toinen koordinaatti
     * @return 
     */
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

    /**
     *Kysyy onko annetut koordinaatit ok ja tarkistaa onko ko. koordinaattia
     * Käytettyjen listassa.
     * @param x
     * @param y
     * @return
     */
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

    /**
     *Ohjelman rakentamisvaiheessa käytetty metodi, käytetään testauksessa
     * @param koordinaatti
     */
    public void koordinaattiTaulukkoon(Koordinaatti koordinaatti) {
        int x = koordinaatti.getX();
        int y = koordinaatti.getY();
        this.ruudukko[x][y] = koordinaatti;

    }

    /**
     *Jotta koordinaatteja käytettäessä käytettäisiin samoja koorkinaatti-olioita
     * otetaan koordinaatti taulukosta.
     * @param x
     * @param y
     * @return
     */
    public Koordinaatti koordinaattiTaulukosta(int x, int y) {
        Koordinaatti k;
        k = this.ruudukko[x][y];

        return k;
    }

    /**
     *Testaus vaiheen metodi
     * @return
     */
    public String tulostaLaivojenKoordinaatit() {
        String rivi = this.laivojenKoordinaatit.toString();
        return rivi;
    }

    /**
     *Testausta varten, ja mahdollista tekstikäyttöliittymää varten.
     */
    public void tulostaRuudukko() {
        for (int i = 0; i < this.sivunPituus; i++) {
            for (int j = 0; j < this.sivunPituus; j++) {
                System.out.print(ruudukko[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
