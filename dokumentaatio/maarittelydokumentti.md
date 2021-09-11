### Opinto-ohjelmani on tietojenkäsittelytieteen kandidaatti.

### Aihe
Projektin aiheena on luoda ohjelma, joka Markovin ketjua käyttäen luo lauseita. Ohjelmalle annetaan sana, ja se arpoo seuraavan sanan. Ajatuksena on luoda parodioiva "quote generator" eli aforismi -tai mietelausegeneraattosi, joka luo oikealta vaikuttavia lyhyita lauseita jostakin aiheesta. Tarkoituksena olisi myös, että loppuun ohjelma arpoo henkilön, joka muka olisi kyseisen aforismin sanonut.

### Ohjelmointikieli
Käytän javaa projektini koodaamiseen. Javan lisäksi olen aiemmin kurssilla käyttänyt pythonia, joten uskoisin pystyväni arvioimaan sillä tehtyjä töitä. 
Muita kieliä en tunne kovin hyvin. Dokumentaatiossa käytän kielenä suomea.


### Algoritmit ja tietorakenteet

Käyttämäni algoritmit ja tietorakenteet: 
* Markovin ketju vähintään toisessa asteessa, eli ottaa huomioon kaksi edeltävää sanaa.
* Trie, johon tallennetaan sanasto.
* Lista, johon tallennetaan sanat Trie-tietorakenteen nodeissa.


### Aika- ja tilavaatimus

Trie-puussa aikavaatimus O(m), missä m on haettavan merkkijonon pituus. Tilavaatimus on O(n), missä n on sanojen määrä sanastossa. Trie-rakenteen huono puoli on sen suuri tilavaatimus.

### käyttö ja syötteet

## Lähteet
* https://en.wikipedia.org/wiki/Markov_chain
* https://en.wikipedia.org/wiki/Natural-language_generation
* https://en.wikipedia.org/wiki/Parody_generator
* https://en.wikipedia.org/wiki/Dissociated_press (kuvaus algoritmista, josta voi olla hyötyä)
* https://en.wikipedia.org/wiki/Trie
* https://www.geeksforgeeks.org/trie-insert-and-search/


