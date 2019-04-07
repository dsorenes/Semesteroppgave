# Semesteroppgave-Programutvikling


## Karakter blir satt etter følgende generelle mål:
• At du har arbeidet effektivt med medlemmene i din gruppe

• At dere har implementert et program i samsvar med oppgavebeskrivelsen

• At tekniske løsninger er utarbeidet med høy kvalitet

## Evaluering
Evalueringen vil være basert på punktene under. Alle punktene teller like mye i karaktersettingen.
• Oppnåelse av et fungerende program i henhold til oppgavebeskrivelsen.

• Kvalitet av klassene som representerer elementene i registeret

• Brukbarheten til det grafiske brukergrensesnittet

• Interaksjon for å legge til, modifisere, og slette elementer. Registrerte elementer skal være
grafisk opplistet og skal kunne sorteres og filtreres. Feil som ugyldig data fra bruker skal
håndteres på en naturlig måte.

• Lagring til fil fra GUI, med støtte for både csv og jobj. Bruk av Strategy designmønster for
løsning i kode. Feilhåndtering med avvik.

• Innlesning av data fra fil, med støtte for både csv og jobj. Bruk av Strategy designmønster for
løsning i kode. Feilhåndtering med egen-definerte avvik.

• Bruk av tråder for innlesning av data.

• Bruk av MVC, der back-end kode er tydelig separert fra front-end kode. Controller delen
fungerer som et bindeledd mellom front og back-end, men skal ikke ha andre ansvarsområder.

• Kvalitet og lesbarhet av kode.

• Evaluering av grupperapporten og den individuelle rapporten.

##Alternativ 2: Vikarbyrå
Det skal lages et Java-program til et vikarbyrå. Vikarbyråets oppgave er å formidle kontakt mellom
personer som ønsker seg et midlertidig engasjement og virksomheter som trenger vikarer.
Programmet som skal utvikles skal gjøre det lettere å få rett vikar til rett virksomhet.
###Registreringsdata:
<95> Arbeidsgiver
<95> Bransje
<95> Kontaktinformasjon
<95> Liste av ledige vikariater
###Ledige vikariater
<95> Offentlig eller privat sektor
<95> Arbeidssted
<95> Arbeidsgiver
<95> Jobbkategori
<95> Engasjementets varighet
<95> Arbeidstid
<95> Stillingstype
<95> Krav til kvalifikasjoner
<95> Lønnsbetingelser
<95> Arbeidsvilkår
<95> Kontaktinformasjon
<95> Stillingsbeskrivelse
<95> Liste over søkere
###Jobbsøker
<95> Kontaktinformasjon
<95> Personlig informasjon som alder
<95> Ønsket jobbkategori
<95> Utdannelse
<95> Jobberfaring
<95> Lønnskrav
<95> Referanser
###Arbeidsforhold
<95> Vikaren (tidligere jobbsøker)
<95> Vikariatet (som nå ikke er ledig lenger)


### Registrering av elementer
Bruker skal ha muligheten til å registrere individuelle elementer fra et grafisk brukergrensesnitt. Hvis
brukeren taster inn ugyldig data, skal brukeren få beskjed om dette. Det skal dermed ikke være mulig
å legge til elementer med ugyldig data.
Det grafiske brukergrensesnittet for å legge til elementer skal være designet slik at det er enkelt for
brukeren å forstå hvordan å legge til elementer. Det blir lagt noe vekt på det grafiske designet, men
ikke mye. Det vil si, det skal se bra ut, men det forventes ikke noe ekstraordinært her som animasjoner
eller andre dynamiske GUI funksjonaliteter.

### Visualisering av eksisterende elementer
De elementene som er lagt til fra bruker og lest inn fra fil skal listes opp i det grafiske
brukergrensesnittet. Det skal være mulig for bruker å kunne sortere elementene etter hver
datakolonne. I tillegg forventes det at elementer kan filtreres ut ifra filtreringsmuligheter som passer
for den spesifikke applikasjonen.
Bruker skal kunne velge et individuelt element, gjøre endringer på elementets data, og slette
elementet. Det grafiske grensesnittet skal være designet slik at det kommer tydelig frem hvilket
element som er valgt (for eksempel, ved å markere valgt rad med mørkere bakgrunn).

