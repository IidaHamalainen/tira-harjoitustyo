
package harjoitustyo.tietorakenne;

import java.util.Map;


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
     * @return solmu joka on juurisolmu
     */
    public TrieSolmu haeJuuri() {
        return this.juuri;
    }
    
    /**
     * lisätään trie-rakenteeseen tekstin Markovin toisen asteen mukaisesti.
     * Tutkitaan aina kolmea peräkkäistä sana kerrallaan.
     * Solmuihin tallennetaan esiintymiskerrat arvontaa varten.
     * @param teksti joka lisätään Trieen.
     */ 
    public void lisaa(String teksti) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        TrieSolmu nykyinen = juuri;
        
        String[] sanat = teksti.split(" ");
    
        //Otetaan aina kolme peräkkäistä sanaa Markovin toisen asteen mukaisesti
        for (int i = 0; i < sanat.length - 2; i++) {
            String sana1 = sanat[i];
            String sana2 = sanat[i + 1];
            String sana3 = sanat[i + 2];
                       
            nykyinen = haeTaiLisaaSolmu(lapset, sana1);            
            lapset = nykyinen.haeLapset();
            
            nykyinen = haeTaiLisaaSolmu(lapset, sana2);           
            lapset = nykyinen.haeLapset();
            
            nykyinen = haeTaiLisaaSolmu(lapset, sana3);                     
            //Palataan juureen seuraavan kolmikon tallentamiseksi
            lapset = juuri.haeLapset();           
        }              
    }
    
    /**
     * Tutkitaan, löytyykö sanan sisältävä solmu lapsista. Jos löytyy, siirrytään solmuun. Jos ei löydy, luodaan uusi solmu.
     * @param lapset nykyisen solmun lapset.
     * @param sana lisättävä sana.
     * @return solmu johon siirryttiin tai joka luotiin.
     */
    public TrieSolmu haeTaiLisaaSolmu(Map<String, TrieSolmu> lapset, String sana) {
        TrieSolmu nykyinen;
        
        if (lapset.containsKey(sana)) {
            nykyinen = lapset.get(sana);
            nykyinen.lisaaEsiintymiskerta();
        } else {
            nykyinen = new TrieSolmu();
            lapset.put(sana, nykyinen);
        }          
        return nykyinen;   
    }
    
    /**
     * haetaan triestä sanoja.
     * @param sanat teksti jota haetaan.
     * @return true, jos sanat löytyy, muuten false.
     */
    public boolean haeSanoja(String sanat) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();

        TrieSolmu nykyinen = null;  
        String[] yksittaisetSanat = sanat.split(" ");
        //tarkastetaan löytyykö haettava sana solmun lapsista
        for (int i = 0; i < yksittaisetSanat.length; i++) {
            String sana = yksittaisetSanat[i];
            //jos sana löytyy, siirrytään siihen solmuun
            if (lapset.containsKey(sana)) {
                nykyinen = lapset.get(sana);
                lapset = nykyinen.haeLapset();
            //jos ei löydy, palautetaan null
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
    

    



