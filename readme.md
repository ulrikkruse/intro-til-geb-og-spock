# Introduktion til Geb og Spock

## Beskrivelse
Dette er tænkt som en lille demo af, hvordan man kan bruge Spock og Geb til automatisk test af en given web-side, her bruges: `http://www.globalsqa.com/`.

Nogle ting i projektet er derfor alene lavet af pædagogiske årsager for at demonstrere forskellige principper, fx brugen af Where-blok, Stepwise og GebCommon :-)

## Sådan startes testen
Testen kan køres på enten Chrome eller Firefox:

    ./gradlew chromeTest
    ./gradlew firefoxTest

Eller evt. begge:

    ./gradlew test

På Windows erstattes `./gradlew` med `gradlew.bat`.

## Thanks to
Thanks to [erdi](https://github.com/erdi) for the original [example](https://github.com/geb/geb-example-gradle) this is based on!