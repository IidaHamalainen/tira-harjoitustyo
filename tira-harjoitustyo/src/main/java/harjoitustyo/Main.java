
package harjoitustyo;

import harjoitustyo.markovinketju.MarkovAlgoritmi;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;

/**
 * 
 * @author iida
 */
public class Main {

    
    public static void main(String[] args) {
        
        MarkovAlgoritmi generaattori = new MarkovAlgoritmi();
        
        String materiaali = " Yksinkertainen ja selvä ei tavallisesti tule ensimmäisenä vaan viimeisenä" 
                + " Viisas ihminen ei sure sitä, mitä hänellä ei ole vaan iloitsee siitä, mitä hänellä on"
                + " Elämä vailla juhlia on kuin pitkä tie vailla lepotaukoja"
                + " Joskus on pelkkä elokin uroteko"
                + " Mitä suurempi vaiva, sitä suurempi ilo";
        
        generaattori.lueMateriaali(materiaali);
        
        System.out.println(generaattori.luoTeksti(5));
        System.out.println("");
        System.out.println(generaattori.luoTeksti(7));
        
       
        /*
        Trie trie = new Trie();    
        
        trie.lisaaSana("Kissa");
        trie.lisaaSana("koira");
        trie.lisaaSana("apina");
        trie.lisaaSana("pupu");
        trie.lisaaSana("paviaani");
        trie.lisaaSana("ankka");
        System.out.println("sanat lisätty");
        
        if (trie.haku("kissa") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        if (trie.haku("Kissa") == true) {
            System.out.println("sana löytyi");
        } else {
            System.out.println("sanaa ei löydy");
        }
        String sana1 = trie.satunnainenSana();
        String sana2 = trie.satunnainenSana();
        
        System.out.println(sana1 + " " + sana2);
        */
        
       
        
    }
    
}
