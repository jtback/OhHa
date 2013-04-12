
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jtback
 */
public class NapinKuuntelija implements ActionListener{
    AmpujanRuudukko ampujanRuudukko;
    int x;
    int y;
    
    public NapinKuuntelija(AmpujanRuudukko ampujanRuudut, int x, int y){
        this.ampujanRuudukko= ampujanRuudut;
        this.x=x;
        this.y=y;
    }
            

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ampujanRuudukko.ammuRuutuun(x, y); 
        
    }
    
}
