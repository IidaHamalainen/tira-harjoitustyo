
import harjoitustyo.markovinketju.TekstiGeneraattori;
import harjoitustyo.tietorakenne.Trie;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testiluokka Markovin ketjulle.
 * @author iida
 */
public class TekstiGeneraattoriTesti {
    
    private TekstiGeneraattori testiGeneraattori;
    private Trie testiTrie;
    
    
    @Before
    public void setUp() {
        this.testiGeneraattori = new TekstiGeneraattori();            
    }
    
    @Test
    public void materiaalinLukuToimii() {
        String teksti = "olipa kerran prinsessa. olipa kerran prinssi. kerran prinsessa lähti kaupunkiin.";
               
        testiGeneraattori.lueMateriaali(teksti);       
        testiTrie = testiGeneraattori.getTrie();       
        assertEquals(testiTrie.haeSanoja("olipa kerran"), true);
    }           
    
    @Test
    public void arvoSanaToimii() {
       String teksti = "olipa kerran prinsessa";
       testiGeneraattori.lueMateriaali(teksti);
       
       String sana = testiGeneraattori.arvoSana("olipa kerran");
       assertEquals("prinsessa", sana);     
    }
    
    @Test
    public void arvoAlkuSanaToimii() {
        String teksti = "Olipa kerran prinssi. Prinssi asui linnassa";
        
        testiGeneraattori.lueMateriaali(teksti); 
        
        String sana = testiGeneraattori.arvoAlkusanat();
        String[] taulukko = sana.split(" ");
        assertEquals(taulukko.length, 2);    
    }
    
    @Test
    public void tekstinkasittelyToimii() {
        String teksti = "Olipa, kerran prinsessa.";
        String kasiteltyTeksti = testiGeneraattori.kasitteleTeksti(teksti);
        assertEquals("olipa kerran prinsessa", kasiteltyTeksti);
    }
    
    @Test
    public void tekstinGenerointiToimii() {
        String teksti = "olipa kerran prinsessa. olipa kerran prinssi. kerran prinsessa lähti kaupunkiin.";
        testiGeneraattori.lueMateriaali(teksti);
        
        String generoitu = testiGeneraattori.generoiTeksti(4);
        String[] sanat = generoitu.split(" ");
        assertEquals(4, sanat.length);
    }
      
}
