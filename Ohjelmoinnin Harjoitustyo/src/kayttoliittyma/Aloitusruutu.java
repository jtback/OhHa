/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Sovelluslogiikka.Aloitus;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author jtback
 */
public class Aloitusruutu implements Runnable {

    private JFrame frame;
    private Aloitus aloitus;
    private String pelaaja1;
    private String pelaaja2;

    public Aloitusruutu(Aloitus aloitus) {
        this.aloitus = aloitus;
        this.pelaaja1 = "";
        this.pelaaja2 = "";
    }
    private boolean tarkistaSyotteet(){
        if(pelaaja1.length()> 20 || pelaaja2.length()> 20 )
            return false;
        else return true;
    }
    @Override
    public void run() {
        frame = new JFrame("Tervetuloa pelaamaan laivanupotusta");
        frame.setPreferredSize(new Dimension(600, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout tekstikentat = new GridLayout(3, 2);
        JPanel panel = new JPanel(tekstikentat);
        JLabel koonValinta = new JLabel("Valitse ruudukon koko:");
        panel.add(koonValinta);
        ButtonGroup radionappulat = new ButtonGroup();

        JPanel valinnat = luoKokovalinta(radionappulat, 11);
        panel.add(valinnat);
        JLabel nimi1 = new JLabel("Pelaaja 1:");
        panel.add(nimi1);
        JTextField syote1 = new JTextField();
        ActionListener nimenKuuntelija1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String syote = ae.getActionCommand();
                pelaaja1 = syote;
            }
        };
        
        syote1.addActionListener(null);
        
        syote1.addActionListener(nimenKuuntelija1);
        panel.add(syote1);
        JLabel nimi2 = new JLabel("Pelaaja 2:");
        panel.add(nimi2);
        JTextField syote2 = new JTextField();
        ActionListener nimenkuuntelija2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String syote = ae.getActionCommand();
                pelaaja2 = syote;
                
            }
        };
        syote2.addActionListener(nimenkuuntelija2);
        panel.add(syote2);
        JButton pelaaNappula = new JButton("Pelaa");
        ActionListener pelaa = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("moi");
                if(tarkistaSyotteet()){
                    aloitus.setPelaaja1(pelaaja1);
                    aloitus.setPelaaja2(pelaaja2);
                    frame.setVisible(false);
                    aloitus.laivatAsemiin();
                    
                            
                }
            }
        };

        pelaaNappula.addActionListener(pelaa);
        container.setLayout(new BorderLayout(10, 10));
        container.add(panel, BorderLayout.CENTER);
        container.add(pelaaNappula, BorderLayout.PAGE_END);
    }

    private JPanel luoKokovalinta(ButtonGroup radionappulat, int maksimiVaihtoehto) {
        GridLayout pino = new GridLayout(maksimiVaihtoehto / 2, 2);
        JPanel nappulapaneeli = new JPanel(pino);
        for (int i = 5; i <= maksimiVaihtoehto; i++) {
            String nappula = "" + i + "x" + i;
            JRadioButton koko1 = new JRadioButton(nappula);
            radionappulat.add(koko1);
            nappulapaneeli.add(koko1);
            KoonKuuntelija k = new KoonKuuntelija(aloitus);

            koko1.addActionListener(k);
        }

        return nappulapaneeli;
    }
}
