package Sovelluslogiikka;


import Sovelluslogiikka.Ruudukko;
import javax.swing.JButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Koordinaatti tuntee Laivan, joka on ko. koordinaatissa, sekä JButtonin, jonka
 * tilaa pääsee päivittämään. Metodeina settereitä ja gettereitä, joita ei
 * kommentoitu.
 * @author Jukka
 */
public class Koordinaatti {

    private int x;
    private int y;
    private JButton nappula;
    private Laiva koordinaatinLaiva;

    /**
     *
     * @param x
     * @param y
     * @param Nappula
     */
    public Koordinaatti(int x, int y, JButton Nappula) {
        this.x = x;
        this.y = y;
        this.nappula = Nappula;
        
        
    }

    /**
     *
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     *
     * @return
     */
    public JButton getNappula() {
        return nappula;
    }

    /**
     *
     * @param koordinaatinLaiva
     */
    public void setKoordinaatinLaiva(Laiva koordinaatinLaiva) {
        this.koordinaatinLaiva = koordinaatinLaiva;

    }

    /**
     *
     * @return
     */
    public Laiva getKoordinaatinLaiva() {
        return koordinaatinLaiva;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }


    /**
     *
     * @param obj
     * @return
     */
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
