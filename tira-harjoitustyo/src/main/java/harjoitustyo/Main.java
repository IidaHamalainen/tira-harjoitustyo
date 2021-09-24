
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
        
        String materiaali2 = "hai haikara hattara haituva haitari";
        
        Ngrams bigrams = new Ngrams();
        
        //HashMap<String, Integer> testigrams = bigrams.trigrams("Mitä suurempi vaiva, sitä suurempi ilo sitä suurempi ilo");
        
        //HashMap<String, List<String>> testi = bigrams.sanaTrigram(materiaali);
        
        //System.out.println(Arrays.asList(testi));
        
       
        
        //MarkovAlgoritmi generaattori = new MarkovAlgoritmi();
        
        //generaattori.lueMateriaali(materiaali2);
        //generaattori.luetteloBigram(materiaali);
        
        //System.out.println(generaattori.luetteloTrigram(materiaali));
        
        //System.out.println(generaattori.luoTeksti(5));
        //System.out.println("");
        //System.out.println(generaattori.luoTeksti(7));
        
       
        
        Trie trie = new Trie();    
        
        trie.lisaaSanoja("Kissa vei kielen");
        trie.lisaaSanoja("Kissa istui puussa");
        trie.lisaaSanoja("Ken söi kesävoin");
      
        System.out.println("sanat lisätty");
        
        if (trie.haku("Kissa vei kielen.") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        if (trie.haku("Kissa vei") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        if (trie.haku("Kensöi") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        
     
        
        
        
        
       
        
    }
    
}
