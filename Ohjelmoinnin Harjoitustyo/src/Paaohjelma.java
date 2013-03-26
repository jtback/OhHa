
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
    public static void main(String[] args){
        
        Scanner lukija = new Scanner(System.in);
        
        Ruudukko ruudukko = new Ruudukko(4, lukija);
        ruudukko.tulostaRuudukko();
        Laiva tykkivene =new Laiva(2,"tykkivene");
        Laiva risteilija = new Laiva(4,"risteilija");
        if(tykkivene.lisaaLaivaRuudukkoon(new Koordinaatti(1,2), new Koordinaatti(1,3),ruudukko)){
            System.out.println("Lisäys Onnistui");
        }
        if(risteilija.lisaaLaivaRuudukkoon(new Koordinaatti(1,0), new Koordinaatti(1,3),ruudukko)){
            System.out.println("Lisäys Onnistui");
        }
        //ruudukko.ammuRuudukkoon();
        System.out.println(ruudukko.tulostaLaivojenKoordinaatit());
    }
    
}
