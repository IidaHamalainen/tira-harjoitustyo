
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
     * lisätään trie-rakenteeseen tekstin.
     * isot kirjaimet ja välimerkit merkitsee!
     * Solmuihin tallennetaan esiintymiskerrat arvontaa varten (kesken)
     * @param teksti joka lisätään Trieen.
     */ 
    public void lisaa(String teksti) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        TrieSolmu nykyinen = juuri;
        
        //teksti jaetaan yksittäisiksi sanoiksi
        String[] sanat = teksti.split(" ");
    
        //Otetaan aina kolme peräkkäistä sanaa Markovin toisen asteen mukaisesti
        for (int i = 0; i < sanat.length - 2; i++) {
            String sana1 = sanat[i];
            String sana2 = sanat[i + 1];
            String sana3 = sanat[i + 2];
            
            // Ensimmäinen sana juuren lapseksi. Jos sana löytyy jo, kasvatetaan esiintymiskertoja, muuten luodaan uusi solmu.
            if (lapset.containsKey(sana1)) {
                nykyinen = lapset.get(sana1);
                nykyinen.lisaaEsiintymiskerta();
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana1, nykyinen);
            }
            lapset = nykyinen.haeLapset();
            
            // Toinen sana ensimmäisen lapseksi. Jos sana löytyy jo, kasvatetaan esiintymiskertoja, muuten luodaan uusi solmu.
            if (lapset.containsKey(sana2)) {
                nykyinen = lapset.get(sana2);
                nykyinen.lisaaEsiintymiskerta();
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana2, nykyinen);
            }
            lapset = nykyinen.haeLapset();
            
            // Kolmikon viimeinen sana. Jos sana löytyy jo, kasvatetaan esiintymiskertoja, muuten luodaan uusi solmu.
            if (lapset.containsKey(sana3)) {
                nykyinen = lapset.get(sana3);
                nykyinen.lisaaEsiintymiskerta();
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(sana3, nykyinen);
            }          
            //Palataan juureen seuraavan kolmikon tallentamiseksi
            lapset = juuri.haeLapset();
            
        }       
        
    }
    
    /**
     * haetaan triestä sanoja.
     * @param sanat teksti jota haetaan.
     * @return true, jos sanat löytyy, muuten false.
     */
    public boolean haeSanoja(String sanat) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();

        TrieSolmu nykyinen = null;  
        //jaetaan haettava tekstiyksittäisiksi sanoiksi
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
    

    



