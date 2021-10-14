
package harjoitustyo;

import harjoitustyo.kayttoliittyma.Kayttoliittyma;
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

    }
    
}