### Lagring av data til fil
Programmet skal støtte lagring av programmets data til fil. Videre, skal programmet støtte to typer
formater for lagring som brukeren kan velge mellom:
• Lagring til .csv fil kompatibelt som er kompatibelt med regnearksprogrammer som Microsoft
Excel. Denne filtypen lagrer data som tekst, der hvert element er skrevet ut for hver linje i
tekstfilen. Hver datakolonne separert med et tegn, som for eksempel semikolon.
• Lagring til .jobj fil med Javas støtte for serialisering. I denne filtypen lagres data i et binært
dataformat som er kompatibelt med Java sine serialiseringsklasser.
Den tekniske løsningen for filhåndtering skal implementeres med en abstrakt klasse som representerer
lagring til fil og to konkrete klasser som representerer lagring med de to filformatene beskrevet over.
Dette er et eksempel på Strategy designmønsteret, der vi har to strategier på hvordan å lagre data til
fil.
Applikasjonen skal dynamisk velge mellom de to løsningene for lagring av fil. Dette betyr at
programmet må automatisk velge hvilken av de to løsningene som skal brukes ut ifra det brukeren gir
som input til programmet. Her anbefales det at dere bruker JavaFX sin FileChooser for å la bruker velge
fil. Da kan programmet ut ifra filtypen (csv eller jobj) velge hvilken løsning som skal brukes. Se
dokumentasjonen for FileChooser for mer informasjon:
https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
De ulike eksterne feilene som kan oppstå ved lagring av data til fil må korrekt håndteres. Det betyr at
avvik skal kastes fra klassen som lagrer dataene til fil. Slike avvik skal deretter fanges i controllerklassen,
eller tilsvarende, som er koplet opp til brukergrensesnittet. Hvis feil oppstår skal controller
klassen påse at feilinformasjonen blir på en naturlig måte fremstilt til bruker.

### Innlesning av data fra fil
Programmet skal støtte muligheten for å laste data inn fra fil. Den tekniske løsningen for dette
reflekterer løsningen fra fillagringen. Det betyr, innlasting fra to filformater skal støttes: csv og jobj.
Strategy designmønsteret skal igjen brukes til å støtte innlesning fra disse to formatene. Det vil si, en
abstrakt klasse skal representere metoden for å lese data fra fil. To konkrete klasser som arver fra den
abstrakte klassen vil dermed representere innlesning fra de to forskjellige filformatene.
Applikasjonen skal automatisk velge hvilken løsning som skal brukes basert på filformatet til filen
brukeren velger. JavaFX sin FileChooser kan brukes til å velge en fil.
Håndtering av feil for innlesning av data er noe mer komplisert enn for lagring av data. Her skal
programmet ta hensyn til ugyldig formatert data. For csv, kan dette være at data er separert med
komma istedenfor semikolon. For jobj, kan data ha blitt lagret fra en utdatert versjon av dataklassen.
For slik ugyldig data, skal egendefinerte avvik kastes fra filbehandlingsklassen og håndteres av en klasse
der det er naturlig å sette opp feilmeldinger til bruker. Slike egendefinerte avvik skal ha navn som godt
beskriver typen feil (husk at avviksklasser skal avsluttes med Exception, som for eksempel
InvalidStudentException).
Funksjonaliteten for innlesning av data skal ikke «fryse» programmet. For å unngå dette, skal metoden
som leser data fra fil kjøres i en egen tråd. Bruker skal kunne navigere i brukergrensesnittet samtidig
som programmet laster inn data fra fil, men skal ikke kunne legge til elementer eller endre på
eksisterende elementer. Det anbefales at dere lager en test-fil som er såpass stor at det tar litt tid å
lese inn dataene, slik at dere får testet dette. Eventuelt kan dette emuleres ved å sette tråden for
innlesning på vent i noen sekunder (med Thread.sleep).
Innlesningsmetoden kan kjøres i en tråd opprettet med en klasse som arver fra Task i
javafx.concurrent. Klassene som implementerer filhåndteringen (den abstrakte klassen og de to
konkrete klassene for csv og jobj) skal ikke utvide Task. Det

### Bruk av OOP og Model-View-Controller
Programmeringsstilen objekt-orientert programmering skal brukes som den primære metoden for å
håndtere kompleksitet. Et sentralt mål innen programutvikling er å utvikle kode som kan vedlikeholdes
og videreutvikles. Oppgavebeskrivelsen beskriver data som skal modelleres for hvert konsept, og det
forventes at dere tar utgangspunkt i denne beskrivelsen.
Klassestrukturen skal følge Model-View-Controller (MVC) mønsteret. Se Canvas for et eksempel på
hvordan dette settes opp. Merk at det å sette opp en MVC struktur er relativt enkelt. Det som er
vanskelig, er å beholde MVC etterhvert som mer funksjonalitet blir lagt til applikasjonen. Husk at
Controller delen skal bare fungere som et bindeledd mellom GUI og back-end kode. Flytt derfor logikkkode
fra Controller-klasser til andre back-end klasser der det er mulig. Hvis dere ender opp med
komplisert eller mye kode relatert til hendelser, kan det være smart å separere dette i egne klasser
også (f.eks klasser som KeyEventHandler, RegisterElement etc.).
Videre, vurderes lesbarheten og den generelle kvaliteten til koden. Prinsipper fra Clean Code (bok, se
Canvas) antas som gode prinsipper som burde følges.
