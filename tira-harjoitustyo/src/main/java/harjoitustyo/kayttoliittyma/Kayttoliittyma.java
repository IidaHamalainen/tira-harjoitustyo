
package harjoitustyo.kayttoliittyma;

import java.util.Scanner;
import harjoitustyo.markovinketju.TekstiGeneraattori;
import java.io.File;
import suorituskykytestaus.Suorituskykytestit;
/**
 *
 * @author iida
 */
public class Kayttoliittyma {
    
    private Scanner lukija;
    
    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }
    
    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }
    
    public void kaynnista() {
        
        System.out.println("Tekstigeneraattori");
        System.out.println("");
        System.out.println("Valitse: ");
        System.out.println("1. generoi teksti");
        System.out.println("2. Aja suorituskykytestit");
        System.out.println("[Q] lopeta");
        System.out.println("");
        
        String toiminto = lukija.nextLine();

        
        if (toiminto.equals("1")) {
            generointi();
        } else if(toiminto.equals("2")) {
            suorituskykytestit();
        } else if (toiminto.equals("Q")) {
            return;
        }
    }
    
    
    private void generointi() {
        int tekstinPituus = 0;
        System.out.println("generoidaan teksti: ");
        System.out.println("");
        
        System.out.println("Kuinka pitkä teksti generoidaan?");
        tekstinPituus = Integer.parseInt(lukija.nextLine());
        
        TekstiGeneraattori generaattori = new TekstiGeneraattori();
        String opetusmateriaali = lueTiedosto();
        generaattori.lueMateriaali(opetusmateriaali);
        System.out.println("generoitu teksti on:");  
        System.out.println("");
        System.out.println(generaattori.generoiTeksti(tekstinPituus));
        
    }
    
    private void suorituskykytestit() {
       
        Suorituskykytestit testit = new Suorituskykytestit();
        System.out.println("Ajetaan suorituskykytestit: ");
        System.out.println("");
        testit.trieSuoritus();
        System.out.println("");
        testit.generoinninTestaus();
    }
    
    private String lueTiedosto() {
  
        String teksti = "";
        try (Scanner tiedostonLukija = new Scanner(new File("markov.txt"))) { 
                       
            while (tiedostonLukija.hasNextLine()) { 
            String rivi = tiedostonLukija.nextLine();
            teksti = teksti + " " + rivi; 
            }
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return teksti;
    }
     
    
}
