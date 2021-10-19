# Testaus

# Yksikkötestit
Yksikkötesteillä on testattu Trie, TekstiGeneraattori ja Kayttoliittyma-luokkien perustoiminnot.
Testit suoritetaan komennolla ./gradlew test. Kattavuusraportoinnissa käytän Jacocoa.
Kokonaiskuva testikattavuudesta: ![kuva](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavus_kaikki_19102021.png)
Ylin "harjoitustyo" sisältää ainoastaan main-luokan jota varten en kirjoita testejä.

Alla vielä eri packagien testikattavuus. Käyttöliittymän testit nostavat jonkin  verran kokonaisuutta generaattorissa, joten kuvissa testikattavuus ilman käyttäliittymätestejä:
![käyttöliittymä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_kayttoliityma_19102021.png)
![generaattori](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_tekstigeneraattori_19102021.png)
![tietorakenne](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus_tietorakenne_19102021.png)
 

# Checkstyle
Checkstyle-raportti on nähtävissä [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle25092021.png)

Testiluokkien Checkstyle [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle_test25092021.png)

# Suorituskykytestit
Suorituskykyä testataan 10, 100, 1000, 10 000, 100 000 ja 1000 000 -kokoisilla taulukoilla. Trieen lisääminen tehdään 100 kertaa, Triestä haku samoin 100 kertaa, ja tekstin generointi 50 kertaa. Tuloksista tallennetaan mediaani, koska se on parempi kuin keskiarvo JIT-kääntämisen ja Javan roskien keräyksen kannalta. 
Suorituskykytestit on nyt Trieen lisäämiseen ja sietä hakemiseen satunnaisella syötteellä, sekä tekstin generointiin.
Omalla vanhalla kannettavallani suorituskykytesteihin meni yhteensä noin 1,5h.

![suorituskykytestit](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/suoritusajat.png)

# Tulokset
Täydentyy myöhemmin

# Testien toistaminen
Käyttöliittymässä saa valittua suorituskykytestien ajamisen, eli testi on helposti toistettavissa.
