# Ohjelman yleisrakenne

## Trie ja TrieSolmu
Triehen sanat tallennetaan Markovin ketjun toisen asteen mukaisesti eli kolmen sanan jonoissa.
Teksti jaetaan lisäysvaiheessa kolmen sanan jonoiksi, joista ensimmäinen tallennetaan juuren lapsisolmuksi, ja toinen tämän lapsisolmuksi. 
Loput sanat jotka voivat seurata kyseistä kahden sanan paria tallennetaan edelleen 2. sanan lapsisolmuiksi. Sanoja lisättäessä tallennetaan tieto TrieSolmu-luokan avulla siitä kuinka monta kertaa sana on esiintynyt kyseiseten sanojen jälkeen.

## TekstiGeneraattori
TekstiGeneraattori-luokassa arvotaan ensin kaksi aloitussanaa. Näiden perusteella arvotaan uusia sanoja haluttu määrä, niin että uusin sana perustuu aina kahteen edelliseen ja todennäköisyyteen millä sana esiintyy niiden perässä.

## Käyttöliittymä
Käyttöliittymä luo tekstimuotoisen valikon, jossa voi valita haluaako generoida tekstin vai ajaa suorituskykytestit. Teksi on mahdollista generoida kahden eri kirjan pohjalta.

## Saavutetut aika- ja tilavaativuudet
Trien tallennuksen aikavaatimus on O(n*m), jossa n on alkioiden määrä ja m on Markovin aste.
Triestä haun aikavaatimus O(n), missä n on hakuavaimen pituus. Koska sanat tallennetaan triehen kolmen sarjoissa, on kolme suurin pituus mitä voidaan hakea ja haku siten nopeaa.

Tilavaatimus on myös O(n * m), koska tekstin jokainen voi pahimmassa tapauksessa olla juuren lapsi ja sillä taas mia lapsia.

## Työn mahdolliset puutteet ja parannusehdotukset
* Tekstin generoinnissa käy välillä jokin virhe, ja sanamäärä ei täsmää haluttuun. Tämä alkoi ilmetä vasta lisättyäni seuraavan sanan generointiin todennäköisyyden mukaan. Arvelen että liittyy jotenkin tekstissä esiintyviin välilyönteihin, koska tulostetussa tekstissä on välillä selvästi usea välilyönti peräkkäin näissä tapauksissa kun sanamäärä ei täsmää. En saanut korjattua tätä, joten purkkaratkaisuna tämän virheen ohittamiseksi lisäsin käyttöliittymään tarkastuksen generoidun tekstin pituuteen. Tämä ei siis korjaa ongelman juurisyyytä, mutta virhe toistuu sen verran harvoin että tarkastuksella pystyin eliminoimaan hyvin suuren osan virheistä mitkä päätyisivät käyttäjän näkyville asti, koska nyt tekstin pitää olla kahteen kertaan väärän pituinen että se päätyy virheellisenä tulostukseen.
* Tekstin olisi voinut laittaa alkamaan aina isolla alkukirjaimella ja miettiä vielä enemmän muotoilua, mutta en kokenut tätä tässä vaiheessa tärkeäksi totetuttaa
* Nyt on valittavissa vain kaksi kirjaa joita käyttää lähdemateriaalina, toiminnallisuus uuden kirjan lisäämiseksi käyttäjän toimesta olisi yksi jatkoehdotus. 


## Lähteet

* https://www.decontextualize.com/teaching/rwet/n-grams-and-markov-chains/
* https://en.wikipedia.org/wiki/Trigram
* http://jinhaizhou.blogspot.com/2016/05/java-use-markov-chain-to-generate-text.html
* https://towardsdatascience.com/introduction-to-markov-chains-50da3645a50d
* https://analyticsindiamag.com/hands-on-guide-to-markov-chain-for-text-generation/
* https://web.stanford.edu/~jurafsky/slp3/3.pdf
* Materiaaliteksti on Arthur Conan Doyle: Sherlock Holmesin seikkailut 1.  http://www.lonnrot.net/etext.html#Doyle ja Jane Austen: Ylpeys ja ennakkoluulo http://www.lonnrot.net/etext.html#Austen
