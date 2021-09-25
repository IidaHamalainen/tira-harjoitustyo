
package tietorakenne;

import harjoitustyo.markovinketju.Ngrams;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author iida
 */
public class TrigamTest {
    
    private Ngrams testiTrigam;
    
    @Before
    public void setUp() {
        this.testiTrigam = new Ngrams();
        
    }
    @Test
    public void luoTrigamToimii() {
        this.testiTrigam.luoTrigam("hai valas ui, hai valas lohi, valas ui ohi");
        assertNotNull(testiTrigam.haeTrigramLuettelo());
    }

    
}
