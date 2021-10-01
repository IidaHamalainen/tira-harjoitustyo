# Testaus

# Yksikkötestit
Yksikkötesteillä on testattu Trie, Trigram ja MarkovinAlgoritmi-luokkien perustoiminnot.
Testit suoritetaan komennolla ./gradlew test. Kattavuusraportoinnissa käytän Jacocoa.
Yksikkötestien kattavuusraportti tässä: ![kattavuusraportti](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/testikattavuus01102021.png) (perjantai 1.10.2021 tilanne). Ylin "harjoitustyo" sisältää ainoastaan main-luokan jota varten en kirjoita testejä. Suorituskykyä testaavaa Suorituskykytestit-luokkaa ei myöskään oteta mukaan tähän.

# Checkstyle
Checkstyle-raportti on nähtävissä [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle25092021.png)

Testiluokkien Checkstyle [tässä](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/checkstyle_test25092021.png)

# Suorituskykytestit
Suorituskykyä testataan 10, 100, 1000, 10 000, 100 000 ja 1000 000 -kokoisilla taulukoilla. Trieen lisääminen tehdään 100 kertaa, tekstin generointi 50 kertaa. Tuloksista tallennetaan mediaani, koska se on parempi kuin keskiarvo JIT-kääntämisen ja Javan roskien keräyksen kannalta. 
Tällä hetkellä on testi Trien muodostamiseen ja teksin generointiin, lisää testejä tulossa seuraavilla viikoilla. Alla kuva tämän hetken (1.10.2021) tuloksista.

![suorituskykytestit](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/suorituskykytestit01102021.png)

# Tulokset
Täydentyy myöhemmin

# Testien toistaminen
Tätä varten luodaan toiminnallisuus käyttöliittymään kunhan se rakentuu.
