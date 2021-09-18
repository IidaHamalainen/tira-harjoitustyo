
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
        String teksti = "Hullu työtä tekee, viisas elää vähemmälläkin. "
                + "Mutta työ se sentään on hauskinta elämässä – ei siitä mihinkään pääse";
        testiGeneraattori.lueMateriaali(teksti);
        
        Trie trie = testiGeneraattori.getTrie();
        
        assertEquals(trie.haku("työ"), true);
    }
    @Test
    public void tekstinGenerointiToimii() {
        String materiaali = "Emme voi ratkaista ongelmia ajattelemalla samalla tavalla kuin silloin, kun loimme ne";
        testiGeneraattori.lueMateriaali(materiaali);
        String teksti = testiGeneraattori.luoTeksti(4);
        
        assertNotNull(teksti);
    
    }
    
}
