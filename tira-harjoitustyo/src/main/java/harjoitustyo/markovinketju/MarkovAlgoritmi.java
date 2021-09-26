
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Ngrams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 *
 * @author iida
 */
public class MarkovAlgoritmi {
    
    private Trie trie; 
    private Ngrams trigram;
    private HashMap<String, List<String>> sanat;
    
    public MarkovAlgoritmi() {
        
        this.trie = new Trie();
        this.trigram = new Ngrams();
        
    }
    
    /**
     * lisätään opetusmateriaali Trigramiin ja luodaan Trie.
     */
    public void lueMateriaali(String opetusmateriaali) {
                             
            trigram.luoTrigam(opetusmateriaali);
            this.sanat = getTrigramLuettelo();
            trie.lisaa(sanat);
    } 
    
    /**
     *hakee trigamin muodostaman HashMap-rakenteen.
     */
    public HashMap<String, List<String>> getTrigramLuettelo() {
        return this.trigram.haeTrigramLuettelo();
    }
    
    public String generoiTeksti(int sanamaara) {
        
        String lause = "";
        int tekstinPituus = 0;
        
        if (sanamaara < 0) {
            return null;
        }
        if (sanamaara < 2) {
            System.out.println("Anna suurempi sanamäärä");
            return null;
        }
        String alkusanat = trie.arvoAlkusanat();
        lause = lause + alkusanat + " ";
        tekstinPituus = 2;
        
        while (tekstinPituus < sanamaara) {
            
            String sanat[] = lause.split(" ");
            String edelliset = sanat[sanat.length - 2] + " " + sanat[sanat.length - 1];
            String sana = arvoSana(edelliset);
            lause = lause + sana + " ";
            tekstinPituus++;
        }
        return lause;     
    }  

    public String arvoSana(String edelliset) {
        
        Random random = new Random();
        TrieSolmu juuri = trie.haeJuuri();
        Map<String, TrieSolmu> lapset = trie.haeSeuraajat(juuri);
        String arvottuSana = "";
        
            String sanat[] = edelliset.split(" "); 

            TrieSolmu ensimmainen = lapset.get(sanat[0]);
            lapset = trie.haeSeuraajat(ensimmainen);
            TrieSolmu toinen = lapset.get(sanat[1]);
            lapset = trie.haeSeuraajat(toinen);

            List<String> avaimet = new ArrayList<String>(lapset.keySet());

            if (avaimet.size() == 1) {
                arvottuSana = avaimet.get(0);
            } else {
                arvottuSana = avaimet.get(random.nextInt(avaimet.size()));
            
            }
            return arvottuSana;
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
    
    
    
    
}
