
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import harjoitustyo.kayttoliittyma.Kayttoliittyma;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
Käyttöliittymän testit.
*/
public class KayttoliittymaTest {
    
    private Kayttoliittyma k;
    private final ByteArrayOutputStream tulostus = new ByteArrayOutputStream();   
    
    @Before
    public void alustus() {
        this.k = new Kayttoliittyma();
        System.setOut(new PrintStream(tulostus));
    }
    
    @Test
    public void kayttoliittymaValikkoToimiiValinta1() throws Exception {
        Scanner lukija = new Scanner("1\n1\n5\nQ");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista(); 
        String[] syote = tulostus.toString().split("\n");
        assertTrue(syote[0].startsWith("Tervetuloa"));
        assertTrue(syote[7].startsWith("Generoidaan"));
    } 
    @Test
    public void kayttoliittymaValikkoToimiiValinta2() throws Exception {
        Scanner lukija = new Scanner("2\nQ");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista(); 
        String[] syote = tulostus.toString().split("\n");
        assertTrue(syote[0].startsWith("Tervetuloa"));
        assertTrue(syote[7].startsWith("Ajetaan"));
    } 
    @Test
    public void kayttoliittymaValikkoToimiiVirheellinenSyote() throws Exception {
        Scanner lukija = new Scanner("3\nQ");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista(); 
        String[] syote = tulostus.toString().split("\n");
        assertTrue(syote[0].startsWith("Tervetuloa"));
        assertTrue(syote[7].startsWith("virheellinen"));
    }
    @Test
    public void kayttoliittymaValikkoToimiiVirheellinenKirja() throws Exception {
        Scanner lukija = new Scanner("1\n3\nQ");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista(); 
        String[] syote = tulostus.toString().split("\n");
        assertTrue(syote[0].startsWith("Tervetuloa"));
        assertTrue(syote[7].startsWith("Generoidaan"));
        assertTrue(syote[11].startsWith("virheellinen"));
    }
       
}
