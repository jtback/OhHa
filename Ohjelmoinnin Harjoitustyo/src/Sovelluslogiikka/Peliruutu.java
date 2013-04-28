package Sovelluslogiikka;


import java.util.HashMap;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class Peliruutu {

    Ruudukko kohderuudukko;
    AmpujanRuudukko ampujanruudukko;
    RuudunTila tila;

    public enum RuudunTila {

        TUNTEMATON("TUNTEMATON"), HUTI("   HUTI   "), OSUMA("  OSUMA   "), UPONNUT(" UPONNUT  ");
        private final String tekstina;

        RuudunTila(String tekstina) {
            this.tekstina = tekstina;
        }
    }

    public RuudunTila getTila() {
        return tila;
    }

    public void setTila(RuudunTila tila) {
        this.tila = tila;
    }

    public Peliruutu(Ruudukko Kohderuudut, AmpujanRuudukko ampujanRuudukko) {
        this.kohderuudukko = Kohderuudut;
        this.ampujanruudukko = ampujanRuudukko;
        this.tila = RuudunTila.TUNTEMATON;
    }

    public void ruudussaOsuma() {
        this.tila = RuudunTila.OSUMA;
    }

    public void ruudunLaivaUponnut() {

        this.tila = RuudunTila.UPONNUT;
    }

    public void ruudussaEiLaivaa() {
        this.tila = RuudunTila.HUTI;
    }

    public boolean Osuuko(int x, int y) {
        Koordinaatti laukauksenKohde = this.kohderuudukko.koordinaattiTaulukosta(x, y);
        
        if (laukauksenKohde.getKoordinaatinLaiva() == null) {
            this.ruudussaEiLaivaa();
            return false;
        }
        HashMap<Koordinaatti, Laiva> taulu = this.kohderuudukko.getLaivojenKoordinaatit();
        Laiva kohdeLaiva = taulu.get(laukauksenKohde);
        if(kohdeLaiva.getOsumattomatKoordinaatit().contains(laukauksenKohde)){    
            this.ruudussaOsuma();
            kohdeLaiva.uusiOsuma(laukauksenKohde, this.ampujanruudukko);
            return true;
        }
        
        return true;
        

    }

    @Override
    public String toString() {
        String rivi = this.tila.tekstina;
        return rivi;
    }
}
