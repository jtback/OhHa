/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Sovelluslogiikka.Ruudukko;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Jukka
 */
public class LaivojenLisays implements Runnable {

    private JFrame frame;
    private Ruudukko ruudukko;
    private String Pelaaja;

    public LaivojenLisays(Ruudukko ruudukko, String Pelaaja) {

        this.ruudukko = ruudukko;
        this.Pelaaja = Pelaaja;
    }

    @Override
    public void run() {
        frame = new JFrame("Lisää laivat");
        frame.setPreferredSize(new Dimension(500, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    private void luoKomponentit(Container container){
        int ruutujaSivulla = ruudukko.getSivunPituus();
        System.out.println("ruutujaSivulla: "+ruutujaSivulla);
        GridLayout ruudut = new GridLayout(ruutujaSivulla, ruutujaSivulla);
        JPanel panel = new JPanel(ruudut);
        
        GridLayout suuntaValinta = new GridLayout(3, 1);
        JPanel panel2 = new JPanel(suuntaValinta);
        JButton vaakaan = new JButton("Lisää laiva vaakaan");
        JButton pystyyn = new JButton("Lisää laiva pystyyn");
        panel2.add(vaakaan);
        panel2.add(pystyyn);
        container.setLayout(new BorderLayout());
        for (int i = 0; i < ruutujaSivulla; i++) {
            for (int j = 0; j < ruutujaSivulla; j++) {
                JButton lisattavaNappi =new JButton();
                
                panel.add(lisattavaNappi);
            }
        }
       container.add(panel, BorderLayout.CENTER);
//        container.add(panel2, BorderLayout.LINE_END);
    }
    
    
     public JFrame getFrame() {
        return frame;
    }  
    }
    
    

