/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jukka
 */
public class Koordinaatti {

    private int x;
    private int y;

    public Koordinaatti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String Koordinaatti(int xarvo, int yarvo){
        String esitys = "";
        esitys += "("xarvo+","+yarvo+")";
        
        return esitys;  
    }
}
