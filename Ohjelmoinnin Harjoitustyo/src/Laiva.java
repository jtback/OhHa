
import java.util.ArrayList;


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
    private ArrayList<Koordinaatti> osumattomatKoordinaatit;
    private ArrayList<Koordinaatti> kaikkiKoordinaatit;

    public Laiva(int koko, String nimi) {
        this.nimi = nimi;
        this.koko = koko;
        this.osumia = 0;
        this.osumattomatKoordinaatit = new ArrayList<>();
        this.kaikkiKoordinaatit = new ArrayList<>();
    }

    public ArrayList<Koordinaatti> getOsumattomatKoordinaatit() {
        return osumattomatKoordinaatit;
    }

    public void uusiOsuma(Koordinaatti osumaKohta, AmpujanRuudukko ruudukko) {
        
        this.osumia = osumia + 1;
        this.osumattomatKoordinaatit.remove(osumaKohta);
        if (this.osumattomatKoordinaatit.isEmpty()) {
            lisaaUponneetRuudut(ruudukko);
        }

    }
    public void lisaaUponneetRuudut(AmpujanRuudukko ruudukko){
        for(Koordinaatti laivanKohta : this.kaikkiKoordinaatit){
            int x = laivanKohta.getX();
            int y = laivanKohta.getY();
            ruudukko.lisaaUponnutRuutu(x, y);
        }
    }
    
    public int getOsumia() {
        return osumia;
    }

    @Override
    public String toString() {
        return this.nimi;

    }
    /* LisäälaivaRuudukkoon testaa onko kaikki pyydetyt koordinaatit vapaina. Jos
     ovat, niin kutsuu kullekin koordinaattiTaulukkoon -metodia, joka luo uuden koordinaattiolion.
     Lisäksi asettaa hashmappiin put-metodilla ko. koordinaatti avaimenaan arvoksi tämän laivaolion.*/

    public boolean lisaaLaivaRuudukkoon(int x, int y, Ruudukko ruudukko) {
        int ruutujaVapaana = 0;
        for (int i = y; i <= y + this.koko - 1; i++) {
            if (ruudukko.koordinaattiVapaana(x, i)) {
                ruutujaVapaana++;
            }
        }
        if (ruutujaVapaana < this.koko) {
            return false;
        } else {
            for (int j = y; j <= y + this.koko - 1; j++) {
                ruudukko.koordinaattiTaulukkoon(x, j);
                ruudukko.putLaivanKoordinaatit(ruudukko.koordinaattiTaulukosta(x, j), this);
                this.osumattomatKoordinaatit.add(ruudukko.koordinaattiTaulukosta(x, j));
                this.kaikkiKoordinaatit.add(ruudukko.koordinaattiTaulukosta(x, j));
            }
        }
        return true;

    }
}
