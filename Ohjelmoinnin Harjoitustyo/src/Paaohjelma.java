
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
    }
    
}
