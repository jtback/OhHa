
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Ruudukko kohderuudukko;
    private AmpujanRuudukko ammuntaruudukko;

    public Kayttoliittyma(Ruudukko ruudukko, AmpujanRuudukko ampuja) {
        kohderuudukko = ruudukko;
        ammuntaruudukko = ampuja;
    }

    @Override
    public void run() {
        frame = new JFrame("LaivanUpotus");
        frame.setPreferredSize(new Dimension(600, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        int ruutujaSivulla = kohderuudukko.getSivunPituus();
        GridLayout ruudukko = new GridLayout(ruutujaSivulla, ruutujaSivulla);
        container.setLayout(ruudukko);
        Peliruutu[][] peliruudut = ammuntaruudukko.getRuudut();


        for (int i = 0; i < ruutujaSivulla; i++) {
            for (int j = 0; j < ruutujaSivulla; j++) {
                container.add(new JButton(peliruudut[i][j].toString()));
            }
        }

    }

    public JFrame getFrame() {
        return frame;
    }
}
