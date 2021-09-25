
package harjoitustyo;

import harjoitustyo.markovinketju.MarkovAlgoritmi;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Ngrams;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author iida
 */
public class Main {

    


    
    public static void main(String[] args) throws Exception {
        
        MarkovAlgoritmi generaattori = new MarkovAlgoritmi();
        StringBuilder teksti = new StringBuilder();
        
        try (Scanner tiedostonLukija = new Scanner(new File("sananlaskuja.txt"))) { 
            
            while (tiedostonLukija.hasNextLine()) { 
            String rivi = tiedostonLukija.nextLine();
            teksti.append(rivi);
            
            }
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        generaattori.lueMateriaali(teksti.toString());
        
        
        String materiaali1 = " Yksinkertainen ja selvä ei tavallisesti tule ensimmäisenä vaan viimeisenä."
                + " Yksinkertainen ja viisas kyllä tavallisesti tule ensimmäisenä vaan viimeisenä."
                + " Mitä suurempi vaiva, sitä suurempi ilo."
                + " Mitä suurempi ilo, sitä suurempi vaiva.";
        
        String materiaali2 = "hai valas ui, hai valas lohi, valas ui ohi";
        
        //Ngrams bigrams = new Ngrams();
        
        //HashMap<String, Integer> testigrams = bigrams.trigrams("Mitä suurempi vaiva, sitä suurempi ilo sitä suurempi ilo");
        
        //HashMap<String, List<String>> testi = bigrams.sanaTrigram(materiaali);
        
        //System.out.println(Arrays.asList(testi));
        
        //System.out.println(generaattori.getTrigramLuettelo());
        
        System.out.println(generaattori.luoTeksti(5));
        System.out.println(generaattori.luoTeksti(6));
        System.out.println(generaattori.luoTeksti(7));
        //System.out.println("");
        //System.out.println(generaattori.luoTeksti(7)); 
       
        /*
        Trie trie = new Trie();    
        
        trie.lisaaTeksti("Kissa vei kielen. Ässä maukuu. Kissa vei kalat");
        //trie.lisaaSanoja("Kissa istui puussa");
      
        System.out.println("sanat lisätty");
        
        if (trie.haku("Kissa vei kalat.") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        if (trie.haku("Ässä maukuu") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        if (trie.haku("Kensöi") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        */
 
    }
    
}
