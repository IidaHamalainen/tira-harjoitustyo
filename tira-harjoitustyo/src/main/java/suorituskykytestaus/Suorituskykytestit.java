
package suorituskykytestaus;

import harjoitustyo.markovinketju.TekstiGeneraattori;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import harjoitustyo.markovinketju.Trigram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/**
 *
 * @author iida
 */
public class Suorituskykytestit {
    

    private final int[] arraynKoko = {10, 100, 1000, 10000, 100000, 1000000};
    private final double[] lisayksetTriehen = new double[arraynKoko.length];
    private final double[] generointi = new double[arraynKoko.length];
    
    /**
     * Suorituskykytesti Trielle.
     * rakennetaan trie 100 kertaa ja otetaan mediaani.
     */
    public void trieSuoritus() {
       
        int n = 100;
        
        for (int i = 0; i < arraynKoko.length; i++) {
            long[] suoritusajat = new long[n];
            long t;
            HashMap<String, List<String>> sanat = new HashMap<String, List<String>>();
            Trie trie = new Trie();
          
            //alustetaan sanat-lista joka lisätään triehen
            sanat.put("katon rajas", Arrays.asList("kulkee", "kolme"));
            sanat.put("rajas kulkee", Arrays.asList("hauki", "neljä"));
            sanat.put("kulkee hauki", Arrays.asList("ilkein", "viisi"));
            sanat.put("hauki ilkein", Arrays.asList("silmin", "kuusi"));
            sanat.put("ilkein silmin", Arrays.asList("tuijottaa", "seitsemän"));
            sanat.put("silmin tuijottaa", Arrays.asList("kierrä", "kahdeksan"));
 
            
            //testataan triehen lisäämistä
            for (int j = 0; j < n; j++) {
                
                t = System.nanoTime();
                trie.lisaa(sanat);
                t = System.nanoTime() - t;
                suoritusajat[j] = t;
            }
            
            //lasketaan mediaani
            Arrays.sort(suoritusajat);
            lisayksetTriehen[i] = suoritusajat[suoritusajat.length / 2] / 1000000.0;
        }
        System.out.println("Lisäys triehen");
        for (int i = 0; i < arraynKoko.length; i++) {
           System.out.println(arraynKoko[i] + ": " + lisayksetTriehen[i] + "ms");
        }
        
        
        
    }
    /**
     * Testi tekstin generoinnille.
     * Generoidaan 7 sanan mittainen teksti 50 kertaa.
     */
    
    public void generoinninTestaus() {
        
        int n = 50;
        
        TekstiGeneraattori generaattori = new TekstiGeneraattori(); 
        
        for (int i = 0; i < arraynKoko.length; i++) {
            long[] suoritusajat = new long[n];
            long t;
        
        
            String opetusmateriaali = " jäi Uudelle vain päivä elämää ja elämään se iltakin näin jää."
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
        
            for (int j = 0; j < n; j++) {

                t = System.nanoTime();
                generaattori.lueMateriaali(opetusmateriaali);
                
                String luotuTeksti = generaattori.generoiTeksti(7);
                t = System.nanoTime() - t; 
                suoritusajat[j] = t;
            }
            //lasketaan mediaani
            Arrays.sort(suoritusajat);
            generointi[i]  = suoritusajat[suoritusajat.length / 2] / 1000000.0;    
        }
        System.out.println("Tekstin generointi");
        for (int i = 0; i < arraynKoko.length; i++) {
            System.out.println(arraynKoko[i] + ": " + generointi[i] + "ms");
        }  
        
        
    }
    
}
            

