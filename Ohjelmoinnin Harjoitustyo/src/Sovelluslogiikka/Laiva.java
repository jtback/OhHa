package Sovelluslogiikka;

import Sovelluslogiikka.Koordinaatti;
import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Peliruutu;
import Sovelluslogiikka.Ruudukko;
import java.util.ArrayList;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class Laiva {

    private int koko;
    private String nimi;
    private ArrayList<Koordinaatti> osumattomatKoordinaatit;
    private ArrayList<Koordinaatti> kaikkiKoordinaatit;
    private final Laivasto laivasto;

    /**
     *
     * @param koko
     * @param nimi testausta varten, ja lisäämisvuoross on myös nähtävissä
     * @param laivasto Laiva tietää mihin laivastoon kuuluu.
     */
    public Laiva(int koko, String nimi, Laivasto laivasto) {
        this.nimi = nimi;
        this.koko = koko;
        this.osumattomatKoordinaatit = new ArrayList<>();
        this.kaikkiKoordinaatit = new ArrayList<>();
        this.laivasto = laivasto;
    }


    public ArrayList<Koordinaatti> getOsumattomatKoordinaatit() {
        return osumattomatKoordinaatit;
    }

    /**
     *
     * @param osumaKohta
     * @param ruudukko
     */
    public void uusiOsuma(Koordinaatti osumaKohta, AmpujanRuudukko ruudukko) {


        this.osumattomatKoordinaatit.remove(osumaKohta);
        if (this.osumattomatKoordinaatit.isEmpty()) {
            lisaaUponneetRuudut(ruudukko);
            laivasto.poistaLaiva(this);
        }

    }

    public ArrayList<Koordinaatti> getKaikkiKoordinaatit() {
        return kaikkiKoordinaatit;
    }

    /**
     * Metodi kutsuu Ampujanruudukon metodia getRuudut, jotta pystytään
     * viittaamaan käsiteltävään Peliruutu-olioon.
     * @param ampujanRuudukko
     */
    public void lisaaUponneetRuudut(AmpujanRuudukko ampujanRuudukko) {
        Peliruutu[][] ruudut = ampujanRuudukko.getRuudut();

        for (Koordinaatti laivanKohta : this.kaikkiKoordinaatit) {
            int x = laivanKohta.getX();
            int y = laivanKohta.getY();
            ruudut[x][y].ruudunLaivaUponnut();

            //     System.out.println(this.kaikkiKoordinaatit);
        }
    }

    /**
     * Testejä varten
     *
     * @return
     */
    @Override
    public String toString() {
        return this.nimi + ": pituus " + this.koko;

    }
    /* LisäälaivaRuudukkoon testaa onko kaikki pyydetyt koordinaatit vapaina. Jos
     ovat, niin kutsuu kullekin koordinaattiTaulukkoon -metodia, joka luo uuden koordinaattiolion.
     Lisäksi asettaa hashmappiin put-metodilla ko. koordinaatti avaimenaan arvoksi tämän laivaolion.*/

    /**
     *
     * @param x
     * @param y
     * @param ruudukko , mihin ollaan lisäämässä this -laivaoliota
     * @param vaakaan muuttuja joka on true kun pelaaja haluaa lisätä laivan
     * vaakaan
     * @return
     */
    public boolean ruudutOvatVapaina(int x, int y, Ruudukko ruudukko, boolean vaakaan) {
        int ruutujaVapaana = 0;

        if (vaakaan) {
            for (int k = y; k < y + this.koko; k++) {
                if (ruudukko.koordinaattiVapaana(x, k)) {
                    ruutujaVapaana++;

                }
            }
        } else {
            for (int k = x; k < x + this.koko; k++) {
                if (ruudukko.koordinaattiVapaana(k, y)) {
                    ruutujaVapaana++;
                }
            }
        }
        if (ruutujaVapaana == this.koko) {

            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param ruudukko, mihin laiva lisätään.
     * @param vaakaan, on true jos laivaa ollaan lisäämässä vaakaan
     * @return palauttaa true jos laiva lisätään onnistuneesti, muutoin false.
     */
    public boolean lisaaLaivaRuudukkoon(int x, int y, Ruudukko ruudukko, boolean vaakaan) {

        if (ruudutOvatVapaina(x, y, ruudukko, vaakaan)) {
            if (vaakaan) {
                for (int muuttuva = y; muuttuva <= y + this.koko - 1; muuttuva++) {
                    Koordinaatti koordinaatti;
                    koordinaatti = ruudukko.koordinaattiTaulukosta(x, muuttuva);
                    teeKirjanPito(koordinaatti, ruudukko);
                }
            } else {

                for (int muuttuva = x; muuttuva <= x + this.koko - 1; muuttuva++) {
                    Koordinaatti koordinaatti;
                    koordinaatti = ruudukko.koordinaattiTaulukosta(muuttuva, y);
                    teeKirjanPito(koordinaatti, ruudukko);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tekee Laivan lisäämiseen liittyvän kirjanpidon.
     *
     * @param koordinaatti
     * @param ruudukko
     */
    private void teeKirjanPito(Koordinaatti koordinaatti, Ruudukko ruudukko) {
        koordinaatti.setKoordinaatinLaiva(this);
        ruudukko.koordinaattiKaytetty(koordinaatti);
        ruudukko.putLaivanKoordinaatti(koordinaatti, this);
        this.osumattomatKoordinaatit.add(koordinaatti);
        this.kaikkiKoordinaatit.add(koordinaatti);
    }
}
