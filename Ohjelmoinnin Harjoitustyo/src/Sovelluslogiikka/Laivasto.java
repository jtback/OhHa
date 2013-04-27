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
    public Laiva otaLaiva(){
        Laiva laiva = laivat.remove(0);
        return laiva;
    }
    public void poistaLaiva(Laiva laiva){
        laivat.remove(laiva);
        
    }
    public Laivasto kopioi(){
        Laivasto kopio = new Laivasto();
        for(Laiva l : laivat){
            kopio.lisaaLaiva(l);
        }return kopio;
    }
    public String toString(){
        String rivi = "";
        for(Laiva l: laivat){
            rivi += l.toString();
        }return rivi;
    }
    public boolean listaOnTyhja(){
        if(laivat.isEmpty()){
            return true;
        }else return false;
    } 
   
}
