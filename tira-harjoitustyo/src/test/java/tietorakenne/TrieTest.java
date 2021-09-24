
package tietorakenne;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author iida
 */
public class TrieTest {
    
    private Trie testiTrie;
    private TrieSolmu juuri;
    
    @Before
    public void setUp() {
        this.juuri = new TrieSolmu();
        this.testiTrie = new Trie();
    } 
    
    @Test
    public void lisaaSanojaToimii() {
        this.testiTrie.lisaaSanoja("kaneli kuuluu pulliin");
        assertEquals(this.testiTrie.haku("kaneli kuuluu pulliin"), true);
    }  
    
    @Test
    public void olematonSanaEiLoydy() {
        this.testiTrie.lisaaSanoja("hillo on marmeladia");
        assertEquals(this.testiTrie.haku("marmeladi on hilloa"), false);     
    }    
    
    @Test
    public void tekstinMuokkausToimii() {
        this.testiTrie.lisaaSanoja(" paprika on pahaa.");
        assertEquals(this.testiTrie.haku("paprika on pahaa"), true);
    }
    
    @Test
    public void hakuOsallaLauseellaToimii() {
        this.testiTrie.lisaaSanoja("korianteri jakaa mielipiteitä");
        assertEquals(this.testiTrie.haku("korianteri"), true);
    }
    
    
    
}
