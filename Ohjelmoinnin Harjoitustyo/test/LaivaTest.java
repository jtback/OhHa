/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    Ruudukko ruudukko;
    
    public LaivaTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
    @Before
    public void setUp() {
       kuunari = new Laiva(3, "kuunari");
       parkki = new Laiva(3, "parkki");
       ruudukko = new Ruudukko(5);        
        boolean tulos1 = parkki.lisaaLaivaRuudukkoon(new Koordinaatti(0, 0), new Koordinaatti(0, 2), ruudukko);
        
    }
    
//    @After
//    public void tearDown() {
//    }
    @Test
    public void konstruktoriAsettaaArvotOikein(){
    assertEquals("parkki", parkki.toString());
    }
    @Test
    public void samojenKoordinaattienAntaminenLaivoilleEiOnnistu(){
        
        assertEquals(false, kuunari.lisaaLaivaRuudukkoon(0, 2, ruudukko));
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}