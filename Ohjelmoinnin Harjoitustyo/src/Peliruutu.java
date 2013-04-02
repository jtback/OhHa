
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
        if (laukauksenKohde == null) {
            this.ruudussaEiLaivaa();
            return false;
        }
        HashMap<Koordinaatti, Laiva> taulu = this.kohderuudukko.getLaivojenKoordinaatit();
        Laiva kohdeLaiva = taulu.get(laukauksenKohde);
        if(kohdeLaiva.getOsumattomatKoordinaatit().contains(laukauksenKohde)){    
            kohdeLaiva.uusiOsuma(laukauksenKohde, this.ampujanruudukko);
            this.ruudussaOsuma();
            return true;
        }return false;
        

    }

    @Override
    public String toString() {
        String rivi = this.tila.tekstina;
        return rivi;
    }
}
