
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
     * Tulostaa valikon.
     */
    public void kaynnista() {
              
        System.out.println("Tervetuloa Tekstigeneraattoriin!");
        
        while (true) {           
            
            System.out.println("");
            System.out.println("Valitse: ");
            System.out.println("[1] Generoi teksti");
            System.out.println("[2] Aja suorituskykytestit");
            System.out.println("[Q] lopeta");
            System.out.println("");
        
        String toiminto = lukija.nextLine();
            
        //jos syötetty toiminto ei ole 1, 2 tai Q ilmoitetaan käyttäjälle virheestä
            if (!(toiminto.equals("1") || toiminto.equals("2") || toiminto.equals("Q"))) {
                System.out.println("virheellinen syöte");
                continue;
            }
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
     * Jos annettu sanamaarä on alle 2 tai ei luku, palataan edelliseen valintakohtaan.
     */ 
    private void generointi() {
        int tekstinPituus = 0;
        System.out.println("Generoidaan teksti: ");
        System.out.println("");       
        
        System.out.println("Kumpi kirja valitaan?");
        System.out.println("1: Sherlock Holmesin seikkailut | 2: Ylpeys ja ennakkoluulo");
        
        String valinta = lukija.nextLine();
        String kirja = "";
        
        if (!(valinta.equals("1") || valinta.equals("2"))) {
            System.out.println("virheellinen syöte");
            return;
        } else if (valinta.equals("1")) {
            kirja = "sherlock.txt";
        } else if (valinta.equals("2")) {
            kirja = "yjae.txt";
        }
            
        
        System.out.println("Kuinka pitkä teksti generoidaan?");        
        
        try {
           tekstinPituus = Integer.parseInt(lukija.nextLine());
           if (tekstinPituus < 2) {
            System.out.println("Anna suurempi luku");
            return;
            }
         
        //jos syöte ei ole Integer-numero, ilmoitetaan käytäjälle ja palataan valikkoon   
        } catch (NumberFormatException ex) {
            System.out.println("Virheellinen syöte. Anna numero");
            return;
        }                    
        //luodaan trie ja generoidaan tekstiGeneraattorissa halutun mittainen teksti
        TekstiGeneraattori generaattori = new TekstiGeneraattori();
        String opetusmateriaali = lueTiedosto(kirja);
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
    private String lueTiedosto(String kirja) {
  
        String teksti = "";       
        Scanner tiedostonlukija;
             
        try {
            //tiedostonlukija = new Scanner(new File("sherlock.txt"));
            tiedostonlukija = new Scanner(new File(kirja));
            
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
