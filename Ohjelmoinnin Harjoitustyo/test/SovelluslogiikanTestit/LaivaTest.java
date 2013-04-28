package SovelluslogiikanTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Laivasto;
import Sovelluslogiikka.Ruudukko;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jukka
 */
public class LaivaTest {

    Laiva kuunari;
    Laiva parkki;
    Laiva risteilija;
    Ruudukko ruudukko;
    private JButton nappula;

    public LaivaTest() {
    }

    @Before
    public void setUp() {
        Laivasto laivasto = new Laivasto();
        ruudukko = new Ruudukko(5);
        nappula = new JButton();
        ruudukko.alustaRuudukko(nappula);
        kuunari = new Laiva(3, "kuunari", laivasto);
        parkki = new Laiva(3, "parkki", laivasto);
        risteilija = new Laiva(4, "risteilija", laivasto);

        parkki.lisaaLaivaRuudukkoon(0, 0, ruudukko, true);
        risteilija.lisaaLaivaRuudukkoon(1, 4, ruudukko, false);


    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {

        assertEquals("parkki: pituus 3", parkki.toString());
    }
  @Test
    public void samojenKoordinaattienAntaminenLaivoilleEiOnnistu(){
        
        assertEquals(false, kuunari.lisaaLaivaRuudukkoon(0, 0, ruudukko, true));
        
    }

    @Test
    public void ruudutOvatVapainaPalauttaFalse() {

        assertEquals(false, kuunari.ruudutOvatVapaina(1, 2, ruudukko, true));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}