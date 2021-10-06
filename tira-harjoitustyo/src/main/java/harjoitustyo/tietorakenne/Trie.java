
package harjoitustyo.tietorakenne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
     * palauttaa juurisolmun.
     * @return solmu
     */
    public TrieSolmu haeJuuri() {
        return this.juuri;
    }
    
    /**
     * lisätään trie-rakenteeseen tekstin.
     * isot kirjaimet ja välimerkit merkitsee!
     * @param teksti
     */ 
    public void lisaa(String teksti) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        TrieSolmu nykyinen = juuri;
        
        String[] sanat = teksti.split(" ");
    
        for (int i = 0; i < sanat.length - 2; i++) {
            String sana1 = sanat[i];
            String sana2 = sanat[i + 1];
            String sana3 = sanat[i + 2];
            
            // kolmikon eka sana juuren lapseksi
            if (lapset.containsKey(sana1)) {
                nykyinen = lapset.get(sana1);
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana1, nykyinen);
            }
            lapset = nykyinen.haeLapset();
            
            // kolmikon toinen sana 1. lapseksi
            if (lapset.containsKey(sana2)) {
                nykyinen = lapset.get(sana2);
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana2, nykyinen);
            }
            lapset = nykyinen.haeLapset();
            
            // kolmikon viimeinen sana 
            if (lapset.containsKey(sana3)) {
                nykyinen = lapset.get(sana3);
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana3, nykyinen);
            }          
            //palataan juureen seuraavan kolmikon tallentamiseksi
            lapset = juuri.haeLapset();
            
        }       
        
    }
    
    /**
     * haetaan triestä sanoja.
     * @param sanat
     * @return 
     */
    public boolean haeSanoja(String sanat) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();

        TrieSolmu nykyinen = null;  

        String[] yksittaisetSanat = sanat.split(" ");
        for (int i = 0; i < yksittaisetSanat.length; i++) {
            String sana = yksittaisetSanat[i];
            
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

    
    
    
    
}
    

    



