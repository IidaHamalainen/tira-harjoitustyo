
package harjoitustyo.markovinketju;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class Ngrams {
    
    public Ngrams() {
        
    }
    
    /**
     * Kerätään sanaparit listaan ja lasketaan niiden esiintyminen.
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
    /**
     * Kerää merkkijonot listaan ja laskee niiden esiintymiskerrat.
     * @param teksti lähdeaineisto.
     * @return palauttaa listan n-grameista.
     */
    public HashMap<String, Integer> trigrams(String teksti) {
        
        HashMap<String, Integer> cGrams = new HashMap<String, Integer>();   
        for (int i = 0; i < teksti.length() - 2 ; i++) {
                   
            char m1 = teksti.charAt(i); 
            char m2 = teksti.charAt(i + 1);
            char m3 = teksti.charAt(i + 2);
            
            String kirjaimet = String.valueOf(m1) + String.valueOf(m2) + String.valueOf(m3);
            
            if (cGrams.containsKey(kirjaimet)) {
                int lukumaara = cGrams.get(kirjaimet);
                cGrams.put(kirjaimet, lukumaara + 1);      
            } else {
                cGrams.put(kirjaimet, 1);
            }            
        }
        return cGrams;
    }
    
    /**
     * Koostaa listan jokaista merkkiä seuraavista merkeistä.
     * @param teksti lähdeteksti.
     * @return hashmap jossa avaimena merkki ja arvona lista seuraavista merkeistä.
     */
    public HashMap<Character, List<Character>> luetteloBigram(String teksti) {
        HashMap<Character, List<Character>> luettelo = new HashMap<Character, List<Character>>();
        
        for (int i = 0; i < teksti.length() - 1 ; i++) {
                   
            char m1 = teksti.charAt(i); 
            char m2 = teksti.charAt(i + 1);           
            
            if (luettelo.containsKey(m1)) {
                luettelo.get(m1).add(m2);
            } else {
                List<Character> uusiLista = new ArrayList<Character>();
                luettelo.put(m1, uusiLista);
                luettelo.get(m1).add(m2);
            }
        }
        return luettelo;                  
    }
    
    /**
     * Koostaa listan jokaista kahden kirjaimen yhdistelmää seuraavista merkeistä.
     * @param teksti lähdeteksti.
     * @return hashmap jossa avaimena string ja arvona lista seuraavista merkeistä.
     */
    public HashMap<String, List<Character>> luetteloTrigram(String teksti) {
        HashMap<String, List<Character>> luettelo = new HashMap<String, List<Character>>();
        
        for (int i = 0; i < teksti.length() - 2 ; i++) {
                   
            char m1 = teksti.charAt(i); 
            char m2 = teksti.charAt(i + 1);
            char m3 = teksti.charAt(i + 2);
            
            String s = String.valueOf(m1) + String.valueOf(m2);
            
            if (luettelo.containsKey(s)) {
                luettelo.get(s).add(m3);
            } else {
                List<Character> uusiLista = new ArrayList<Character>();
                luettelo.put(s, uusiLista);
                luettelo.get(s).add(m3);
            }
        }
        return luettelo;                  
    }
    
}

/*
ideaa:
1.arvotaan 2 ekaa merkkiä triestä, nämä ovat siis kaksi ensimmäistä tilaa. 

2.Näiden perusteella valitaan ngramin avulla mahdollisista merkeistä seuraava, 
eli Markovin ketjun mukainen seuraava tila.

3. Vaihetta 2 toistetaan kunnes sana on valmis




*/
