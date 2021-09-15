
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;

/**
 *
 * @author iida
 */
public class MarkovAlgoritmi {
    
    private Trie trie;
    private String sana = "";
    
    /**
     * lisätään opetusmateriaali Triehen.
     */
    public void lueMateriaali(String opetusmateriaali) {
        
        trie = new Trie();
        
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
        return "TO DO";
    }
}
