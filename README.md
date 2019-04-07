# Semesteroppgave-Programutvikling


## Karakter blir satt etter f�lgende generelle m�l:
� At du har arbeidet effektivt med medlemmene i din gruppe

� At dere har implementert et program i samsvar med oppgavebeskrivelsen

� At tekniske l�sninger er utarbeidet med h�y kvalitet

## Evaluering
Evalueringen vil v�re basert p� punktene under. Alle punktene teller like mye i karaktersettingen.
� Oppn�else av et fungerende program i henhold til oppgavebeskrivelsen.

� Kvalitet av klassene som representerer elementene i registeret

� Brukbarheten til det grafiske brukergrensesnittet

� Interaksjon for � legge til, modifisere, og slette elementer. Registrerte elementer skal v�re
grafisk opplistet og skal kunne sorteres og filtreres. Feil som ugyldig data fra bruker skal
h�ndteres p� en naturlig m�te.

� Lagring til fil fra GUI, med st�tte for b�de csv og jobj. Bruk av Strategy designm�nster for
l�sning i kode. Feilh�ndtering med avvik.

� Innlesning av data fra fil, med st�tte for b�de csv og jobj. Bruk av Strategy designm�nster for
l�sning i kode. Feilh�ndtering med egen-definerte avvik.

� Bruk av tr�der for innlesning av data.

� Bruk av MVC, der back-end kode er tydelig separert fra front-end kode. Controller delen
fungerer som et bindeledd mellom front og back-end, men skal ikke ha andre ansvarsomr�der.

� Kvalitet og lesbarhet av kode.

� Evaluering av grupperapporten og den individuelle rapporten.

##Alternativ 2: Vikarbyr�
Det skal lages et Java-program til et vikarbyr�. Vikarbyr�ets oppgave er � formidle kontakt mellom
personer som �nsker seg et midlertidig engasjement og virksomheter som trenger vikarer.
Programmet som skal utvikles skal gj�re det lettere � f� rett vikar til rett virksomhet.
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
<95> L�nnsbetingelser
<95> Arbeidsvilk�r
<95> Kontaktinformasjon
<95> Stillingsbeskrivelse
<95> Liste over s�kere
###Jobbs�ker
<95> Kontaktinformasjon
<95> Personlig informasjon som alder
<95> �nsket jobbkategori
<95> Utdannelse
<95> Jobberfaring
<95> L�nnskrav
<95> Referanser
###Arbeidsforhold
<95> Vikaren (tidligere jobbs�ker)
<95> Vikariatet (som n� ikke er ledig lenger)


### Registrering av elementer
Bruker skal ha muligheten til � registrere individuelle elementer fra et grafisk brukergrensesnitt. Hvis
brukeren taster inn ugyldig data, skal brukeren f� beskjed om dette. Det skal dermed ikke v�re mulig
� legge til elementer med ugyldig data.
Det grafiske brukergrensesnittet for � legge til elementer skal v�re designet slik at det er enkelt for
brukeren � forst� hvordan � legge til elementer. Det blir lagt noe vekt p� det grafiske designet, men
ikke mye. Det vil si, det skal se bra ut, men det forventes ikke noe ekstraordin�rt her som animasjoner
eller andre dynamiske GUI funksjonaliteter.

### Visualisering av eksisterende elementer
De elementene som er lagt til fra bruker og lest inn fra fil skal listes opp i det grafiske
brukergrensesnittet. Det skal v�re mulig for bruker � kunne sortere elementene etter hver
datakolonne. I tillegg forventes det at elementer kan filtreres ut ifra filtreringsmuligheter som passer
for den spesifikke applikasjonen.
Bruker skal kunne velge et individuelt element, gj�re endringer p� elementets data, og slette
elementet. Det grafiske grensesnittet skal v�re designet slik at det kommer tydelig frem hvilket
element som er valgt (for eksempel, ved � markere valgt rad med m�rkere bakgrunn).

