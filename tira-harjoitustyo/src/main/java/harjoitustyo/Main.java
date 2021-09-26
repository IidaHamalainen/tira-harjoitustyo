
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
        Trie trie = new Trie();  
        StringBuilder teksti = new StringBuilder();
        
        try (Scanner tiedostonLukija = new Scanner(new File("sananlaskuja.txt"))) { 
            
            while (tiedostonLukija.hasNextLine()) { 
            String rivi = tiedostonLukija.nextLine();
            teksti.append(rivi);
            
            }
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        //generaattori.lueMateriaali(teksti.toString());
        //TO DO: selvitä miksi ei toimi
        
        String materiaali1 = " Yksinkertainen ja selvä ei tavallisesti tule ensimmäisenä vaan viimeisenä."
                + " Yksinkertainen ja viisas kyllä tavallisesti tulee ensimmäisenä vaan ei viimeisenä."
                + " Mitä suurempi vaiva, sitä suurempi ilo."
                + " Mitä suurempi ilo, sitä suurempi vaiva.";
        
        String materiaali2 = "hai valas ui, hai valas lohi, valas ui ohi";
        
        String materiaali3 = " jäi Uudelle vain päivä elämää ja elämään se iltakin näin jää."
                + " kuuman kostean minä tunsin Alinan ja lauteet Alasaunan."
                + " mä ensin näin kupolin vihreän ja ylöspäin vei raput käytävän."
                + " laulut laulettiin, pitkään iltaa istuttiin ja jatkoille siirryttiin"
                + " kun oluen niin vaahdontäytteisen sä tarjosit ja katsoit hymyillen."
                + " koskin pulloa ja sen pintaa kosteaa ja aloin paikkaa rakastaa."
                + " yks kerrallaan nous hauet aivoihin kun käsissäs sä kannoit Apteekkiin."
                + " sieltä Vinnille, Illusioon, Kupoliin, se ilta jatkui loputtomiin."
                + " kun päättyi yö, niin pirskeet lannistui ja A-rappuun vain kevyt haju jäi."
                + " kuljin frakissa kotiin aamubussilla ja päätin tulla uudestaan."
                + " jäi Mombasaan vain päivä elämää ja elämään nyt Mombasa vain jää"
                + " kuuman kostean minä tunsin Mombasan ja meren, taivaan, Afrikan"
                + " mä ensin näin vain meren sinisen ja korallin löi aallot jylisten"
                + " pärskeen takaa näin sinun hahmos yllättäin sä nousit rantaan nauraen ja simpukan"
                + " niin vaahdon valkoisen sä ohjensit ja katsoit hymyillen"
                + " koskin simpukkaa ja sen pintaa karheaa kuin vartaloas kosteaa"
                + " niin polttaen löi tuuli kasvoihin käsissäs sä kannoit aaltoihin"
                + " tyrksyn alle jäin olit vahva sylissäin niin lämmin suolan makuinen"
                + " kun saapui yö niin tyrskyt lannistui ja lahdelmaan vain kevyt vaahto ui"
                + " kuulin unessain leopardin huudon vain ja kosketin sua uudestaan";
        
                
        generaattori.lueMateriaali(materiaali3);
        
        trie = generaattori.getTrie();
        
        System.out.println(generaattori.generoiTeksti(10));
        
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
