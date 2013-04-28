package Sovelluslogiikka;


import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Koordinaatti;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jukka
 */
public class Laivasto {
    private ArrayList<Laiva>laivat;


    public Laivasto() {
        laivat = new ArrayList<>();
    }
    public void lisaaLaiva(Laiva laiva){
        laivat.add(laiva);
    }
    /**
     *Ottaa listalta ensimmäisen laivan, lista lyhenee. Käytetään 
     * lisättäessä laivoja.
     * @return
     */
    public Laiva otaLaiva(){
        Laiva laiva = laivat.remove(0);
        return laiva;
    }
    /**
     *Poistaa upotetun laivan listalta, käytetään ammuttaessa.
     * @param laiva
     */
    public void poistaLaiva(Laiva laiva){
        laivat.remove(laiva);
        
    }
    /**
     *Luo uuden laivasto-olion, joka sisältää samat Laiva-olion kuin kopioinnin
     * kohde.
     * @return
     */
    public Laivasto kopioi(){
        Laivasto kopio = new Laivasto();
        for(Laiva l : laivat){
            kopio.lisaaLaiva(l);
        }return kopio;
    }
    /**
     *Testausta varten
     * @return
     */
    public String toString(){
        String rivi = "";
        for(Laiva l: laivat){
            rivi += l.toString();
        }return rivi;
    }
    /**
     * Käytetään laivojen lisäämisen  ja pelin lopettamiseen.
     * @return 
     */
    public boolean listaOnTyhja(){
        if(laivat.isEmpty()){
            return true;
        }else return false;
    } 
   
}
