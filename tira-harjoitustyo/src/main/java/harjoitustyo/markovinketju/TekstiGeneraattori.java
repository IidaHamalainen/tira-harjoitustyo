
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Trigram;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author iida
 */
public class TekstiGeneraattori {
    
    private Trie trie; 
    private Trigram trigram;
    private HashMap<String, List<String>> sanat;
    
    public TekstiGeneraattori() {
        
        this.trie = new Trie();
        this.trigram = new Trigram();
        
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
    
    /**
     * generoi halutun mittaisen tekstin.
     * Ensimmäinen sanapari arvotaan Triestä, ja sen jälkeen aina kahden edellisen sanan perusteella arvotaan seuraava.
     * @param sanamaara
     * @return muodostettu teksti.
     */
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

    /**
     * Arvotaan sana kahden edellisen sanan perusteella mahdollisista seuraajista.
     * @param edelliset edelliset sanat.
     * @return arvottu sana.
     */
    public String arvoSana(String edelliset) {
        
        Random random = new Random();
        TrieSolmu juuri = trie.haeJuuri();
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        String arvottuSana = "";
        
        String sanat[] = edelliset.split(" "); 

        TrieSolmu ensimmainen = lapset.get(sanat[0]);    
            
        if (ensimmainen == null) {  //jos arvotulle sanalle ei löydy seuraajia, arvotaan uudet sanat
            String uudetSanat = trie.arvoAlkusanat();
            arvoSana(uudetSanat);
                  
        } else {   
            lapset = ensimmainen.haeLapset();
        }
        
        TrieSolmu toinen = lapset.get(sanat[1]);
         
        if (toinen == null) {
            String uudetSanat = trie.arvoAlkusanat();
            arvoSana(uudetSanat);
            
        } else {
            lapset = toinen.haeLapset();
        }
            
        List<String> avaimet = new ArrayList<String>(lapset.keySet());

        if (avaimet.size() == 1) {
            arvottuSana = avaimet.get(0);
              
        } else {
            arvottuSana = avaimet.get(random.nextInt(avaimet.size()));              
            
        }
        return arvottuSana;
    }
   
    public Trie getTrie() {
        return this.trie;
    }
    /**
     * hakee trigramin.
     */
    public Trigram getTrigam() {
        return this.trigram;
    }
    
    
    
    
}
