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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Koordinaatti other = (Koordinaatti) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public String koordinaatti(int xarvo, int yarvo){
        String esitys = "";
        esitys +="("+xarvo+","+yarvo+")";
        
        
        return esitys;  
    }
   public Laiva ammuKoordinaattiin(int x, int y){
       
       return null;
   }  
}
