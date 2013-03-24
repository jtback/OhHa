/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jukka
 */
public class LyyraKorttiTest {
    
    LyyraKortti kortti;
    
    
    
    @Before
    public void setUp(){
        kortti = new LyyraKortti(10);
    } 

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {}
     
     @Test
     public void konstruktoriAsettaaSaldonOikein(){        
     
     assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());

     }
     
     
     @Test
     public void syoEdullisestiVahentaaSaldoaOikein(){
         kortti.syoEdullisesti();
         assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
     }
     
     @Test 
     public void syoMaukkaastiVahentaaSaldoaOikein(){
         
         kortti.syoMaukkaasti();
         
         assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
     } 
     
     @Test
     public void syoEdullisestiEiVieSaldoaNegalle(){
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         kortti.syoEdullisesti();
         assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
         
         
     }
}