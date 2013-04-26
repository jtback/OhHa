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
    public boolean listaOnTyhja(){
        if(laivat.isEmpty()){
            return true;
        }else return false;
    } 
   
}
