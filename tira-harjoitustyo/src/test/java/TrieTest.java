

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
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
    @Test
    public void solmunLaskuriToimii() {
        TrieSolmu solmu = new TrieSolmu();
        assertEquals(1, solmu.haeLaskuri());
        
        solmu.lisaaEsiintymiskerta();
        assertEquals(2, solmu.haeLaskuri());
    }
          
}
