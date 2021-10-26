# Testaus

# Yksikkötestit
Yksikkötesteillä on testattu Trie, TekstiGeneraattori ja Kayttoliittyma-luokkien perustoiminnot.
Testit suoritetaan komennolla ./gradlew test. Kattavuusraportoinnissa käytän Jacocoa.
Kokonaiskuva testikattavuudesta: ![kuva](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_kaikki_26102021.png)
Ylin "harjoitustyo" sisältää ainoastaan main-luokan jota varten en kirjoita testejä.

Alla vielä eri packagien testikattavuus. Käyttöliittymän testit nostavat jonkin  verran kokonaisuutta generaattorissa, joten kuvissa testikattavuus ilman käyttäliittymätestejä:
![käyttöliittymä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_kayttoliittyma26102021.png)
![generaattori](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_tekstigeneraattori_19102021.png)
![tietorakenne](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_tietorakenne_19102021.png)
 

# Checkstyle
Checkstyle-raportti on nähtävissä [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle25092021.png)

Testiluokkien Checkstyle [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle_test25092021.png)

# Suorituskykytestit
Suorituskykyä testataan 10, 100, 1000, 10 000, 100 000 ja 1000 000 -kokoisilla taulukoilla. Trieen lisääminen tehdään 100 kertaa, Triestä haku samoin 100 kertaa, ja tekstin generointi 50 kertaa. Tuloksista tallennetaan mediaani, koska se on parempi kuin keskiarvo JIT-kääntämisen ja Javan roskien keräyksen kannalta. 
Suorituskykytestit on nyt Trieen lisäämiseen ja sietä hakemiseen satunnaisella syötteellä, sekä tekstin generointiin.

Triessä testataan aikaa mikä menee tallentaa tieto Triehen ja hakea sieltä. Käytän testeissä satunnaisgeneroituja numeroita korvaamaan sanoja. Lopullisessa sovelluksessani en käytä hakua muualla kuin yksikkötesteissä kun tarkistan että lisääminen on onnistunut, mutta haun arvioiminen antaa myös kuvaan suorituskyvystä.

Generaattorin suorituskykytestissä testataan aikaa mikä menee 20 "sanan" eli tässä tapauksessa numeron mittaisen tekstin arpomiseen. Pituus ei perustu mihinkään erityiseen, vaan on vain päättämäni luku sillä perusteella että sovelluksella on hyvä generoida noin tuon mittaisia sanajonoja jolloin ero alkuperäiseen tekstiin ilmenee.

Alla taulukossa kuluneet ajat millisekunteina kullakin taulukolla.

![suorituskykytestit](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/suoritusajat.png)

# Tulokset
Testit suoritettiin Intel® Processor 5Y10 CPU:lla, jossa on 7,71 GiB muistia. Läppäri on siis jo vanha, ja tämä näkyi siinä että suorituskykytesteissä meni kokonaisuudessaan noin 1,5h aikaa.

Trien tilavaatimus ei vielä näillä syöttellä aiheuttanut suuria ongelmia. Trien luominen ja haku olivat suurimmilla taulukoilla jo todella hitaita. Googlailuni perusteella yleinen sanamäärä romaanissa on noin 60 000- 120 000 sanaa, joten kokonaisten kirjojen lisääminen triehen sujuu vielä suhteellisen järkevässä ajassa, mikä näkyy empiirisestikin sovellusta käytettäessä. Hitaus oli oletettavaa, koska lisättäessä sanoja ne lisätään Markovin ketjun toisen asteen mukaan joten joudutaan aina katsomaan kahta edellistäkin sanaa.

# Testien toistaminen
Käyttöliittymässä saa valittua suorituskykytestien ajamisen, eli testi on helposti toistettavissa.
