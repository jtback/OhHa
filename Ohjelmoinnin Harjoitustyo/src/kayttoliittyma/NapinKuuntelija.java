package kayttoliittyma;


import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Peliruutu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jtback
 */
public class NapinKuuntelija implements ActionListener{
    private AmpujanRuudukko ampujanRuudukko;
    private int x;
    private int y;
     private JButton nappi;
    
    public NapinKuuntelija(AmpujanRuudukko ampujanRuudut, int x, int y, JButton nappi){
        this.ampujanRuudukko= ampujanRuudut;
        this.x=x;
        this.y=y;
        this.nappi = nappi;
    }
            

    @Override
    public void actionPerformed(ActionEvent e) {
        Peliruutu[][] peliruudut = this.ampujanRuudukko.getRuudut();
        if(ampujanRuudukko.ammuRuutuun(x, y))
            System.out.println("hohoo"); 
        nappi.setText(peliruudut[x][y].getTila().toString());
    }
    
}
