
package harjoitustyo.tietorakenne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import harjoitustyo.markovinketju.Ngrams;


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
    Map<Character, TrieSolmu> lapset = juuri.haeLapset();

    TrieSolmu nykyinen;

        for (int i = 0; i < sana.length(); i++) {
            char kirjain = sana.charAt(i);

            if (lapset.containsKey(kirjain)) {
                nykyinen = lapset.get(kirjain); //uusi nykyinen solmu on kirjaimen sisältänyt
            } else {
                nykyinen = new TrieSolmu(); //jos kirjainta ei löydy, luodaan uusi solmu
                lapset.put(kirjain, nykyinen);
            }
            lapset = nykyinen.haeLapset();

            if (i == sana.length() - 1) {
                nykyinen.asetaSana(true);
            }
        }
    }
    /**
     * 
     * haetaan sanaa trie-puusta. Jos sana löytyy, palautetaan true, muuten false.
     *  
     */   
    public boolean haku(String sana) {
        Map<Character, TrieSolmu> lapset = juuri.haeLapset();

        TrieSolmu nykyinen = null;  

        for (int i = 0; i < sana.length(); i++) {
            char kirjain = sana.charAt(i);

            if (lapset.containsKey(kirjain)) {
               nykyinen = lapset.get(kirjain);  
               lapset = nykyinen.haeLapset();

            } else {
                nykyinen = null;
                break;
            } 
        }   
        if (nykyinen != null && nykyinen.onSana()) {
            return true;
        } else {
            return false;
        }    
    }
    /**
     * Arpoo satunnaisen sanan trien sisältä.
     * @return palauttaa sanan.
     */
    public String satunnainenSana() {
        Random random = new Random();         
        Map<Character, TrieSolmu> lapset = juuri.haeLapset();
        String sana = "";    
         
        while (true) {
            //haetaan lapsisolmujen avaimet
            List<Character> keys = new ArrayList<Character>(lapset.keySet()); 
            //arvotaan yksi niistä
            char randomMerkki = keys.get(random.nextInt(keys.size()));
            //lisätään sanaan
            sana = sana + randomMerkki;
            //otetaan uusi solmu arvotusta avaimesta
            TrieSolmu solmu = lapset.get(randomMerkki); 
            //jos kokonainen sana, lopetetana arpominen
            if (solmu.onSana()) {
                break;
            }
            lapset = solmu.haeLapset();          
        }      
        return sana;
    }


}
    

    



