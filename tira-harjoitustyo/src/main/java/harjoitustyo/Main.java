
package harjoitustyo;

import harjoitustyo.markovinketju.MarkovAlgoritmi;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Ngrams;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author iida
 */
public class Main {

    
    public static void main(String[] args) {
        
        String materiaali1 = " Yksinkertainen ja selvä ei tavallisesti tule ensimmäisenä vaan viimeisenä" 
                + " Viisas ihminen ei sure sitä, mitä hänellä ei ole vaan iloitsee siitä, mitä hänellä on"
                + " Elämä vailla juhlia on kuin pitkä tie vailla lepotaukoja"
                + " Joskus on pelkkä elokin uroteko"
                + " Mitä suurempi vaiva, sitä suurempi ilo"
                + " Mitä suurempi ilo, sitä suurempi vaiva";
        
        String materiaali2 = "hai valas ui, hai valas lohi, valas ui ohi";
        
        //Ngrams bigrams = new Ngrams();
        
        //HashMap<String, Integer> testigrams = bigrams.trigrams("Mitä suurempi vaiva, sitä suurempi ilo sitä suurempi ilo");
        
        //HashMap<String, List<String>> testi = bigrams.sanaTrigram(materiaali);
        
        //System.out.println(Arrays.asList(testi));
        
       
        
        //MarkovAlgoritmi generaattori = new MarkovAlgoritmi();
        
        //generaattori.lueMateriaali(materiaali2);
        //generaattori.luoTrigram(materiaali2);
        
        //System.out.println(generaattori.getTrigramLuettelo());
        
        //System.out.println(generaattori.luoTeksti(5));
        //System.out.println("");
        //System.out.println(generaattori.luoTeksti(7));
        
       
        
        Trie trie = new Trie();    
        
        trie.lisaaTeksti("Kissa vei kielen. Kissa maukuu. Kissa vei kalat");
        //trie.lisaaSanoja("Kissa istui puussa");
      
        System.out.println("sanat lisätty");
        
        if (trie.haku("Kissa vei kalat.") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        if (trie.haku("Kissa maukuu") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        if (trie.haku("Kensöi") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        
     
        
      
       
        
    }
    
}
