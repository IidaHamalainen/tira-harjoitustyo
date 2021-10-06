# Testaus

# Yksikkötestit
Yksikkötesteillä on testattu Trie, Trigram ja MarkovinAlgoritmi-luokkien perustoiminnot.
Testit suoritetaan komennolla ./gradlew test. Kattavuusraportoinnissa käytän Jacocoa.
Yksikkötestien kattavuusraportti tässä: ![kattavuusraportti](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus06102021.png)(6.10.2021 tilanne). Ylin "harjoitustyo" sisältää ainoastaan main-luokan jota varten en kirjoita testejä. 

# Checkstyle
Checkstyle-raportti on nähtävissä [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle25092021.png)

Testiluokkien Checkstyle [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle_test25092021.png)

# Suorituskykytestit
Suorituskykyä testataan 10, 100, 1000, 10 000, 100 000 (ja 1000 000, jos läppäri saa testin tehtyä) -kokoisilla taulukoilla. Trieen lisääminen tehdään 100 kertaa, tekstin generointi 50 kertaa. Tuloksista tallennetaan mediaani, koska se on parempi kuin keskiarvo JIT-kääntämisen ja Javan roskien keräyksen kannalta. 
Tällä hetkellä on testi Trien muodostamiseen ja teksin generointiin, lisää testejä tulossa seuraavilla viikoilla. Alla kuva tämän hetken (6.10.2021) tuloksista.

![suorituskykytestit](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/suorituskykytestit06102021.png)

# Tulokset
Täydentyy myöhemmin

# Testien toistaminen
Käyttöliittymässä saa valittua suorituskykytestien ajamisen, eli testi on helposti toistettavissa.
