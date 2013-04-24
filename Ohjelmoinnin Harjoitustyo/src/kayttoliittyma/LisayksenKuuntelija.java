/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;


import Sovelluslogiikka.Koordinaatti;
import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Ruudukko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jukka
 */
public class LisayksenKuuntelija implements ActionListener{
   private int x;
   private int y;
   private boolean vaakaan;
   private Ruudukko ruudukko;
   private Laiva lisattava;
    private LaivojenLisays lisaamo;
   
   public LisayksenKuuntelija(Ruudukko ruudukko, int x, int y, LaivojenLisays lisaamo, Laiva lisattava){
        this.x = x;
        this.y = y;
        this.ruudukko = ruudukko;
        this.lisaamo = lisaamo; 
        
    }
        
        
    
     @Override
    public void actionPerformed(ActionEvent e) {
         vaakaan=lisaamo.getVaakaanko();
         lisattava = lisaamo.getLisattava();
         System.out.println("vaakaan:"+vaakaan);
        if(lisattava.lisaaLaivaRuudukkoon(x, y, ruudukko, vaakaan)){
        Koordinaatti koordinaatti = ruudukko.koordinaattiTaulukosta(x, y);
         ruudukko.tulostaRuudukko();
         
         boolean eiTyhja =lisaamo.seuraavaLisattava();
         
        }
         }
    }
    


    

