
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
        laivojenKoordinaatit = new HashMap<>();
    }

    public void putLaivanKoordinaatit(Koordinaatti laivanSisaltavaKoordinaatti, Laiva laiva) {
        this.laivojenKoordinaatit.put(laivanSisaltavaKoordinaatti, laiva);
        
    }
    
    
    public void tulostaRuudukko(){
        for(int i=0; i < this.sivunPituus; i++){
            for(int j = 0; j < this.sivunPituus; j++){
                System.out.print(ruudukko[i][j]+" ");   
            }  System.out.println("");
                   }
    }
    
    public void ammuRuudukkoon(){
        System.out.println("Anna x-koordinaatti väliltä 0-"+sivunPituus+".");
        int x = lukija.nextInt();
        System.out.println("Anna y-koordinaatti väliltä 0-"+sivunPituus+".");
        int y = lukija.nextInt();
        System.out.println("Ammuit pisteeseen ("+x+","+y+")");
        laivojenKoordinaatit.get(x,y);
       
    }
    
}
