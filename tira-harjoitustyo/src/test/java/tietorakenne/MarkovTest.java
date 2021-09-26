
package tietorakenne;

import harjoitustyo.markovinketju.MarkovAlgoritmi;
import harjoitustyo.markovinketju.Ngrams;
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
public class MarkovTest {
    
    private MarkovAlgoritmi testiGeneraattori;
    private Trie testiTrie;
    private Ngrams trigram;
    
    
    @Before
    public void setUp() {
        this.testiGeneraattori = new MarkovAlgoritmi();            
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
    
    
}
