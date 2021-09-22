
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Ngrams;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author iida
 */
public class MarkovAlgoritmi {
    
    private Trie trie;
    private String sana = "";  
    private Ngrams bigram;
    
    public MarkovAlgoritmi() {
        
        this.trie = new Trie();
        this.bigram = new Ngrams();
        
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
     * luodaan opetusmateriaalista bigram
     * @param opetusmateriaali 
     */
    public HashMap<Character, List<Character>> luetteloBigram (String opetusmateriaali) {
        HashMap<Character, List<Character>> lista = bigram.luetteloBigram(opetusmateriaali);
        return lista;
        
    }
    public HashMap<String, List<Character>> luetteloTrigram(String opetusmateriaali) {
        HashMap<String, List<Character>> lista = bigram.luetteloTrigram(opetusmateriaali);
        return lista;
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
