
package harjoitustyo.tietorakenne;


/**
 *
 * @author iida
 */
public class TrieSolmu {
    
    
    TrieSolmu lista [];
    private boolean onSana;
    private char solmunKirjain;
 
    /**
     * 
     * alustaa trien a-z kirjaimia ajatellen.
     */
    public TrieSolmu() {       
        lista = new TrieSolmu[26];      
        this.onSana = false;      
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
