package SovelluslogiikanTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Aloitus;
import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Koordinaatti;
import Sovelluslogiikka.Laivasto;
import Sovelluslogiikka.Ruudukko;
import java.util.HashMap;
import javax.swing.JButton;
import kayttoliittyma.LaivojenLisaysGUI;
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
    Koordinaatti koordinaatti;
    Koordinaatti koordinaatti2;
    JButton nappula;
    Laivasto laivasto;

    @Before
    public void setUp() {
        ruudukko= new Ruudukko(4);
        nappula =new JButton();
        ruudukko.alustaRuudukko(nappula);
        koordinaatti = new Koordinaatti(4, 4, nappula);
        koordinaatti2 = new Koordinaatti(3,3, nappula);
        laivasto= new Laivasto();

    }
        
    @Test
    public void sivunPituusOnSamaKuinKonstruktorinParametri(){
        assertEquals(ruudukko.getSivunPituus(), 4);
    }
    @Test
    public void vaaranKoordinaatinAntaminen(){
        boolean arvo = ruudukko.annetutKoordinaatitOk(1,4);
        assertEquals(arvo, false);
    }
    @Test
    public void koordinaattiVarattu(){
        ruudukko.koordinaattiTaulukkoon(koordinaatti2);
        ruudukko.koordinaattiKaytetty(koordinaatti2);
        assertEquals(ruudukko.koordinaattiVapaana(3, 3), false);
    }
    @Test
    public void koordinaattiVapaaJaOk(){
        boolean arvo1 = ruudukko.koordinaattiVapaana(2, 2);
        assertEquals(arvo1, true);
        
    }
    @Test 
    public void palauttaaSamanKoordinaatin(){
        ruudukko.koordinaattiTaulukkoon(koordinaatti2);
        assertEquals(ruudukko.koordinaattiTaulukosta(2, 2), new Koordinaatti(2, 2, nappula));
    }
    /**
     * LaivaLoytyyTaulusta() testaa Tietorakenteen toimivuutta. Getteriä ruudukko-luokassa ja
     * put-metodia, jota kutsutaan Laiva-luokan TeeKirjanpito()-metodissa.
     */
    @Test 
    public void laivaLoytyyTaulusta(){
        Laiva kuunari = new Laiva(3, "Testilaiva", laivasto);
        Koordinaatti koordinaatti3 = ruudukko.koordinaattiTaulukosta(0, 0);
        kuunari.lisaaLaivaRuudukkoon(0, 0, ruudukko, true);       
        HashMap<Koordinaatti, Laiva> taulu = ruudukko.getLaivojenKoordinaatit();
        assertEquals(taulu.get(koordinaatti3), kuunari);
    }
    
            
        

}
