
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
    
    public HashMap<String, Integer> chargrams(String teksti) {
        HashMap<String, Integer> cGrams = new HashMap<String, Integer>();   
        for (int i = 0; i < teksti.length() - 1 ; i++) {
                   
            char m1 = teksti.charAt(i); 
            char m2 = teksti.charAt(i + 1);
            
            String kirjaimet = String.valueOf(m1) + String.valueOf(m2);
            
            if (cGrams.containsKey(kirjaimet)) {
                int lukumaara = cGrams.get(kirjaimet);
                cGrams.put(kirjaimet, lukumaara + 1);      
            } else {
                cGrams.put(kirjaimet, 1);
            }
            
        }
        return cGrams;
    }
    
}