### Lagring av data til fil
Programmet skal st�tte lagring av programmets data til fil. Videre, skal programmet st�tte to typer
formater for lagring som brukeren kan velge mellom:
� Lagring til .csv fil kompatibelt som er kompatibelt med regnearksprogrammer som Microsoft
Excel. Denne filtypen lagrer data som tekst, der hvert element er skrevet ut for hver linje i
tekstfilen. Hver datakolonne separert med et tegn, som for eksempel semikolon.
� Lagring til .jobj fil med Javas st�tte for serialisering. I denne filtypen lagres data i et bin�rt
dataformat som er kompatibelt med Java sine serialiseringsklasser.
Den tekniske l�sningen for filh�ndtering skal implementeres med en abstrakt klasse som representerer
lagring til fil og to konkrete klasser som representerer lagring med de to filformatene beskrevet over.
Dette er et eksempel p� Strategy designm�nsteret, der vi har to strategier p� hvordan � lagre data til
fil.
Applikasjonen skal dynamisk velge mellom de to l�sningene for lagring av fil. Dette betyr at
programmet m� automatisk velge hvilken av de to l�sningene som skal brukes ut ifra det brukeren gir
som input til programmet. Her anbefales det at dere bruker JavaFX sin FileChooser for � la bruker velge
fil. Da kan programmet ut ifra filtypen (csv eller jobj) velge hvilken l�sning som skal brukes. Se
dokumentasjonen for FileChooser for mer informasjon:
https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
De ulike eksterne feilene som kan oppst� ved lagring av data til fil m� korrekt h�ndteres. Det betyr at
avvik skal kastes fra klassen som lagrer dataene til fil. Slike avvik skal deretter fanges i controllerklassen,
eller tilsvarende, som er koplet opp til brukergrensesnittet. Hvis feil oppst�r skal controller
klassen p�se at feilinformasjonen blir p� en naturlig m�te fremstilt til bruker.

### Innlesning av data fra fil
Programmet skal st�tte muligheten for � laste data inn fra fil. Den tekniske l�sningen for dette
reflekterer l�sningen fra fillagringen. Det betyr, innlasting fra to filformater skal st�ttes: csv og jobj.
Strategy designm�nsteret skal igjen brukes til � st�tte innlesning fra disse to formatene. Det vil si, en
abstrakt klasse skal representere metoden for � lese data fra fil. To konkrete klasser som arver fra den
abstrakte klassen vil dermed representere innlesning fra de to forskjellige filformatene.
Applikasjonen skal automatisk velge hvilken l�sning som skal brukes basert p� filformatet til filen
brukeren velger. JavaFX sin FileChooser kan brukes til � velge en fil.
H�ndtering av feil for innlesning av data er noe mer komplisert enn for lagring av data. Her skal
programmet ta hensyn til ugyldig formatert data. For csv, kan dette v�re at data er separert med
komma istedenfor semikolon. For jobj, kan data ha blitt lagret fra en utdatert versjon av dataklassen.
For slik ugyldig data, skal egendefinerte avvik kastes fra filbehandlingsklassen og h�ndteres av en klasse
der det er naturlig � sette opp feilmeldinger til bruker. Slike egendefinerte avvik skal ha navn som godt
beskriver typen feil (husk at avviksklasser skal avsluttes med Exception, som for eksempel
InvalidStudentException).
Funksjonaliteten for innlesning av data skal ikke �fryse� programmet. For � unng� dette, skal metoden
som leser data fra fil kj�res i en egen tr�d. Bruker skal kunne navigere i brukergrensesnittet samtidig
som programmet laster inn data fra fil, men skal ikke kunne legge til elementer eller endre p�
eksisterende elementer. Det anbefales at dere lager en test-fil som er s�pass stor at det tar litt tid �
lese inn dataene, slik at dere f�r testet dette. Eventuelt kan dette emuleres ved � sette tr�den for
innlesning p� vent i noen sekunder (med Thread.sleep).
Innlesningsmetoden kan kj�res i en tr�d opprettet med en klasse som arver fra Task i
javafx.concurrent. Klassene som implementerer filh�ndteringen (den abstrakte klassen og de to
konkrete klassene for csv og jobj) skal ikke utvide Task. Det

### Bruk av OOP og Model-View-Controller
Programmeringsstilen objekt-orientert programmering skal brukes som den prim�re metoden for �
h�ndtere kompleksitet. Et sentralt m�l innen programutvikling er � utvikle kode som kan vedlikeholdes
og videreutvikles. Oppgavebeskrivelsen beskriver data som skal modelleres for hvert konsept, og det
forventes at dere tar utgangspunkt i denne beskrivelsen.
Klassestrukturen skal f�lge Model-View-Controller (MVC) m�nsteret. Se Canvas for et eksempel p�
hvordan dette settes opp. Merk at det � sette opp en MVC struktur er relativt enkelt. Det som er
vanskelig, er � beholde MVC etterhvert som mer funksjonalitet blir lagt til applikasjonen. Husk at
Controller delen skal bare fungere som et bindeledd mellom GUI og back-end kode. Flytt derfor logikkkode
fra Controller-klasser til andre back-end klasser der det er mulig. Hvis dere ender opp med
komplisert eller mye kode relatert til hendelser, kan det v�re smart � separere dette i egne klasser
ogs� (f.eks klasser som KeyEventHandler, RegisterElement etc.).
Videre, vurderes lesbarheten og den generelle kvaliteten til koden. Prinsipper fra Clean Code (bok, se
Canvas) antas som gode prinsipper som burde f�lges.
