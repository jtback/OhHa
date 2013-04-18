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
 * @author jtback
 */
public class RuudukkoTest {
    Ruudukko ruudukko;

    
    @Before
    public void setUp() {
        ruudukko= new Ruudukko(4);
    }
        
    @Test
    public void sivunPituusOnSamaKuinKonstruktorinParametri(){
        assertEquals(ruudukko.getSivunPituus(), 4);
    }
    @Test
    public void vaaranKoordinaatinAntaminen(){
        assertEquals(ruudukko.koordinaattiTaulukkoon(4, 4), false);
    }
    @Test
    public void koordinaattiVarattu(){
        ruudukko.koordinaattiTaulukkoon(3, 3);
        assertEquals(ruudukko.koordinaattiTaulukkoon(3, 3), false);
    }
    @Test
    public void koordinaattiVapaaJaOk(){
        assertEquals(ruudukko.koordinaattiTaulukkoon(2, 2), true);
        
    }
    @Test 
    public void palauttaaSamanKoordinaatin(){
        ruudukko.koordinaattiTaulukkoon(2, 2);
        assertEquals(ruudukko.koordinaattiTaulukosta(2, 2), new Koordinaatti(2, 2));
    }
    @Test 
    public void laivaLoytyyTaulusta(){
        Laiva kuunari = new Laiva(3, "Testilaiva");
        Koordinaatti koordinaatti = new Koordinaatti(0,0);
        this.ruudukko.putLaivanKoordinaatti(koordinaatti, kuunari);
        assertEquals(ruudukko.getLaivojenKoordinaatit().get(koordinaatti), kuunari);
    }
    
            
        

}
