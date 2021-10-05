
package harjoitustyo;

import harjoitustyo.kayttoliittyma.Kayttoliittyma;
import harjoitustyo.markovinketju.TekstiGeneraattori;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import suorituskykytestaus.Suorituskykytestit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author iida
 */
public class Main {

    
    public static void main(String[] args) throws Exception {
        
        Scanner lukija = new Scanner(System.in);
        
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
        kayttis.kaynnista();
        /*     
        TekstiGeneraattori generaattori = new TekstiGeneraattori();
        Trie trie = new Trie();  
        String teksti = "";
        
        Scanner tiedostonlukija;
             
        try {
            tiedostonlukija = new Scanner(new File("sherlock.txt"));
            
            while (tiedostonlukija.hasNext()) { 
                String rivi = tiedostonlukija.nextLine();
                if (!rivi.isEmpty()) {
                    teksti = teksti + rivi + " ";
                }
            }    
            tiedostonlukija.close();            
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        
        generaattori.lueMateriaali(teksti);       
        
        
        
        System.out.println(generaattori.generoiTeksti(15));
        System.out.println(generaattori.generoiTeksti(15));
     
        /*
        if (trie.haeSanoja("ui hai valas") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        
        if (trie.haeSanoja("valas ui ohi") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        */
        
        //System.out.println(generaattori.luoTeksti(5));
        //System.out.println("");
        //System.out.println(generaattori.luoTeksti(7)); 
       
        
        //Trie trie = new Trie();    
        
        //trie.lisaa("Kissa vei kielen. Ässä maukuu. Kissa vei kalat");
        //trie.lisaaSanoja("Kissa istui puussa");
        /*
        System.out.println("sanat lisätty");
        
        if (trie.haeSanoja("Kissa vei kalat") == true) {
            System.out.println("lause löytyi");
        } else {
            System.out.println("lause ei löydy");
        }
        */
        
        
        //suorituskyky
        /*
        Suorituskykytestit stestit = new Suorituskykytestit();
        
        stestit.trieSuoritus();
        System.out.println("");
        stestit.generoinninTestaus();
        */
 
    }
    
}
