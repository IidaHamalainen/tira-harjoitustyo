
package harjoitustyo.tietorakenne;

import java.util.HashMap;

/**
 *
 * @author iida
 */
public class TrieSolmu {
    
    private HashMap<Character, TrieSolmu> lapset = new HashMap<>();
    private char solmunSisalto;
    private boolean onSana;
    
    public TrieSolmu(char merkki) {       
        this.solmunSisalto = merkki;
        this.onSana = false;
    }
    
    public TrieSolmu(char merkki, boolean onSana) {     
        this.solmunSisalto = merkki;
        this.onSana = onSana;
    }
    
    /**
     * 
     * palauttaa solmun lapset.
     */
    public HashMap<Character, TrieSolmu> haeLapset() {
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
     * asettaa solmulle lapset.
     */
    public void asetaLapset(HashMap<Character, TrieSolmu> lapset) {
        this.lapset = lapset;
    }
    
    /**
     * 
     * asettaa tiedon onko sana joka päättyy tähän kirjaimeen/solmuun.
     */
    public void asetaSana(boolean onSana) {
        this.onSana = onSana;
    }
}
