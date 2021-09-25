
package harjoitustyo.markovinketju;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author iida
 * Tässä luokassa luodaan Markovin ketjuun tarvitava n-gram rakenne. Toisen asteen Markovin ketjuun tarvitaan trigram.
 */
public class Ngrams {
    
    private HashMap<String, List<String>> luettelo;
    
    public Ngrams() {
        
        luettelo = new HashMap<String, List<String>>();
    }
    /**
     * kerätään kaksi peräkkäistä sanaa, ja annetan lista sanoista jotka voivat seurata niitä opetusmateriaalissa.
     * @param teksti opetusmateriaali.
     * @param teksti 
     */
    public void luoTrigam(String teksti) {
        teksti = teksti.strip();
        teksti = teksti.replace(",", "");
        teksti = teksti.replace(".", "");
        String[] sanat = teksti.split(" ");        
        
        for (int i = 0; i < sanat.length - 2; i++) {
            
            String sanapari = sanat[i] + " " + sanat[i + 1];  
            String seuraava = sanat[i + 2];
            
            if (luettelo.containsKey(sanapari)) {
                luettelo.get(sanapari).add(seuraava);
            } else {
                List<String> uusiLista = new ArrayList<String>();
                luettelo.put(sanapari, uusiLista);
                luettelo.get(sanapari).add(seuraava);
            }
        }    
    }
    /**
     * palauttaa trigarmin luoman luettelon.
     * @return luettelo.
     */
    public HashMap<String, List<String>> haeTrigramLuettelo() {
        return luettelo;
    }
      
    
    /**
     * Kerätään sanaparit listaan ja lasketaan niiden esiintyminen.
     *
     * @param teksti läpikäytävä teksti.
     * @return palauttaa listan n-grameista.
     *
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
    */   
}