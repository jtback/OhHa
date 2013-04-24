package Kaynnistys;

import Sovelluslogiikka.Laivasto;
import Sovelluslogiikka.Laiva;
import kayttoliittyma.Kayttoliittyma;
import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Ruudukko;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import kayttoliittyma.LaivojenLisays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class Paaohjelma {

    public static Ruudukko ruudukko;
    private static Kayttoliittyma kayttoliittyma;

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        ruudukko = new Ruudukko(5);
        ruudukko.tulostaRuudukko();
        /*               if (ruudukko.koordinaattiTaulukkoon(0, 2)) {
         * System.out.println("Lisäys onnistui");
         * } else {
         * System.out.println("lisäys ei onnistunut");
         * }
         * if (ruudukko.koordinaattiTaulukkoon(0, 2)) {
         * System.out.println("Lisäys onnistui");
         * } else {
         * System.out.println("lisäys ei onnistunut");
         }*/


        ruudukko.koordinaattiTaulukkoon(4, 5);
        ruudukko.tulostaRuudukko();
        Laiva tykkivene = new Laiva(2, "tykkivene");
        Laiva risteilija = new Laiva(4, "risteilija");
        Laiva kuunari = new Laiva(3, "kuunari");
        Laivasto laivasto = new Laivasto();
        laivasto.lisaaLaiva(kuunari);
        laivasto.lisaaLaiva(risteilija);
        laivasto.lisaaLaiva(tykkivene);

        if (tykkivene.lisaaLaivaRuudukkoon(1, 1, ruudukko, false)) {
            System.out.println("Laivan lisäys Onnistui");
        }
        if (risteilija.lisaaLaivaRuudukkoon(1, 0, ruudukko, true)) {
            System.out.println("Lisäys Onnistui");
        } else {
            System.out.println("Lisäys epäonnistui");
        }

        if (kuunari.lisaaLaivaRuudukkoon(0, 1, ruudukko, false)) {
            System.out.println("pystyyn lisäys onnistui");
        } else {
            System.out.println("pystyyn lisäys epäonnistui");
        }
        System.out.println(ruudukko.tulostaLaivojenKoordinaatit());

//        System.out.println(ruudukko.tulostaLaivojenKoordinaatit());
        AmpujanRuudukko ampuja = new AmpujanRuudukko(ruudukko);

        ampuja.alustaRuudukko();
        ampuja.tulostaRuudukko();
        ruudukko.tulostaRuudukko();
//        ampuja.ammuRuutuun(3, 3);
//        ampuja.ammuRuutuun(1, 1);
//        ampuja.ammuRuutuun(1, 0);
//        ampuja.ammuRuutuun(1, 2);
        
        kayttoliittyma = new Kayttoliittyma(ruudukko, ampuja);
        LaivojenLisays laivojenlisays = new LaivojenLisays(ruudukko, "Niklas", laivasto, kayttoliittyma);
        SwingUtilities.invokeLater(laivojenlisays);
          
    

    
        
    }
}

