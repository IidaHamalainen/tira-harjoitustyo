## Ohjelman yleisrakenne

Ohjelma koostuu Trie-rakenteesta, johon sanat tallennetaan Trigram-luokan mukaisesti. Trigram käsittelee teksin Markovin ketjun toisen asteen mukaiseksi.
Teksti jaetaan kahden sanan pareiksi, joista ensimmäinen tallennetaan juuren lapsisolmuksi, ja soinen tämän lapsisolmuksi. 
Loput sanat jotka voivat seurata kyseistä kahden sanan paria tallennetaan edelleen 2. sanan lapsisolmuiksi.
Generaattori-luokassa arvotaan ensin kaksi aloitussanaa. Näiden perusteella arvotaan uusia sanoja haluttu määrä.

## Saavutetut aika- ja tilavaativuudet (m.m. O-analyysit pseudokoodista)
täydentyy myöhemmin

## Työn mahdolliset puutteet ja parannusehdotukset
täydentyy myöhemmin

## Lähteet

* https://www.decontextualize.com/teaching/rwet/n-grams-and-markov-chains/
* https://en.wikipedia.org/wiki/Trigram
* http://jinhaizhou.blogspot.com/2016/05/java-use-markov-chain-to-generate-text.html
* https://towardsdatascience.com/introduction-to-markov-chains-50da3645a50d
* https://analyticsindiamag.com/hands-on-guide-to-markov-chain-for-text-generation/
* https://web.stanford.edu/~jurafsky/slp3/3.pdf
