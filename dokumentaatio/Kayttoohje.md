# Käyttöohje

Lataa projekti koneellesi (täydennä: github release): Lataa jar-tiedosto Releaseista ja aja se komennolla java -jar nimi.jar

Ohjelman saa käynnistettyä juurikansiossa komennolla `./gradlew run` tai `./gradlew -q --console=plain run` jolloin konsoliin ei tulostu ylimääräisiä rivejä väliin.
`./gradlew build` rakentaa ohjelman ja esimerkiksi luo CheckStyle-tiedostot, kun taas `./gradlew test` suorittaa yksikkötestit.

Avautuvassa valikossa käyttäjä voi valita haluaako generoida tekstin, ajaa suorituskykytestit tai poistua ohjelmasta.
(kuva)

Kun käyttäjä valitsee tekstin generoinnin, kysytään valitaanko lähdemateriaaliksi Sherlock Holmesin seikkaulut vai Ylpeys ja ennakkoluulo. Tämä valinnan jälkeen kysytään kuinka pitkä teksti generoidaan. Jos syöte on alle 2 tai ei numero, palataan valintatilanteeseen. Virheellisillä syötteillä käyttäjälle ilmoitetaan virheestä ja palataan ensimmäiseen valikkoon.
