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
    private int osumia;
    private String nimi;
    private ArrayList<Koordinaatti> osumattomatKoordinaatit;
    private ArrayList<Koordinaatti> kaikkiKoordinaatit;
    private boolean vaakaan;

    public Laiva(int koko, String nimi) {
        this.nimi = nimi;
        this.koko = koko;
        this.osumia = 0;
        this.osumattomatKoordinaatit = new ArrayList<>();
        this.kaikkiKoordinaatit = new ArrayList<>();
    }

    public ArrayList<Koordinaatti> getOsumattomatKoordinaatit() {
        return osumattomatKoordinaatit;
    }

    public void uusiOsuma(Koordinaatti osumaKohta, AmpujanRuudukko ruudukko) {

        this.osumia = osumia + 1;
        this.osumattomatKoordinaatit.remove(osumaKohta);
        if (this.osumattomatKoordinaatit.isEmpty()) {
            lisaaUponneetRuudut(ruudukko);
        }

    }

    /**
     * Metodi kutsuu Ampujanruudukon metodia getRuudut, jotta pystytään
     * viittaamaan käsiteltävään Peliruutu-olioon.
     *
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

    public int getOsumia() {
        return osumia;
    }

    @Override
    public String toString() {
        return this.nimi;

    }
    /* LisäälaivaRuudukkoon testaa onko kaikki pyydetyt koordinaatit vapaina. Jos
     ovat, niin kutsuu kullekin koordinaattiTaulukkoon -metodia, joka luo uuden koordinaattiolion.
     Lisäksi asettaa hashmappiin put-metodilla ko. koordinaatti avaimenaan arvoksi tämän laivaolion.*/

    public boolean ruudutOvatVapaina(int x, int y, Ruudukko ruudukko, boolean vaakaan) {
        int ruutujaVapaana = 0;

        if (vaakaan) {
            for (int k = y; k < y + this.koko; k++) {
                if (ruudukko.koordinaattiVapaana(x, k)) {
                    ruutujaVapaana++;
                    //   System.out.println(vakio + "," + k + " vapaa");
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

    public boolean lisaaLaivaRuudukkoon(int x, int y, Ruudukko ruudukko, boolean vaakaan) {

        if (ruudutOvatVapaina(x, y, ruudukko, vaakaan)) {
            if (vaakaan) {
                for (int muuttuva = y; muuttuva <= y + this.koko - 1; muuttuva++) {
                    Koordinaatti koordinaatti;

                    ruudukko.koordinaattiTaulukkoon(x, muuttuva);
                    koordinaatti = ruudukko.koordinaattiTaulukosta(x, muuttuva);
                    ruudukko.putLaivanKoordinaatti(koordinaatti, this);
                    this.osumattomatKoordinaatit.add(koordinaatti);
                    this.kaikkiKoordinaatit.add(koordinaatti);
                }
            } else {


                for (int muuttuva = x; muuttuva <= x + this.koko - 1; muuttuva++) {
                    Koordinaatti koordinaatti;
                    ruudukko.koordinaattiTaulukkoon(muuttuva, y);
                    koordinaatti = ruudukko.koordinaattiTaulukosta(muuttuva, y);
                    ruudukko.putLaivanKoordinaatti(koordinaatti, this);
                    this.osumattomatKoordinaatit.add(koordinaatti);
                    this.kaikkiKoordinaatit.add(koordinaatti);
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
