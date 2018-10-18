# Introduktion til Geb og Spock

## Beskrivelse
Dette er tænkt som en lille demo af, hvordan man kan bruge Spock og Geb til automatisk test af en given web-side, her bruges: `http://www.globalsqa.com/`.

Nogle ting i projektet er derfor alene lavet af pædagogiske årsager for at demonstrere forskellige principper, fx brugen af Where-blok, Stepwise og GebCommon :-)

## Opsætning
Hvis du vil bruge Chrome, skal der hentes en driver, pt. bruges version 2.42: `https://chromedriver.storage.googleapis.com/index.html?path=2.42/`.
Dette kan man selv tilrette i `build.gradle`. På Mac skal driveren ligge under `Applications`.

### Frisk installation
Nedenstående er en kort beskrivelse af det, der skal installeres for at få det op at køre i Ubuntu, evt. via VirtualBox.
Grundet `https://github.com/gradle/gradle/issues/4860` bruger jeg 'kendte' versioner at Gradle etc. :-)

- IntelliJ Community Edition
- Git
- Curl (for at kunne installere sdkman)
- sdkman
- Java (8.0.181-zulu)
- Gradle (3.5.1)
- Groovy (2.4.10)

WebDriver:

    $ sudo apt-get install python-pip
    $ sudo pip install selenium


## Sådan startes testen
Testen kan køres på enten Chrome eller Firefox:

    ./gradlew chromeTest
    ./gradlew firefoxTest

Eller evt. begge:

    ./gradlew test

Enkelte test kan man køre således:

    ./gradlew firefoxTest --tests *IndtastOgVerificerInputSpec."Verificer at man kan indtaste forskellige navne (#navn)"

På Windows erstattes `./gradlew` med `gradlew.bat`.

Bemærk, at dette projekt alene er verificeret på Mac.

## Testrapporter
Projektet er sat op til at bruge Spock-reports, se `https://sites.google.com/a/athaydes.com/renato-athaydes/posts/spock-reports-greattestreportsthatyouactuallywanttoread`.
De ligger efter en kørsel under:

    ./build/spock-reports

## Thanks to
Thanks to [erdi](https://github.com/erdi) for the original [example](https://github.com/geb/geb-example-gradle) this is based on!