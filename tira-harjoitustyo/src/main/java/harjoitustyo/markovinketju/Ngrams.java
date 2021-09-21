
package harjoitustyo.markovinketju;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ngrams {
    
    public Ngrams() {
        
    }
    
    /**
     * Kerätään halutun mittaiset sanaparit listaan ja lasketaan niiden esiintyminen.
     *
     * @param sana läpikäytävä teksti.
     * @return palauttaa listan n-grameista.
     */
    public HashMap<String, Integer> ngrams(String teksti) {
        
        //tallennetaan sanapari ja esiintymiskerrat
        HashMap<String, Integer> nGrams = new HashMap<String, Integer>();     
        String[] sanat = teksti.split(" ");        
        for (int i = 0; i < sanat.length - 1; i++) {
            
            String sanapari = sanat[i] + sanat[i + 1];            
            
            if (nGrams.containsKey(sanapari)) {
                int lukumaara = nGrams.get(sanapari);
                nGrams.put(sanapari, lukumaara + 1);
            } else {
                nGrams.put(sanapari, 1);
            }                                 
        }
        return nGrams;
    }
    
}
