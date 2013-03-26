
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
public class Laiva {
    private int koko;
    private int osumia;
    private String nimi;
    private ArrayList<Koordinaatti> koordinaatit;

    public Laiva(int koko, String nimi) {
        this.nimi = nimi;
        this.koko = koko;
        this.osumia = 0;
        this.koordinaatit = new ArrayList<>();
    }
    @Override
    public String toString(){
        return this.nimi;
        
    }
    public boolean lisaaLaivaRuudukkoon(Koordinaatti keula, Koordinaatti pera, HashMap laivaRuudukko) {
        if(keula.getX() == pera.getX()){ //Laiva on x-akselin suuntainen
            for(int j = keula.getY(); j<=pera.getY(); j++){
                Koordinaatti missaLaivaa = new Koordinaatti(keula.getX(),j);
                if(laivaRuudukko.containsKey(missaLaivaa)){
                    System.out.println("lisäys ei onnistunut, laivat törmäävät");
                    return false;
                }
                laivaRuudukko.put(missaLaivaa, this);
                this.koordinaatit.add(missaLaivaa);
                
            }
        }return true;
    }
    
}
