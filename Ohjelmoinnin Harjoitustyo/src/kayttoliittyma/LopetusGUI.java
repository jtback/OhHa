/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Sovelluslogiikka.Aloitus;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Viimeinen ikkuna, joka mahdollistaa sekä pelaamisen samoilla asetuksilla että
 * lopettamisen.
 *
 * @author Jukka
 */
public class LopetusGUI implements Runnable {

    String nimi;
    Aloitus aloitus;
    JFrame frame;
    AmpuminenGUI oma;
    AmpuminenGUI vastustaja;

    public LopetusGUI(String VoittajanNimi, Aloitus aloitus, AmpuminenGUI oma, AmpuminenGUI vastustaja ) {
        this.aloitus = aloitus;
        this.nimi = VoittajanNimi;
        this.oma = oma;
        this.vastustaja = vastustaja;
    }

    @Override
    public void run() {
        frame = new JFrame(nimi + " voitti.");
        frame.setPreferredSize(new Dimension(240, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    public void luoKomponentit(Container container) {
       JPanel pane = new JPanel();
        BoxLayout b = new BoxLayout(pane, 3);
        JLabel teksti = new JLabel(nimi+" Voitti. Pelaatteko uudelleen?" );
        JButton kylla = new JButton("Kyllä");
        ActionListener KylKuulee = new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
              aloitus.laivatAsemiin();
              vastustaja.suljeRuutu();
              oma.suljeRuutu();
              frame.setVisible(false);
           }
       };
        JButton ei = new JButton("Ei");
        ActionListener EiKuulee = new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
              vastustaja.suljeRuutu();
              oma.suljeRuutu();
              System.exit(0);
           }
       };
        kylla.addActionListener(KylKuulee);
        ei.addActionListener(EiKuulee);
        pane.add(teksti);
        pane.add(kylla);
        pane.add(ei);
        container.add(pane);
    }
}
