
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
    /**
     * ohjelman käynnistys.
     */
    public void kaynnista() {
              
        System.out.println("Tervetuloa Tekstigeneraattoriin!");
        
        while (true) {           
            
            System.out.println("");
            System.out.println("Valitse: ");
            System.out.println("1. Generoi teksti");
            System.out.println("2. Aja suorituskykytestit");
            System.out.println("[Q] lopeta");
            System.out.println("");
        
        String toiminto = lukija.nextLine();
            
            if (toiminto.equals("Q")) {
                break;
            } else if (toiminto.equals("1")) {
                generointi();
            } else if (toiminto.equals("2")) {
            suorituskykytestit();
            }
        }
        
    }
    /**
     * Teksti lisätään triehen ja sen jälkeen generoidaan halutun pituinen sanajono.
     */ 
    private void generointi() {
        int tekstinPituus = 0;
        System.out.println("Generoidaan teksti: ");
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
    /**
     * Suorituskykytestien ajaminen. Testit tulostetaan näkyviin.
     */
    private void suorituskykytestit() {
       
        Suorituskykytestit testit = new Suorituskykytestit();
        System.out.println("Ajetaan suorituskykytestit: ");
        System.out.println("");
        testit.trieSuoritus();
        System.out.println("");
        testit.generoinninTestaus();
    }
    /**
     * Tiedon lukeminen tekstitiedostosta.
     * @return String-muotoinen tiedosto ilman tyhjiä rivejä.
     */
    private String lueTiedosto() {
  
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
        return teksti;       
    }
     
    
}