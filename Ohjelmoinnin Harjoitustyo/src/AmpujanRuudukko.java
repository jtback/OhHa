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

    public AmpujanRuudukko(Ruudukko vastustaja) {
        this.kohderuudukko = vastustaja;
        this.sivunpituus = vastustaja.getSivunPituus();
        this.ruudut = new Peliruutu[sivunpituus][sivunpituus];
        
    }
    public  void alustaRuudukko(){
        for(int i = 0; i < this.sivunpituus; i++){
            for(int j = 0; j < this.sivunpituus; j++){
                ruudut[i][j]= new Peliruutu(kohderuudukko, this);
            }
        }
    }

    public Peliruutu[][] getRuudut() {
        return ruudut;
    }

    
    public void ammuRuutuun(int x, int y){
        if(this.ruudut[x][y].Osuuko(x, y))//kutsuu Peliruudun metodia
            System.out.println("osui");
        else 
            System.out.println("Ei osunut");
        this.tulostaRuudukko();
    }
    
 /*   public void lisaaUponnutRuutu(int x, int y){
        ruudut[x][y].ruudunLaivaUponnut();
    }*/
    public void tulostaRuutu(int x, int y){
        System.out.print(ruudut[x][y]+" ");
                
    }
    public void tulostaRuudukko(){
        for(int i = 0; i < this.sivunpituus; i++){
            for(int j = 0; j < this.sivunpituus; j++){
                tulostaRuutu(i,j);
                
            }
            System.out.println("");
        }
    }
}
