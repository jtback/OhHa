package Sovelluslogiikka;

import Sovelluslogiikka.Peliruutu;
import Sovelluslogiikka.Ruudukko;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jukka
 */
public class AmpujanRuudukko {

    private Ruudukko kohderuudukko;
    private Peliruutu[][] ruudut;
    private int sivunpituus;

    /**
     * Ruudukko koostuu Peliruutu -olioista
     *
     * @param vastustaja tietää vastustajan laivat.
     */
    public AmpujanRuudukko(Ruudukko vastustaja) {
        this.kohderuudukko = vastustaja;
        this.sivunpituus = vastustaja.getSivunPituus();
        this.ruudut = new Peliruutu[sivunpituus][sivunpituus];

    }

    /**
     * Alustetaan ruudukko Tuntematon - nimisilla ruudun tiloilla
     */
    public void alustaRuudukko() {
        for (int i = 0; i < this.sivunpituus; i++) {
            for (int j = 0; j < this.sivunpituus; j++) {
                ruudut[i][j] = new Peliruutu(kohderuudukko, this);
            }
        }
    }

    /**
     *
     * @return
     */
    public Peliruutu[][] getRuudut() {
        return ruudut;
    }

    /**
     * Graafisen käyttöliittymän kutsuma metodi joka kutsuu peliruudun metodia.
     * Sisältää tekstiversion tulostuskutsuja
     *
     * @param x
     * @param y
     * @return
     */
    public boolean ammuRuutuun(int x, int y) {
        if (this.ruudut[x][y].Osuuko(x, y)) {//kutsuu Peliruudun metodia
            //   System.out.println("osui");
            //   this.tulostaRuudukko();
            return true;
        } else {
            //   System.out.println("Ei osunut");          
            //   this.tulostaRuudukko();
            return false;
        }
    }

    /**
     * Teksti versiota ja testausta varten.
     *
     * @param x
     * @param y
     */
    public void tulostaRuutu(int x, int y) {
        System.out.print(ruudut[x][y] + " ");

    }

    /**
     * tekstiversiota ja testausta varten
     */
    public void tulostaRuudukko() {
        for (int i = 0; i < this.sivunpituus; i++) {
            for (int j = 0; j < this.sivunpituus; j++) {
                tulostaRuutu(i, j);

            }
            System.out.println("");
        }
    }
}
