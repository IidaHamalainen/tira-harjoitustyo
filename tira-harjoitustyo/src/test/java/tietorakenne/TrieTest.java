
package tietorakenne;

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
        String avain1 = "Olipa kerran";
        List<String> lista1 = new ArrayList<String>();
        lista1.add("prinsessa");
        lista1.add("prinssi");
        sanat.put(avain1, lista1);
        
        this.testiTrie.lisaa(sanat);
        
        assertEquals(this.testiTrie.haeSanoja("Olipa kerran"), true);
        assertEquals(this.testiTrie.haeSanoja("Olipa kerran prinssi"), true);
    }  
    
    @Test
    public void olematonSanaEiLoydy() {
        String avain1 = "Avain1 Avain2";
        List<String> lista1 = new ArrayList<String>();
        lista1.add("Yksi");
        lista1.add("Kaksi");
        sanat.put(avain1, lista1);
        
        this.testiTrie.lisaa(sanat);
        
        assertEquals(this.testiTrie.haeSanoja("Avain3"), false);  
        assertEquals(this.testiTrie.haeSanoja("Avain1 Avain2 Kolme"), false); 
    }  
    @Test
    public void arvoSanaToimii() {
        String avain1 = "Olipa kerran";
        List<String> lista1 = new ArrayList<String>();
        lista1.add("prinsessa");
        lista1.add("prinssi");
        sanat.put(avain1, lista1);
        
        String avain2 = "Avain1 Avain2";
        List<String> lista2 = new ArrayList<String>();
        lista1.add("Yksi");
        lista1.add("Kaksi");
        sanat.put(avain2, lista2);
        
        this.testiTrie.lisaa(sanat);
              
        String sana = testiTrie.arvoAlkusanat();
        String[] taulukko = sana.split(" ");
        assertEquals(taulukko.length, 2);
        
        
    }
    
          
}
