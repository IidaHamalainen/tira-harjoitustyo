
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
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
    public void kayttoliittymaValikkoToimii1() throws Exception{
        Scanner lukija = new Scanner("1\n5");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista(); 
        String[] syote = tulostus.toString().split("\n");
        assertTrue(syote[0].startsWith("Tekstigeneraattori"));
        assertTrue(syote[7].startsWith("Generoidaan"));
    } 
    @Test
    public void kayttoliittymaValikkoToimii2() throws Exception{
        Scanner lukija = new Scanner("2\n");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnista(); 
        String[] syote = tulostus.toString().split("\n");
        assertTrue(syote[0].startsWith("Tekstigeneraattori"));
        assertTrue(syote[7].startsWith("Ajetaan"));
    } 
       
}
