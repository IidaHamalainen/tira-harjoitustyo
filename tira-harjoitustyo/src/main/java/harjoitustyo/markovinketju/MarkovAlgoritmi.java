
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
                           
            trie.lisaaSanoja(opetusmateriaali);      
    }
    
    /**
     * luodaan opetusmateriaalista trigram.
     * @param opetusmateriaali 
     *
    */ 
    public HashMap<String, List<String>> luetteloTrigram(String opetusmateriaali) {
        HashMap<String, List<String>> lista = bigram.sanaTrigram(opetusmateriaali);
        return lista;
    }
            
    
    
    /*
    public String luoTeksti(int sanamaara) {
        
        if (sanamaara < 0) {
            return null;
        }      
        StringBuilder teksti = new StringBuilder();
        teksti.append("");
        
        for (int i = 0; i < sanamaara; i++) {
            String uusiSana = trie.satunnainenSana();  //TO DO        
            teksti.append(uusiSana + " ");               
        }       
        return teksti.toString();
    }
    */
    public Trie getTrie() {
        return this.trie;
    }
    
    
}
