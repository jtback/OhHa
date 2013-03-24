
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jukka
 */
public class Ruudukko {
    private int[][] ruudukko;
    private int sivunPituus;
    private HashMap<Koordinaatti, Laiva> laivojenKoordinaatit;
    private Scanner lukija;

    public Ruudukko(int sivunPituus, Scanner lukija) {
        this.ruudukko = new int[sivunPituus][sivunPituus];
        this.sivunPituus = sivunPituus;
        this.lukija = lukija;
    }
    
    
    public void tulostaRuudukko(){
        for(int i=0; i < this.sivunPituus; i++){
            for(int j = 0; j < this.sivunPituus; i++){
                        
            }  lukija.pritnln("");
                   }
    }
    
    
    
}
