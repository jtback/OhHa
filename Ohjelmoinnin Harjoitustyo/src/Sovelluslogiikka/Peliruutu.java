package Sovelluslogiikka;


import java.util.HashMap;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Luodaan AmpuminenGUI:ssa
 * @author Jukka
 */
public class Peliruutu {

    Ruudukko kohderuudukko;
    AmpujanRuudukko ampujanruudukko;
    RuudunTila tila;

    /**
     *Ruudulla käytettävissä olevat tilavaihtoehdot
     */
    public enum RuudunTila {

        TUNTEMATON("TUNTEMATON"), HUTI("   HUTI   "), OSUMA("  OSUMA   "), UPONNUT(" UPONNUT  ");
        private final String tekstina;

        RuudunTila(String tekstina) {
            this.tekstina = tekstina;
        }
    }

    /**
     *päivittämistä ja testausta varten
     * @return
     */
    public RuudunTila getTila() {
        return tila;
    }

    /**
     *Testausta varten
     * @param tila
     */
    public void setTila(RuudunTila tila) {
        this.tila = tila;
    }

    /**
     *Tuntee kohderuudukon ja ruudukon mihin päivitetään ruudun status ampumisen jälkeen
     * @param Kohderuudut
     * @param ampujanRuudukko
     */
    public Peliruutu(Ruudukko Kohderuudut, AmpujanRuudukko ampujanRuudukko) {
        this.kohderuudukko = Kohderuudut;
        this.ampujanruudukko = ampujanRuudukko;
        this.tila = RuudunTila.TUNTEMATON;
    }

    /**
     *Peliruudun tilan päivittämiseen.
     */
    public void ruudussaOsuma() {
        this.tila = RuudunTila.OSUMA;
    }

    /**
     *Peliruudun tilan päivittämiseen.
     */
    public void ruudunLaivaUponnut() {

        this.tila = RuudunTila.UPONNUT;
    }

    /**
     *Peliruudun tilan päivittämiseen.
     */
    public void ruudussaEiLaivaa() {
        this.tila = RuudunTila.HUTI;
    }

    /**
     *Tarkistaa osuuko laukaus ja osuessa myös onko ko. kohtaan ammuttu aikaisemmin.
     * kutsuu peliruudun päivitysmetodeita muttei ruudunlaivauponnut()-metodia
     * @param x
     * @param y
     * @return
     */
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

    /**
     *Testausta varten, ja Myös ko. Jbuttonin päivittämiseen
     * @return
     */
    @Override
    public String toString() {
        String rivi = this.tila.tekstina;
        return rivi;
    }
}
