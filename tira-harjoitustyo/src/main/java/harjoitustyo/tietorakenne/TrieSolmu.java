
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

    
    /**
     * Hakee solmun lapsisolmut.
     * @return palauttaa hashMapin lapsista.
     */
    Map<String, TrieSolmu> haeLapset() {
        return lapset;
    }
    
    /**
     * 
     * palauttaa tiedon onko solmuun paattyvä sana olemassa.
     */
    public boolean onSana() {
        return onSana;
    }
    /**
     * 
     * asettaa tiedon onko sana joka päättyy tähän kirjaimeen/solmuun.
     */    
    public void asetaSana(boolean onSana) {
        this.onSana = onSana;
    }
    
    
    
   
}
