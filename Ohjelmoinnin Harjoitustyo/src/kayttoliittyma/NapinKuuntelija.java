package kayttoliittyma;


import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Laivasto;
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
     private AmpuminenGUI oma;
     private AmpuminenGUI vastustaja;
     private Laivasto vastustajanLaivat;
    
    public NapinKuuntelija(AmpujanRuudukko ampujanRuudut, int x, int y, JButton nappi, AmpuminenGUI oma, AmpuminenGUI vastustaja, Laivasto l){
        this.ampujanRuudukko= ampujanRuudut;
        this.x=x;
        this.y=y;
        this.nappi = nappi;
        this.oma=oma;
        this.vastustaja= vastustaja;
        this.vastustajanLaivat= l;
    }
            

    @Override
    public void actionPerformed(ActionEvent e) {
        Peliruutu[][] peliruudut = this.ampujanRuudukko.getRuudut();
        if(ampujanRuudukko.ammuRuutuun(x, y)){
             
        }
        nappi.setText(peliruudut[x][y].getTila().toString());
        
        oma.asetaNakymattomaksi();
        vastustaja.asetaNakyviin();
    }
    
}
