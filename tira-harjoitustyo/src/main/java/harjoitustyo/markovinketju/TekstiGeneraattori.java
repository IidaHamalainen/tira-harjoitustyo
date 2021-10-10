
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
     * Muokkaa tekstiä niin että siitä poistetaan pisteet ja pilkut.
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
     * generoi halutun mittaisen tekstin.
     * Ensimmäinen sanapari arvotaan Triestä, ja sen jälkeen aina kahden edellisen sanan perusteella arvotaan seuraava.
     * @param sanamaara haluttu tekstin pituus sanoina.
     * @return muodostettu teksti.
     */
    public String generoiTeksti(int sanamaara) {
        
        String lause = "";
        //arvotaan ensin alkusanat ja lisätään lauseeseen
        String alkusanat = arvoAlkusanat();
        lause = lause + alkusanat + " ";
        int tekstinPituus = 2;
        
        //arvotaan sitten haluttu määrä sanoja
        while (tekstinPituus < sanamaara) {
            //tähän mennessä luotu lause jaetaan yksittäisiksi sanoiksi
            String sanat[] = lause.split(" ");
            //kahta viimeistä käytetään hakemaan mahdolliset seuraavat sanat
            String edelliset = sanat[sanat.length - 2] + " " + sanat[sanat.length - 1];
            String sana = arvoSana(edelliset);
            lause = lause + sana + " ";
            tekstinPituus++;
        }
        return lause;     
    }  
    /**
     * arpoo kaksi sanaa.
     */ 
    public String arvoAlkusanat() {
        
        Random random = new Random(); 
        TrieSolmu juuri = trie.haeJuuri();
        
        //haetaan juuren lapset
        Map<String, TrieSolmu> lapset1 = juuri.haeLapset();        
        List<String> avaimet1 = new ArrayList<String>(lapset1.keySet()); 
        //arvotaan ensimmäinen sana juuren lapsista
        String arvottuSana1 = avaimet1.get(random.nextInt(avaimet1.size()));
        TrieSolmu solmu = lapset1.get(arvottuSana1); 
        //haetaan arvotun sanan lapset
        Map<String, TrieSolmu> lapset2 = solmu.haeLapset(); 
        List<String> avaimet2 = new ArrayList<String>(lapset2.keySet());
        //arvotaan toinen sana ensimmäisen lapsista
        String arvottuSana2 = avaimet2.get(random.nextInt(avaimet2.size()));
        
        String sanapari = arvottuSana1 + " " + arvottuSana2;
        
        return sanapari;
        
    } 
    /**
     * Arvotaan sana kahden edellisen sanan perusteella mahdollisista seuraajista.
     * To do: arvonta todennäköisyyteen perustuen.
     * @param edelliset edelliset sanat.
     * @return arvottu sana.
     */
    public String arvoSana(String edelliset) {
        
        Random random = new Random();
        TrieSolmu juuri = trie.haeJuuri();
        Map<String, TrieSolmu> lapset = juuri.haeLapset();
        String arvottuSana;
        
        //jaetaan sanapari yksittäisiksi sanoiksi
        String sanat[] = edelliset.split(" "); 
        //haetaan ensimmäisen lapsisolmut
        TrieSolmu ensimmainen = lapset.get(sanat[0]);  
        
        //jos ensimmäistä sanaa ei löydy, arvotaan uudet   
        if (ensimmainen == null) {  
            String uudetSanat = arvoAlkusanat();
            arvoSana(uudetSanat);               
        } else {   
            lapset = ensimmainen.haeLapset();
        }
        //haetaan toisen sanan lapset
        TrieSolmu toinen = lapset.get(sanat[1]);
        //jos sanaa ei löydy, arvotaan uudet
        if (toinen == null) {
            String uudetSanat = arvoAlkusanat();
            arvoSana(uudetSanat);          
        } else {
            //lapset on nyt toisen sanan lapset, eli potentiaaliset seuraavat
            lapset = toinen.haeLapset();
        }
        //lista mahdollisista seuraavista sanoista    
        List<String> avaimet = new ArrayList<String>(lapset.keySet());
        //jos on vain yksi seuraaja, valitaan se suoraan
        if (avaimet.size() == 1) {
            arvottuSana = avaimet.get(0);             
        } else {
            
            //arvottuSana = avaimet.get(random.nextInt(avaimet.size()));  //satunnainen arvonta ilman laskuria
            
            //lasketaan mahdollisten seuraajien yhteenlasketut esiintymiskerrat 
            int kokonaissumma = 0;
            for (int i = 0; i < avaimet.size(); i++) {
                String avain = avaimet.get(i);
                TrieSolmu solmu = lapset.get(avain);
                kokonaissumma += solmu.haeLaskuri();
            }
            //arvotaan luku 1 ja esiintymiskertojen kokonaissumman väliltä
            int arvottuIndeksi = satunnainenValilta(1, kokonaissumma);
            int summa = 0;
            int j = 0;
            String arvottuAvain = "";
            //etsitään arvottu sana
            while(summa < arvottuIndeksi) {

                arvottuAvain = avaimet.get(j);
                TrieSolmu solmu = lapset.get(arvottuAvain);
                summa += solmu.haeLaskuri();
                j++;
            }  
            arvottuSana = arvottuAvain;  
            
        }
        return arvottuSana;
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
