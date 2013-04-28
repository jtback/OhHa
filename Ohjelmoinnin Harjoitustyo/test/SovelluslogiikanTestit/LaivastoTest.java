/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Laivasto;
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
public class LaivastoTest {
    Laivasto laivasto;
    Laiva laiva;
    Laiva kuunari;
    Laiva risteilija;
    Laiva tykkivene;
    public LaivastoTest() {
    }
    
   
    @Before
    public void setUp() {
        laivasto = new Laivasto();
        tykkivene = new Laiva(2, "tykkivene", laivasto);
        risteilija = new Laiva(4, "risteilija", laivasto);
        kuunari = new Laiva(3, "kuunari", laivasto);
        laivasto.lisaaLaiva(kuunari);
        laivasto.lisaaLaiva(risteilija);
        laivasto.lisaaLaiva(tykkivene);
    }
    
    @Test
    public void otaLaivaPalauttaaEkanaLisatyn(){
        laiva = laivasto.otaLaiva();
        assertEquals(kuunari, laiva);
    }
    /**
     * Testaa poistaLaivan() ja Listaontyhjan().
     */
    @Test
    public void poistaLaivaTyhjentaalistan(){
        laivasto.poistaLaiva(kuunari);
        laivasto.poistaLaiva(tykkivene);
        laivasto.poistaLaiva(risteilija);
        assertEquals(laivasto.listaOnTyhja(), true);
    }
    @Test
    public void kopioLaivatAntaaSamanLaivanSamallaPaikalla(){
        Laivasto kopio = laivasto.kopioi();
        assertEquals(laivasto.otaLaiva(), kopio.otaLaiva());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}