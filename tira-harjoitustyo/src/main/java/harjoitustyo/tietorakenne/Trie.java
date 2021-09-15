
package harjoitustyo.tietorakenne;


/**
 *
 * @author iida
 */
public class Trie {
    
    private TrieSolmu juuri;
    
    
    public Trie() {
        juuri = new TrieSolmu();
    }   
    
    /**
     * 
     * lisaa sanan trie-puuhun.
     */
    public void lisaaSana(String sana) {
        
        TrieSolmu nykyinen = juuri;  
        
        for (int i = 0; i < sana.length(); i++) {
            char kirjain = sana.charAt(i);
            
            //jos kirjainta ei löydy, luodaan uusi solmu
            if (nykyinen.lista[kirjain - 'a'] == null) {
                nykyinen.lista[kirjain - 'a'] = new TrieSolmu(); 
                nykyinen = nykyinen.lista[kirjain - 'a'];
            
            //uusi nykyinen solmu on kirjaimen sisältänyt solmu
            } else {
                nykyinen = nykyinen.lista[kirjain - 'a'];
                
            }        
            nykyinen.asetaSana(true);
            
        }
        
           
    }
    /**
     * 
     * haetaan sanaa trie-puusta. Jos sana löytyy, palautetaan true, muuten false.
     *  
     */
    public boolean haku(String sana) {     
        
        TrieSolmu nykyinen = juuri;  
        
        for (int i = 0; i < sana.length(); i++) {
            char kirjain = sana.charAt(i);
            
            if (nykyinen.lista[kirjain - 'a'] == null) {
               return false;
                     
            } else {
               nykyinen = nykyinen.lista[kirjain - 'a'];
            } 
            
        }   
        return nykyinen.onSana();
    }
}
    



