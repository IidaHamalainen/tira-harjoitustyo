
package suorituskykytestaus;

import harjoitustyo.markovinketju.TekstiGeneraattori;
import harjoitustyo.tietorakenne.Trie;
import harjoitustyo.tietorakenne.TrieSolmu;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author iida
 */
public class Suorituskykytestit {
    
    private final int[] arraynKoko = {10, 100, 1000, 10000, 100000}; //1000000 vie todella kauan koneellani, joten en aja sitä usein
    private final double[] lisayksetTriehen = new double[arraynKoko.length];
    private final double[] generointi = new double[arraynKoko.length];
    private final Random random;
    
    
    public Suorituskykytestit() {
        this.random = new Random();
    } 
    /**
     * Suorituskykytesti Trielle.
     * rakennetaan trie 100 kertaa ja otetaan mediaani.
     */        
            
    public void trieSuoritus() {
       
        int n = 100;       
        
        for (int i = 0; i < arraynKoko.length; i++) {
            long[] suoritusajat = new long[n];
            long t;       
            Trie trie = new Trie();
            String teksti = "";
 
            int sanamaara = arraynKoko[i];
            
            //luodaan halutun mittainen teksti.
            //arpomisen takia käytetään Integeriä joka tallennetaan merkkijonona niin että luku edustaa sanaa
            for (int s = 0; s < sanamaara; s++) {
                Integer luku = random.nextInt();
                String lisattava = luku.toString() + " ";
                teksti += lisattava;
                
            }          
            //testataan triehen lisäämistä
            for (int j = 0; j < n; j++) {
                
                t = System.nanoTime();
                trie.lisaa(teksti);
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
            String teksti = "";
            int sanamaara = arraynKoko[i];
            
            //luodaan halutun mittainen teksti.
            //arpomisen takia käytetään Integeriä joka tallennetaan merkkijonona niin että luku edustaa sanaa
            for (int s = 0; s < sanamaara; s++) {
                Integer luku = random.nextInt();
                String lisattava = luku.toString() + " ";
                teksti += lisattava;
                
            } 
            for (int j = 0; j < n; j++) {

                t = System.nanoTime();
                generaattori.lueMateriaali(teksti);
                
                String luotuTeksti = generaattori.generoiTeksti(20);
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
            

