
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Ngrams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


/**
 *
 * @author iida
 */
public class MarkovAlgoritmi {
    
    private Trie trie; 
    private Ngrams trigram;
    
    public MarkovAlgoritmi() {
        
        this.trie = new Trie();
        this.trigram = new Ngrams();
        
    }
    
    /**
     * lisätään opetusmateriaali Triehen ja luodaan trigram.
     */
    public void lueMateriaali(String opetusmateriaali) {
                           
            trie.lisaaTeksti(opetusmateriaali);   
            trigram.luoTrigam(opetusmateriaali);
    } 
            
    public String luoTeksti(int sanamaara) {
        Random random = new Random();
        HashMap<String, List<String>> lista = getTrigramLuettelo();
        String lause = "";
        int tekstinPituus = sanamaara;
        
        if (sanamaara < 0) {
            return null;
        }
        String sanapari = trie.arvoAlkusanat();
        lause = lause + sanapari;

        while (true) {
            List<String> seuraajat = lista.get(sanapari);
            String randomSana = seuraajat.get(random.nextInt(seuraajat.size()));
            lause = lause + " " + randomSana;
            String[] sanat = lause.split(" ");
            
            if (sanat.length == tekstinPituus) {
                break;
            } else {
               sanapari = sanat[sanat.length - 2] + " " + sanat[sanat.length - 1]; 
            }
               
        }
        return lause;
        
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
    /**
     * hakee trien.
     */
    public Trie getTrie() {
        return this.trie;
    }
    /**
     * hakee trigramin.
     */
    public Ngrams getTrigam() {
        return this.trigram;
    }
    
    /**
     *hakee trigamin muodostaman HashMap-rakenteen.
     */
    public HashMap<String, List<String>> getTrigramLuettelo() {
        return this.trigram.haeTrigramLuettelo();
    }
    
    
}
