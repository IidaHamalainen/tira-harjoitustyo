## Ohjelman yleisrakenne

Ohjelma koostuu Trie-rakenteesta ja TekstiGeneraattoriluokasta. Triehen sanat tallennetaan Markovin ketjun toisen asteen mukaisesti eli kolmen sanan jonoissa.
Teksti jaetaan lisäysvaiheessa kolmen sanan jonoiksi, joista ensimmäinen tallennetaan juuren lapsisolmuksi, ja toinen tämän lapsisolmuksi. 
Loput sanat jotka voivat seurata kyseistä kahden sanan paria tallennetaan edelleen 2. sanan lapsisolmuiksi. Sanoja lisättäessä tallennetaan tieto siitä kuinka monta kertaa sana on esiintynyt kyseiseten sanojen jälkeen.

TekstiGeneraattori-luokassa arvotaan ensin kaksi aloitussanaa. Näiden perusteella arvotaan uusia sanoja haluttu määrä, niin että uusin sana perustuu aina kahteen edelliseen ja todennäköisyyteen millä sana esiintyy niiden perässä.

Käyttöliittymä luo tekstimuotoisen valikon, jossa voi valita haluaako generoida tekstin vai ajaa suorituskykytestit. Teksi on mahdollista generoida kahden eri kirjan pohjalta.

## Saavutetut aika- ja tilavaativuudet (m.m. O-analyysit pseudokoodista)
Suorituskykytesteissä 1000000 kokoisella Arraylla oma koneeni pyörittää testejä yli 20 min.

täydentyy myöhemmin

## Työn mahdolliset puutteet ja parannusehdotukset
Tekstin generoinnissa käy välillä jokin virhe, ja sanamäärä ei täsmää haluttuun. Tämä tapahtuu aika harvoin omien kokeilujeni perusteella.

## Lähteet

* https://www.decontextualize.com/teaching/rwet/n-grams-and-markov-chains/
* https://en.wikipedia.org/wiki/Trigram
* http://jinhaizhou.blogspot.com/2016/05/java-use-markov-chain-to-generate-text.html
* https://towardsdatascience.com/introduction-to-markov-chains-50da3645a50d
* https://analyticsindiamag.com/hands-on-guide-to-markov-chain-for-text-generation/
* https://web.stanford.edu/~jurafsky/slp3/3.pdf
* Materiaaliteksti on Arthur Conan Doyle: Sherlock Holmesin seikkailut 1.  http://www.lonnrot.net/etext.html#Doyle ja Jane Austen: Ylpeys ja ennakkoluulo http://www.lonnrot.net/etext.html#Austen
