
package tietorakenne;

import harjoitustyo.markovinketju.Trigram;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author iida
 */
public class TrigamTest {
    
    private Trigram testiTrigam;
    
    @Before
    public void setUp() {
        this.testiTrigam = new Trigram();
        
    }
    @Test
    public void luoTrigamToimii() {
        this.testiTrigam.luoTrigam("hai valas ui, hai valas lohi, valas ui ohi");
        assertNotNull(testiTrigam.haeTrigramLuettelo());
    }
    @Test
    public void tekstinKasittelyToimii() {
        String teksti = "Hello. world,";
        String kasitelty = this.testiTrigam.kasitteleTeksti(teksti);
        assertEquals("hello world", kasitelty);
    }

    
}
