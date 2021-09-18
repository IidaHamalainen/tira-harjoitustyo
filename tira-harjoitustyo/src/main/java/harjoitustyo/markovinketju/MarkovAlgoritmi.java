
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;


/**
 *
 * @author iida
 */
public class MarkovAlgoritmi {
    
    private Trie trie;
    private String sana = "";  
    
    public MarkovAlgoritmi() {
        
        this.trie = new Trie();
        
    }
    
    /**
     * lisätään opetusmateriaali Triehen.
     */
    public void lueMateriaali(String opetusmateriaali) {
                    
        String sanat[] = opetusmateriaali.split(" ");
        
        for (int i = 0; i < sanat.length; i++) {
            sana = sanat[i];
            trie.lisaaSana(sana);
        }
    }             
    
    /**
     * generoidaan teksti.
     * @return luotu teksi.
     * @param sanamaara haluttu tekstin pituus sanoina.
     */
    public String luoTeksti(int sanamaara) {
        
        if (sanamaara < 0) {
            return null;
        }
        
        StringBuilder teksti = new StringBuilder();
        teksti.append("");
        
        for (int i = 0; i < sanamaara; i++) {
            String uusiSana = trie.satunnainenSana();
            
            teksti.append(uusiSana + " ");               
        }       
        return teksti.toString();
    }
    
    public Trie getTrie() {
        return this.trie;
    }
}
