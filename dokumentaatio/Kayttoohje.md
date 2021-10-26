# Käyttöohje

Lataa jar-tiedosto tira-harjoitustyo-all.jar Releaseista ja aja se komennolla `java -jar tira-harjoitustyo-all.jar`. Tällöin käytössä täytyy olla JDK11 jotta projektin ajaminen onnistuu. Vaihtoehtoisesti voit myös ladata zip-tiedoston Releaseista ja purkaa sen haluamaasi kansioon tai kloonata projektin komennolla 
```git clone https://github.com/IidaHamalainen/tira-harjoitustyo.git``` haluamassai kansiossa ja siirtyä sitten projektin sisältävään kansioon.

Ohjelman saa käynnistettyä juurikansiossa komennolla `./gradlew run` tai `./gradlew -q --console=plain run` jolloin konsoliin ei tulostu ylimääräisiä rivejä väliin.
`./gradlew build` rakentaa ohjelman ja esimerkiksi luo CheckStyle-tiedostot, kun taas `./gradlew test` suorittaa yksikkötestit.

Avautuvassa valikossa käyttäjä voi valita haluaako generoida tekstin, ajaa suorituskykytestit tai poistua ohjelmasta.
![kuva](https://github.com/IidaHamalainen/tira-harjoitustyo/blob/main/dokumentaatio/Kuvat/kayttoohje1.png)

Kun käyttäjä valitsee tekstin generoinnin, kysytään valitaanko lähdemateriaaliksi Sherlock Holmesin seikkailut vai Ylpeys ja ennakkoluulo. Tämä valinnan jälkeen kysytään kuinka pitkä teksti generoidaan. Jos syöte on alle 2 tai ei numero, palataan valintatilanteeseen. Virheellisillä syötteillä käyttäjälle ilmoitetaan virheestä ja palataan ensimmäiseen valikkoon.

Jos käyttäjä valitsee suorituskykytestit, ajaa sovellus suorituskykytestit 10 - 100000 kokoisilla taulukoilla. Suurin taulukkokoko on jätetty pois ajankäytön takia.

Ohjelman suoritus lopetetaan syöttämällä Q.
