
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
    
    private void lisaaSanaTriehen() {
        this.testiTrie.lisaaSana("chili");
        this.testiTrie.lisaaSana("kardemumma");
        
    }
    
    @Test
    public void lisaaSanaToimii() {
        this.testiTrie.lisaaSana("kaneli");
        assertEquals(this.testiTrie.haku("kaneli"), true);
    }
     
    
    @Test
    public void olematonSanaEiLoydy() {
        assertEquals(this.testiTrie.haku("anis"), false);
    }
    
    
    
}
