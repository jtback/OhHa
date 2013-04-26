package Sovelluslogiikka;


import Sovelluslogiikka.Ruudukko;
import javax.swing.JButton;

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
    private JButton nappula;
    private Laiva koordinaatinLaiva;

    public Koordinaatti(int x, int y, JButton Nappula) {
        this.x = x;
        this.y = y;
        this.nappula = Nappula;
        
        
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public JButton getNappula() {
        return nappula;
    }

    public void setKoordinaatinLaiva(Laiva koordinaatinLaiva) {
        this.koordinaatinLaiva = koordinaatinLaiva;
        System.out.println(this.toString());
    }

    public Laiva getKoordinaatinLaiva() {
        return koordinaatinLaiva;
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


  
}
