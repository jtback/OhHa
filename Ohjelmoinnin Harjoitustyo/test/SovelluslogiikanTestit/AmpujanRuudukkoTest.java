/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Koordinaatti;
import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Laivasto;
import Sovelluslogiikka.Peliruutu;
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
public class AmpujanRuudukkoTest {
    Ruudukko ruudukko;
    Koordinaatti koordinaatti;
    Koordinaatti koordinaatti2;
    JButton nappula;
    Laivasto laivasto;
    AmpujanRuudukko ampuja;
    Laiva kuunari;
    Laiva parkki;
    Laiva risteilija;
    Peliruutu[][] ruudut;
    Peliruutu ruutu;
    
    public AmpujanRuudukkoTest() {
    }
    
   
    @Before
    public void setUp() {
        ruudukko= new Ruudukko(5);
        nappula =new JButton();
        ruudukko.alustaRuudukko(nappula);
        koordinaatti = new Koordinaatti(4, 4, nappula);
        koordinaatti2 = new Koordinaatti(3,3, nappula);
        laivasto= new Laivasto();
        kuunari = new Laiva(3, "kuunari", laivasto);
        parkki = new Laiva(3, "parkki", laivasto);
        risteilija = new Laiva(4, "risteilija", laivasto);

        parkki.lisaaLaivaRuudukkoon(0, 0, ruudukko, true);
        risteilija.lisaaLaivaRuudukkoon(1, 4, ruudukko, false);
        ampuja = new AmpujanRuudukko(ruudukko);
        ampuja.alustaRuudukko();
        ruutu= new Peliruutu(ruudukko, ampuja);
        
    }
    /**
     * Testaa myös getRuudut ja setTila() metodin
     */
    @Test    
    public void ruudukonAlustaminenAsettaaPeliruudunTuntemattomaksi(){
        ruudut = ampuja.getRuudut();
        ruutu.setTila(Peliruutu.RuudunTila.TUNTEMATON);
        assertEquals(ruudut[0][0].getTila(), ruutu.getTila());
    }
    
    @Test
    public void ammuRuutuunHutiMuuttaRuudunTilanHudiksi(){
        ruudut = ampuja.getRuudut();
        ampuja.ammuRuutuun(0, 4);
    assertEquals(ruudut[0][4].getTila().toString(), "HUTI" );
        
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}