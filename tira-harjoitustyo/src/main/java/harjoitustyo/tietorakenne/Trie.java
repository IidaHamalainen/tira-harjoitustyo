
package harjoitustyo.tietorakenne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import harjoitustyo.markovinketju.Ngrams;



/**
 *
 * @author iida
 */
public class Trie {
    
    private TrieSolmu juuri;
    
    
    public Trie() {
        juuri = new TrieSolmu();
    }
    
    public TrieSolmu haeJuuri() {
        return this.juuri;
    }
    
    public Map<String, TrieSolmu> haeSeuraajat(TrieSolmu juuri) {
        Map<String, TrieSolmu> seuraajat = juuri.haeLapset();
        
        return seuraajat;
    }
    
    /**
     * lisätään trie-rakenteeseen n-gramilla tuotetut sanaparit ja niiden seuraajat.
     * @param sanat 
     */
    public void lisaa(HashMap<String, List<String>> sanat) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        TrieSolmu nykyinen = juuri;
       
        //tallennetaan sanaparit eli avaimet listaan
        List<String> avaimet = new ArrayList<String>(sanat.keySet()); 
        
        for (int i = 0; i < avaimet.size(); i++) {
            String avain = avaimet.get(i);
            String[] sanapari = avain.split(" ");
            String ekaSana = sanapari[0];
            String tokaSana = sanapari[1];      
                        
            //tallennetaan sanaparin 1 sana juuren lapseksi
            if (lapset.containsKey(ekaSana)) {
                nykyinen = lapset.get(ekaSana);
                nykyinen.lisaaEsiintymiskerta();
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(ekaSana, nykyinen);  
            }
            lapset = nykyinen.haeLapset();  //1.sanan lapset
            
            
            //tallennetaan parin 2 sana äskeisen lapseksi
            if (lapset.containsKey(tokaSana)) {
                nykyinen = lapset.get(tokaSana);
                nykyinen.lisaaEsiintymiskerta();
            } else {
                nykyinen = new TrieSolmu();
                lapset.put(tokaSana, nykyinen);
                
            }
            lapset = nykyinen.haeLapset(); //2.sanan lapset
            
            List<String> seuraajat = sanat.get(avain);
            //tallennetaan tämän jälkeen 2. sanan seuraajat 2. lapsiksi
            
            if (seuraajat.size() == 1) {
                String seuraaja = seuraajat.get(0);
                              
                if (lapset.containsKey(seuraaja)) {
                nykyinen = lapset.get(seuraaja);
                nykyinen.lisaaEsiintymiskerta();
                
                } else {
                nykyinen = new TrieSolmu();
                lapset.put(seuraaja, nykyinen);
                }
            }
            for (int j = 0; j < seuraajat.size(); j++) {
                String seuraaja = seuraajat.get(j);
                
                if (lapset.containsKey(seuraaja)) {
                nykyinen = lapset.get(seuraaja);
                nykyinen.lisaaEsiintymiskerta();
                
                } else {
                nykyinen = new TrieSolmu();
                lapset.put(seuraaja, nykyinen);
                }
            }
            lapset = juuri.haeLapset();
            
        }
    }
    
    /**
     * haetaan triestä sanoja.
     * @param sanat
     * @return 
     */
    public boolean haeSanoja(String sanat) {
        Map<String, TrieSolmu> lapset = juuri.haeLapset();

        TrieSolmu nykyinen = null;  

        String[] yksittaisetSanat = sanat.split(" ");
        for (int i = 0; i < yksittaisetSanat.length; i++) {
            String sana = yksittaisetSanat[i];
            
            if (lapset.containsKey(sana)) {
                nykyinen = lapset.get(sana);
                lapset = nykyinen.haeLapset();
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

    /**
     * arpoo kaksi sanaa.
     */ 
    public String arvoAlkusanat() {
        Random random = new Random(); 
        int laskurinArvo = 0;
        
        Map<String, TrieSolmu> lapset1 = juuri.haeLapset();        
        List<String> avaimet1 = new ArrayList<String>(lapset1.keySet()); 
        
        String arvottuSana1 = avaimet1.get(random.nextInt(avaimet1.size()));
        TrieSolmu solmu = lapset1.get(arvottuSana1); 
 
        Map<String, TrieSolmu> lapset2 = solmu.haeLapset(); 
        List<String> avaimet2 = new ArrayList<String>(lapset2.keySet());
        String arvottuSana2 = avaimet2.get(random.nextInt(avaimet2.size()));
        
        /*
        //lasketaan yhteen sanojen esiintymiskerrat
        for (int i = 0; i < avaimet1.size(); i++) {
            String avain = avaimet1.get(i);
            TrieSolmu solmu1 = lapset1.get(avain);
            laskurinArvo += solmu1.haeLaskuri();           
        }
        int arvottuIndeksi = satunnainenValilta(0, laskurinArvo);
        int solmunArvo = 0;
        int j = 0;
        String arvottuAvain = "";
        //etsitään arvottu sana
        while(arvottuIndeksi > solmunArvo) {
            
            arvottuAvain = avaimet1.get(j);
            TrieSolmu solmu = lapset1.get(arvottuAvain);
            solmunArvo = solmu.haeLaskuri();
            arvottuIndeksi -= solmunArvo;
            j++;
        }  
        
        String arvottuSana1 = arvottuAvain;
        TrieSolmu ekasolmu = lapset1.get(arvottuSana1); 
        
        Map<String, TrieSolmu> lapset2 = ekasolmu.haeLapset(); 
        List<String> avaimet2 = new ArrayList<String>(lapset2.keySet());
        
        laskurinArvo = 0;
        //lasketaan yhteen sanojen esiintymiskerrat
        for (int i = 0; i < avaimet2.size(); i++) {
            String avain = avaimet2.get(i);
            TrieSolmu solmu2 = lapset2.get(avain);
            laskurinArvo += solmu2.haeLaskuri();           
        }
        arvottuIndeksi = satunnainenValilta(0, laskurinArvo);
        solmunArvo = 0;
        j = 0;
        
        while(arvottuIndeksi > solmunArvo) {
            
            arvottuAvain = avaimet2.get(j);
            TrieSolmu solmu = lapset2.get(arvottuAvain);
            solmunArvo = solmu.haeLaskuri();
            arvottuIndeksi -= solmunArvo;
            j++;
        }
        String arvottuSana2 = arvottuAvain;
        /*
        String arvottuSana1 = avaimet1.get(random.nextInt(avaimet1.size()));
        TrieSolmu solmu = lapset1.get(arvottuSana1); 
        
        
        Map<String, TrieSolmu> lapset2 = solmu.haeLapset(); 
        List<String> avaimet2 = new ArrayList<String>(lapset2.keySet());
        String arvottuSana2 = avaimet2.get(random.nextInt(avaimet2.size()));
        */
        String sanapari = arvottuSana1 + " " + arvottuSana2;
        
        return sanapari;
        
    } 
    /*
    public int satunnainenValilta(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }*/
   

    
}
    

    



