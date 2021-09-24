
package tietorakenne;

import harjoitustyo.markovinketju.MarkovAlgoritmi;
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
    
    
    @Before
    public void setUp() {
        this.testiGeneraattori = new MarkovAlgoritmi();            
    }
    
    @Test
    public void materiaalinLukuToimii() {
        String teksti = "Hullu työtä tekee, viisas elää vähemmälläkin. ";
               
        testiGeneraattori.lueMateriaali(teksti);
        
        Trie trie = testiGeneraattori.getTrie();
        
        assertEquals(trie.haku("Hullu työtä tekee, viisas elää vähemmälläkin. "), true);
    }
    
    
}
