
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class Laiva {

    private int koko;
    private int osumia;
    private String nimi;
    private ArrayList<Koordinaatti> koordinaatit;

    public Laiva(int koko, String nimi) {
        this.nimi = nimi;
        this.koko = koko;
        this.osumia = 0;
        this.koordinaatit = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.nimi;

    }

    public boolean lisaaLaivaRuudukkoon(int x, int y, Ruudukko ruudukko) {
        int ruutujaVapaana = 0;
        for (int i = y; i <= this.koko; i++) {
            if (ruudukko.koordinaattiVapaana(x, i)) {
                ruutujaVapaana++;
            }
        }
        if (ruutujaVapaana < this.koko) {
            return false;
        } else {
            for (int j = y; j <= this.koko; j++) {
                ruudukko.koordinaattiTaulukkoon(x, j);
                ruudukko.putLaivanKoordinaatit(ruudukko.koordinaattiTaulukosta(x, j), this);
            }
        }
        return true;

    }
//    public boolean lisaaLaivaRuudukkoon(Koordinaatti keula, Koordinaatti pera, Ruudukko ruudukko) {
//        if(keula.getX() == pera.getX()){ //Laiva on x-akselin suuntainen
//            for(int j = keula.getY(); j<=pera.getY(); j++){
//                Koordinaatti missaLaivaa = new Koordinaatti(keula.getX(),j);
//                if(ruudukko.getLaivojenKoordinaatit().containsKey(missaLaivaa)){
//                    System.out.println("lisäys ei onnistunut, laivat törmäävät");
//                    return false;
//                }
//                ruudukko.putLaivanKoordinaatit(missaLaivaa, this);
//                
//                this.koordinaatit.add(missaLaivaa);
//                
//            }
//        }return true;
//    }
}
