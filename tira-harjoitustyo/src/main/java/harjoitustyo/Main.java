
package harjoitustyo;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;

/**
 * 
 * @author iida
 */
public class Main {

    
    public static void main(String[] args) {
        
        Trie trie = new Trie();    
        
        trie.lisaaSana("Kissa");
        System.out.println("sana lisätty");
        trie.lisaaSana("koira");
        System.out.println("sana lisätty");
        
        if (trie.haku("kissa") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        if (trie.haku("Kissa") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        
        
        
       
        
    }
    
}
