/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import Kaynnistys.Paaohjelma;
import Sovelluslogiikka.Aloitus;
import Sovelluslogiikka.Koordinaatti;
import Sovelluslogiikka.Laiva;
import Sovelluslogiikka.Laivasto;
import Sovelluslogiikka.Ruudukko;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Jukka
 */
public class LaivojenLisays implements Runnable {

    private JFrame frame;
    private Ruudukko ruudukko;
    private String Pelaaja;
    private boolean vaakaanko;
    private Laivasto laivasto;
    private Laiva lisattava;
    private AmpuminenGUI ampuminenGUI;
    private HashMap<String, JButton>  nappulataulu;
    private final Aloitus aloitus;
    private boolean onPelaaja1;
    public LaivojenLisays(Ruudukko ruudukko, String Pelaaja, Laivasto laivasto, Aloitus aloitus, boolean onPelaaja1) {

        this.ruudukko = ruudukko;
        this.Pelaaja = Pelaaja;
        this.laivasto = laivasto;
        this.aloitus = aloitus;
        this.onPelaaja1 = onPelaaja1;
    }
    public boolean getVaakaanko(){
        return this.vaakaanko;
    }
    public void lisaysPystyyn(){
        
            vaakaanko = false;
    }
    public void lisaysVaakaan(){
        vaakaanko = true;
    }
    public void seuraavaLisattava(){
        if(!laivasto.listaOnTyhja()){ 
        this.lisattava = laivasto.otaLaiva();        
        }else {
            if(onPelaaja1){
            aloitus.setPelaaja1Valmis(true);
            aloitus.laivatAsemiin2();
            }
            else{
                aloitus.setPelaaja2Valmis(true);
                aloitus.ammuLaivastoja();
            
            }
            frame.setVisible(false);
            frame.dispose();     
            
        }
    }
    public Laiva getLisattava(){
        return this.lisattava;
    }
    @Override
    public void run() {
        frame = new JFrame("Lisää laivat");
        frame.setPreferredSize(new Dimension(600, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    private void luoKomponentit(Container container){
        int ruutujaSivulla = ruudukko.getSivunPituus();
        GridLayout ruudut = new GridLayout(ruutujaSivulla, ruutujaSivulla);
        JPanel panel = new JPanel(ruudut);
        nappulataulu = new HashMap<>();
        GridLayout suuntaValinta = new GridLayout(3, 1);
        JPanel panel2 = new JPanel(suuntaValinta);
        ActionListener suunnanValinta = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if("vaakaan".equals(ae.getActionCommand())){
                System.out.println("Vaakaan");
                lisaysVaakaan();
                }else if("pystyyn".equals(ae.getActionCommand())){
                System.out.println("Pystyyn");
                lisaysPystyyn();
                } else{
                    // some thing went horribly wrong
                }
                System.out.println("vaakaan = "+vaakaanko);
                

            }
        };
        
        JButton vaakaan = new JButton("Lisää laiva vaakaan");
        JButton pystyyn = new JButton("Lisää laiva pystyyn");
        vaakaan.setActionCommand("vaakaan");
        vaakaan.addActionListener(suunnanValinta);
        pystyyn.setActionCommand("pystyyn");
        pystyyn.addActionListener(suunnanValinta);
        panel2.add(vaakaan);
        panel2.add(pystyyn);
        lisattava = laivasto.otaLaiva();
        panel2.add(new JLabel(lisattava.toString()));
        container.setLayout(new BorderLayout());
        
        for (int i = 0; i < ruutujaSivulla; i++) {
            for (int j = 0; j < ruutujaSivulla; j++) {
                JButton lisattavaNappi =new JButton();
                String teksti = lisattavaNappi.getText();
                nappulataulu.put(teksti, lisattavaNappi);
                LisayksenKuuntelija k= new LisayksenKuuntelija(ruudukko, i, j, this );
                lisattavaNappi.addActionListener(k);
                Koordinaatti nappulanKoordinaatti = new Koordinaatti(i, j, lisattavaNappi);
                ruudukko.koordinaattiTaulukkoon(nappulanKoordinaatti);
                panel.add(lisattavaNappi);
            }
        }
       container.add(panel, BorderLayout.CENTER);
        container.add(panel2, BorderLayout.LINE_END);
    }
    private void paivitaNappula(JButton nappula){
        nappula.setBackground(Color.yellow);
        
    }
    public void merkkaaLaiva(Laiva laiva){
        ArrayList<Koordinaatti> koordinaatit = laiva.getKaikkiKoordinaatit();
        for(Koordinaatti k : koordinaatit){
            paivitaNappula(k.getNappula());
        }
        
    }
    
     public JFrame getFrame() {
        return frame;
    }  
    }
    
    

