
package harjoitustyo.markovinketju;

import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author iida
 */
public class TekstiGeneraattori {
    
    private Trie trie; 
    
    public TekstiGeneraattori() {
        
        this.trie = new Trie();;       
    }
    
    /**
     * Luetaan opetusmateriaali, joka lisätään Trieen.
     * @param opetusmateriaali lisättävä teksti.
     */
    public void lueMateriaali(String opetusmateriaali) {
            //String teksti = kasitteleTeksti(opetusmateriaali);                 
            trie.lisaa(opetusmateriaali);
    }
    
    /**
     * Muokkaa tekstiä niin että siitä poistetaan pisteet ja pilkut. Toistaiseksi ei käytössä.
     * @param teksti muokattava teksti.
     * @return muokattu teksti.
     */
    public String kasitteleTeksti(String teksti) {
        teksti = teksti.strip();
        
        teksti = teksti.toLowerCase();
        teksti = teksti.replace(",", "");
        teksti = teksti.replace(".", "");

        return teksti;
    }   
    
    /**
     * Generoi halutun mittaisen tekstin.
     * Ensimmäinen sanapari arvotaan Triestä, ja sen jälkeen aina kahden edellisen sanan perusteella arvotaan seuraava.
     * @param sanamaara haluttu tekstin pituus sanoina.
     * @return muodostettu teksti.
     */
    public String generoiTeksti(int sanamaara) {
        
        String lause = "";
        String alkusanat = arvoAlkusanat();
        lause = lause + alkusanat + " ";
        int tekstinPituus = 2;
        
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
     * Arpoo kaksi sanaa Triestä alkaen juuren lapsista.
     */ 
    public String arvoAlkusanat() {
        
        Random random = new Random(); 
        TrieSolmu juuri = trie.haeJuuri();
        
        Map<String, TrieSolmu> lapset1 = juuri.haeLapset();        
        List<String> avaimet1 = new ArrayList<String>(lapset1.keySet()); 
      
        String arvottuSana1 = avaimet1.get(random.nextInt(avaimet1.size()));
        TrieSolmu solmu = lapset1.get(arvottuSana1); 
        
        Map<String, TrieSolmu> lapset2 = solmu.haeLapset(); 
        List<String> avaimet2 = new ArrayList<String>(lapset2.keySet());
       
        String arvottuSana2 = avaimet2.get(random.nextInt(avaimet2.size()));
        
        String sanapari = arvottuSana1 + " " + arvottuSana2;
        
        return sanapari;       
    } 
    
    /**
     * Arvotaan sana kahden edellisen sanan perusteella mahdollisista seuraajista. Mahdolliset seuraajat ovat toisen sanan lapset.
     * @param edelliset edelliset sanat.
     * @return arvottu sana.
     */
    public String arvoSana(String edelliset) {
        
        TrieSolmu juuri = trie.haeJuuri();
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        String arvottuSana;
        
        String sanat[] = edelliset.split(" "); 

        TrieSolmu ensimmainen = lapset.get(sanat[0]);         
          
        if (ensimmainen == null) {  
            String uudetSanat = arvoAlkusanat();
            arvoSana(uudetSanat);               
        } else {   
            lapset = ensimmainen.haeLapset();
        }
   
        TrieSolmu toinen = lapset.get(sanat[1]);
       
        if (toinen == null) {
            String uudetSanat = arvoAlkusanat();
            arvoSana(uudetSanat);          
        } else {
            
            lapset = toinen.haeLapset();
        }
        
        arvottuSana = arvoSeuraajista(lapset);
               
        return arvottuSana;
    }
    
    /**
     * Arpoo esiintymistodennäköisyyten perustuen seuraavan sanan.
     * Ensin lasketaan esiintymiskertojen summa, jota käytetään arvotun sanan etsimiseen.
     * @param lapset arvontaan käytetyn sanaparin toisen sanan lapset.
     * @return arvottu sana.
     */
    public String arvoSeuraajista(Map<String, TrieSolmu> lapset) {
        List<String> avaimet = new ArrayList<String>(lapset.keySet());
        
        if (avaimet.size() == 1) {
            String arvottuSana = avaimet.get(0);   
            return arvottuSana;
            
        } else {
            int kokonaissumma = 0;
            for (int i = 0; i < avaimet.size(); i++) {
                String avain = avaimet.get(i);
                TrieSolmu solmu = lapset.get(avain);
                kokonaissumma += solmu.haeLaskuri();
            }

            int arvottuIndeksi = satunnainenValilta(1, kokonaissumma);
            int summa = 0;
            int j = 0;
            String arvottuAvain = "...";
            
            while (summa < arvottuIndeksi) {

                arvottuAvain = avaimet.get(j);
                TrieSolmu solmu = lapset.get(arvottuAvain);
                summa += solmu.haeLaskuri();
                j++;
            }  
            return arvottuAvain;   
        }
                 
    } 
    
    /**
     * Arpoo satunnaisen luvun annetulta väliltä.
     * @param min minimiarvo.
     * @param max maksimiarvo
     * @return arvottu luku.
     */
    public int satunnainenValilta(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    /**
     * Palauttaa trien. Tarvitaan testeissä.
     * @return trie.
     */
    public Trie getTrie() {
        return this.trie;
    }    
    
}
