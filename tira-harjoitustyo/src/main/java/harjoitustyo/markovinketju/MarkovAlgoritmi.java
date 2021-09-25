
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
    private Ngrams trigram;
    
    public MarkovAlgoritmi() {
        
        this.trie = new Trie();
        this.trigram = new Ngrams();
        
    }
    
    /**
     * lisätään opetusmateriaali Triehen.
     */
    public void lueMateriaali(String opetusmateriaali) {
                           
            trie.lisaaTeksti(opetusmateriaali);      
    }
    
    /**
     * luodaan opetusmateriaalista trigram.
     * @param opetusmateriaali 
    */ 
    public void luoTrigram(String opetusmateriaali) {
        trigram.luoTrigam(opetusmateriaali);
    }
            
    
    
    /*
    // ensin pitää arpoa sanapari josta aloittaa
    String lause = "";
    HashMap<String, List<String>> lista = sanaTrigram(opetusmateriaali)   //halutaan hashmap-luettelo
    
    *toistuva osa
    ArrayList<String> seuraajat = lista.get(sanapari);  //sanaparin seuraajat
    String random = seuraajat.get(random.nextInt(seuraajat.size())); joista arvotaan sana
    lause = lause + random + " ";
    String[] sanat = lause.split(" ");
    sanapari = sanat[sanat.length - 2] + " " + sanat[sanat.length - 1];
    *
    jne
    
    
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
