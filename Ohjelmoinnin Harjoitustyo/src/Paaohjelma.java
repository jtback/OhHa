
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class Paaohjelma {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        Ruudukko ruudukko = new Ruudukko(4);
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
        if (tykkivene.lisaaLaivaRuudukkoon(1, 1, ruudukko)) {
            System.out.println("Laivan lisäys Onnistui");
        }
        if (risteilija.lisaaLaivaRuudukkoon(1,0, ruudukko)) {
            System.out.println("Lisäys Onnistui");
        }
        else System.out.println("Lisäys epäonnistui");
        //ruudukko.ammuRuudukkoon();
        System.out.println(ruudukko.tulostaLaivojenKoordinaatit());
        AmpujanRuudukko ampuja = new AmpujanRuudukko(ruudukko);
        Peliruutu peliruutu= new Peliruutu(ruudukko, ampuja);
        System.out.println(peliruutu);
        peliruutu.ruudussaOsuma();
        System.out.println(peliruutu);
        
        ampuja.alustaRuudukko();
        ampuja.tulostaRuudukko();
        ruudukko.tulostaRuudukko();
        ampuja.ammuRuutuun(3, 3);
        ampuja.ammuRuutuun(1, 1);
    }
    

    }

