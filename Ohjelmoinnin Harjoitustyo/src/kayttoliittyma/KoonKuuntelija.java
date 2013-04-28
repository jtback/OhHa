/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Sovelluslogiikka.Aloitus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jukka
 */
public class KoonKuuntelija implements ActionListener {
    private final Aloitus aloitus;
    public KoonKuuntelija(Aloitus aloitus){
        this.aloitus = aloitus;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
             String merkit=ae.getActionCommand();

          int koko=5;
        try {
            koko = ((Number)NumberFormat.getInstance().parse(merkit)).intValue();
        } catch (ParseException ex) {
            Logger.getLogger(KoonKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("koko =");
                        
                       
                        aloitus.setRuudukonKoko(koko);
 
    }
    
}
