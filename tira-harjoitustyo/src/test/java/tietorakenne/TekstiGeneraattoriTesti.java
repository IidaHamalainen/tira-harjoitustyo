
package tietorakenne;

import harjoitustyo.markovinketju.TekstiGeneraattori;
import harjoitustyo.markovinketju.Trigram;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testiluokka Markovin ketjulle.
 * @author iida
 */
public class TekstiGeneraattoriTesti {
    
    private TekstiGeneraattori testiGeneraattori;
    private Trie testiTrie;
    private Trigram trigram;
    
    
    @Before
    public void setUp() {
        this.testiGeneraattori = new TekstiGeneraattori();            
    }
    
    @Test
    public void materiaalinLukuToimii() {
        String teksti = "olipa kerran prinsessa. olipa kerran prinssi. kerran prinsessa lähti kaupunkiin.";
               
        testiGeneraattori.lueMateriaali(teksti);
        
        testiTrie = testiGeneraattori.getTrie();
        
        assertEquals(testiTrie.haeSanoja("olipa kerran"), true);
    }
    
    @Test
    public void trigraminLuontiToimii() {
        String teksti = "hai valas ui, hai valas lohi, valas ui ohi";
        testiGeneraattori.lueMateriaali(teksti);
        
        trigram = testiGeneraattori.getTrigam();
        
        assertNotNull(trigram);
            
    }
    
    @Test
    public void arvoSanaToimii() {
       String teksti = "olipa kerran prinsessa";
       testiGeneraattori.lueMateriaali(teksti);
       
       String sana = testiGeneraattori.arvoSana("olipa kerran");
       assertEquals("prinsessa", sana);
       
    }
    
    @Test
    public void tekstinGenerointiToimii() {
        String teksti = "olipa kerran prinsessa. olipa kerran prinssi. kerran prinsessa lähti kaupunkiin.";
        testiGeneraattori.lueMateriaali(teksti);
        
        String generoitu = testiGeneraattori.generoiTeksti(4);
        String[] sanat = generoitu.split(" ");
        assertEquals(4, sanat.length);
  
    }
    
    
}
