
package harjoitustyo.tietorakenne;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 *
 * @author iida
 */
public class TrieSolmu {
    
    private final Map<String, TrieSolmu> lapset = new HashMap<>();
    private boolean onSana;
    private int laskuri;

    public TrieSolmu() {
        this.laskuri = 1;
    }
    
    /**
     * Hakee solmun lapsisolmut.
     * @return palauttaa hashMapin lapsista.
     */
    Map<String, TrieSolmu> haeLapset() {
        return lapset;
    }
    /**
     * laskuri kuinka monta kerta sana esiintyy tekstissä.
     */
    public void lisaaEsiintymiskerta() {
        this.laskuri  = laskuri + 1;
    }
    
    /**
     * palauttaa askurin esiintymiskerroista.
     * @return luku
     */
    public int haeLaskuri() {
        return this.laskuri;
    }
      
    
   
}
