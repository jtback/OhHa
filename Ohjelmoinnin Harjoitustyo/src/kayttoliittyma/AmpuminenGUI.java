package kayttoliittyma;


import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.AmpujanRuudukko;
import Sovelluslogiikka.Peliruutu;
import Sovelluslogiikka.Peliruutu;
import Sovelluslogiikka.Ruudukko;
import Sovelluslogiikka.Ruudukko;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class AmpuminenGUI implements Runnable {

    private JFrame frame;
    private Ruudukko kohderuudukko;
    private AmpujanRuudukko ammuntaruudukko;
  //  private JButton lisattavaNappi;

    public AmpuminenGUI(Ruudukko ruudukko, AmpujanRuudukko ampuja) {
         kohderuudukko = ruudukko;
         ammuntaruudukko = ampuja;
         
    }

    @Override
    public void run() {
        frame = new JFrame("LaivanUpotus");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        int ruutujaSivulla = kohderuudukko.getSivunPituus();
        GridLayout ruudukko = new GridLayout(ruutujaSivulla, ruutujaSivulla);
        container.setLayout(ruudukko);
        Peliruutu[][] peliruudut = this.ammuntaruudukko.getRuudut();
        

        for (int i = 0; i < ruutujaSivulla; i++) {
            for (int j = 0; j < ruutujaSivulla; j++) {
                JButton lisattavaNappi =new JButton(peliruudut[i][j].getTila().toString());
                NapinKuuntelija kuuntelija = new NapinKuuntelija(this.ammuntaruudukko, i, j, lisattavaNappi); 
                lisattavaNappi.addActionListener(kuuntelija);
                container.add(lisattavaNappi);
            }
        }

}

    public JFrame getFrame() {
        return frame;
    }
}
