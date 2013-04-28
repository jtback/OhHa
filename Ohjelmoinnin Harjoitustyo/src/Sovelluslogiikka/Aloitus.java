/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Laivasto;
import Sovelluslogiikka.Ruudukko;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import kayttoliittyma.AloitusruutuGUI;
import kayttoliittyma.AmpuminenGUI;
import kayttoliittyma.LaivojenLisaysGUI;

/**
 *
 * @author Jukka
 */
public class Aloitus {

    private boolean pelaaja1Valmis = false;
    private boolean pelaaja2Valmis = false;
    private String pelaaja1;
    private String pelaaja2;
    private int ruudukonKoko;
    private Ruudukko pelaaja1Ruudukko;
    private Ruudukko pelaaja2Ruudukko;
    private AmpujanRuudukko ampuja1;
    private AmpujanRuudukko ampuja2;
    private AmpuminenGUI ampuminen1;
    private AmpuminenGUI ampuminen2;
    private Laivasto laivasto1;
    private Laivasto laivasto2;
    Laivasto laivasto1Kopio = new Laivasto();
    Laivasto laivasto2Kopio = new Laivasto();

    /**
     *
     */
    public Aloitus() {
    }

    /**
     *
     * @param pelaaja1
     */
    public void setPelaaja1(String pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    /**
     *
     * @param pelaaja2
     */
    public void setPelaaja2(String pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    /**
     *
     * @param ruudukonKoko
     */
    public void setRuudukonKoko(int ruudukonKoko) {
        this.ruudukonKoko = ruudukonKoko;
    }

    /**
     *
     * @param pelaaja1Valmis
     */
    public void setPelaaja1Valmis(boolean pelaaja1Valmis) {
        this.pelaaja1Valmis = pelaaja1Valmis;
    }

    /**
     *
     * @param pelaaja2Valmis
     */
    public void setPelaaja2Valmis(boolean pelaaja2Valmis) {
        this.pelaaja2Valmis = pelaaja2Valmis;
    }

    /**
     *Luo ruudukon, missä on koordinaatteja. luo laivaston, jonka välittää 
     * LaivojenlisäysGUI:lle. Kopio luodaan, jotta ammuttaessakin olisi 
     * lista laivoista.
     */
    public void laivatAsemiin() {
        pelaaja1Ruudukko = new Ruudukko(ruudukonKoko);
        pelaaja2Ruudukko = new Ruudukko(ruudukonKoko);
        laivasto1 = luoLaivasto();
        laivasto1Kopio = laivasto1.kopioi();
        System.out.println(laivasto1);
        LaivojenLisaysGUI lisays1 = new LaivojenLisaysGUI(pelaaja1Ruudukko, pelaaja1, laivasto1Kopio, this, true);
        SwingUtilities.invokeLater(lisays1);
    }

    /**
     *Oma luokkansa pelaajan 2 laivojen asettamiselle tarvitaan, jotta Swingutilies.invokelater toimisi
     * järkevästi. Toimii kuten laivat Asemiin, mutta lopulta päädytään ampumaan.
     */
    public void laivatAsemiin2() {

        laivasto2 = luoLaivasto();
        System.out.println(laivasto2);
        laivasto2Kopio = laivasto2.kopioi();
        LaivojenLisaysGUI lisays2 = new LaivojenLisaysGUI(pelaaja2Ruudukko, pelaaja2, laivasto2Kopio, this, false);
        SwingUtilities.invokeLater(lisays2);
    }

    /**
     *Luodaan ruudukko, mistä käy ilmi, onko ruutuun ammuttu ja tekikö laukaus tuhoa.
     * Luodaan GUI missä nappia klikkaamalla ammutaan yhteen ruutuun per vuoro.
     */
    public void ammuLaivastoja() {
        ampuja2 = new AmpujanRuudukko(pelaaja1Ruudukko);
        ampuja2.alustaRuudukko();
        ampuja1 = new AmpujanRuudukko(pelaaja2Ruudukko);
        ampuja1.alustaRuudukko();
        ampuminen2 = new AmpuminenGUI(pelaaja1Ruudukko, ampuja2, laivasto1, pelaaja2, this);
        ampuminen1 = new AmpuminenGUI(pelaaja2Ruudukko, ampuja1, laivasto2, pelaaja1, this);
        ampuminen2.setVastustaja(ampuminen1);
        ampuminen1.setVastustaja(ampuminen2);

        SwingUtilities.invokeLater(ampuminen2);
        SwingUtilities.invokeLater(ampuminen1);

    }

    /**
     *Luo Laivasto-luokan olion, jonka sisään tallennetaan pelissä käytettävät
     * laivat. Laivoja on tällä hetkellä kolme.
     * 
     * @return
     */
    public Laivasto luoLaivasto() {
        Laivasto laivasto = new Laivasto();
        Laiva tykkivene = new Laiva(2, "tykkivene", laivasto);
        Laiva risteilija = new Laiva(4, "risteilija", laivasto);
        Laiva kuunari = new Laiva(3, "kuunari", laivasto);
        laivasto.lisaaLaiva(kuunari);
        laivasto.lisaaLaiva(risteilija);
        laivasto.lisaaLaiva(tykkivene);

        return laivasto;
    }

    /**
     *
     */
    public void aloittaa() {
        AloitusruutuGUI aloitus = new AloitusruutuGUI(this);

        SwingUtilities.invokeLater(aloitus);


    }
}
