
package harjoitustyo.tietorakenne;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author iida
 */
public class TrieSolmu {
    
    private final Map<String, TrieSolmu> lapset = new HashMap<>();
    private int laskuri;
   

    public TrieSolmu() {
        this.laskuri = 1;
        
    }
    /**
     * Hakee solmun lapsisolmut.
     * @return palauttaa hashMapin lapsista.
     */
    public Map<String, TrieSolmu> haeLapset() {
        return lapset;
    }
    /**
     * Laskuri kuinka monta kerta sana esiintyy tekstissä samojen sanojen jälkeen. 
     * Aina kun sana esiintyy kasvatetaan arvoa.
     */
    public void lisaaEsiintymiskerta() {
        this.laskuri  = laskuri + 1;
    }
    
    /**
     * Palauttaa askurin esiintymiskerroista.
     * @return luku
     */
    public int haeLaskuri() {
        return this.laskuri;
    }
      
    
   
}
