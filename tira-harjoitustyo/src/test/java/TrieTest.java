


import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private HashMap<String, List<String>> sanat;
    
    @Before
    public void setUp() {
        this.juuri = new TrieSolmu();
        this.testiTrie = new Trie();
        
        sanat = new HashMap<String, List<String>>();
         
    } 
    
    @Test
    public void lisaaToimii() {
        String teksti = "Olipa kerran prinssi. Prinssi asui linnassa";
        
        this.testiTrie.lisaa(teksti);
        
        assertEquals(this.testiTrie.haeSanoja("Olipa kerran"), true);
        assertEquals(this.testiTrie.haeSanoja("Prinssi asui linnassa"), true);
    }  
    
    @Test
    public void olematonSanaEiLoydy() {
        String teksti = "Olipa kerran prinssi. Prinssi asui linnassa";
        
        this.testiTrie.lisaa(teksti);
        
        assertEquals(this.testiTrie.haeSanoja("Prinsessa"), false);  
        assertEquals(this.testiTrie.haeSanoja("Olipa kerran peikko"), false); 
    }  
    
    
          
}
