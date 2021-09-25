
package harjoitustyo.tietorakenne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import harjoitustyo.markovinketju.Ngrams;
import java.text.BreakIterator;
import java.util.Locale;


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
     * Poistetaan tekstistä turhat välilyönnit ja pilkut & pisteet.
     * @param teksti
     * @return muokattu teksti.
     */
    public String kasitteleTeksti(String teksti) {
        teksti = teksti.strip();
        teksti = teksti.replace(",", "");
        teksti = teksti.replace(".", "");
        return teksti;
    }
    /**
     * Jakaa syötteenä annetin tekstin lauseiksi.
     * @param teksti syöte.
     * @return lista lauseista.
     */
    public ArrayList<String> jaaTekstiLauseiksi(String teksti) {
        ArrayList<String> lauseet = new ArrayList<String>();
                
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(teksti);
        int loppu = iterator.first();
        
        while (loppu != BreakIterator.DONE) {
            int alku = loppu;
            loppu = iterator.next();
            
            if (loppu != BreakIterator.DONE) {
                String lause = teksti.substring(alku, loppu);
                lauseet.add(lause);
            }   
        }
        return lauseet;
    }
    /**
     * lisää trieen annetun tekstin.
     * @param teksti 
     */
    public void lisaaTeksti(String teksti) {
        ArrayList<String> lauseet = new ArrayList<String>();
        lauseet = jaaTekstiLauseiksi(teksti);
        
        for (int i = 0; i < lauseet.size(); i++) {
            String lisattava = lauseet.get(i);   
            
            lisaaLause(lisattava);
        }
    }
    
    /**
    * 
    * lisaa lauseen trie-puuhun.
    */
    public void lisaaLause(String teksti) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        TrieSolmu nykyinen;
        teksti = kasitteleTeksti(teksti);
  
        String[] sanat = teksti.split(" ");
                    
        for (int j = 0; j < sanat.length; j++) {
            String sana = sanat[j];
                //System.out.println(sana);
                
            if (lapset.containsKey(sana)) {
                nykyinen = lapset.get(sana);
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana, nykyinen);
            }
            lapset = nykyinen.haeLapset();
           
        }
            
    }
      
    /**
     * 
     * haetaan lausetta trie-puusta. Jos lause tai sen alkuosa löytyy, palautetaan true, muuten false.
     *  
     */   
    public boolean haku(String teksti) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();

        TrieSolmu nykyinen = null;  

        teksti = kasitteleTeksti(teksti);
        
        String[] sanat = teksti.split(" ");
        for (int i = 0; i < sanat.length; i++) {
            String sana = sanat[i];
            
            if (lapset.containsKey(sana)) {
                nykyinen = lapset.get(sana);
                lapset = nykyinen.haeLapset();
            } else {
                nykyinen = null;
                break;
            }                 
        } 
        
        if (nykyinen != null) {
            return true;
        } else {
            return false;
        }    
    }
    
    /**
     * Arpoo satunnaisen sanan trien sisältä.
     * @return palauttaa sanan.
     *
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
    */


}
    

    



