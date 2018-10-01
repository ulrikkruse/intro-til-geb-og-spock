package geb

import geb.konstanter.Brugeroplysninger
import geb.pages.InputPage
import geb.pages.OutputPage
import geb.spock.GebSpec

class GebCommon extends GebSpec {

    void indtastInput(Map options = [:]) {
        Map defaults = [navn     : Brugeroplysninger.DEFAULT_NAVN,
                        email    : Brugeroplysninger.DEFAULT_EMAIL,
                        erfaring : Brugeroplysninger.DEFAULT_ERFARING,
                        kommentar: Brugeroplysninger.DEFAULT_KOMMENTAR
        ]
        defaults << options

        InputPage inputPage = at InputPage
        inputPage.indtastNavn(defaults.navn)
        inputPage.indtasEmail(defaults.email)
        inputPage.vaelgErfaring(defaults.erfaring)
        inputPage.indtasKommentar(defaults.kommentar)
    }

    void verificerOutput(Map options = [:]) {
        Map defaults = [navn      : Brugeroplysninger.DEFAULT_NAVN,
                        email     : Brugeroplysninger.DEFAULT_EMAIL,
                        hjemmeside: Brugeroplysninger.DEFAULT_HJEMMESIDE,
                        erfaring  : Brugeroplysninger.DEFAULT_ERFARING,
                        ekspertise: Brugeroplysninger.DEAFULT_EKSPERTISE,
                        uddannelse: Brugeroplysninger.DEAFULT_UDDANNELSE,
                        kommentar : Brugeroplysninger.DEFAULT_KOMMENTAR
        ]
        defaults << options
        OutputPage outputPage = at OutputPage
        outputPage.verificerNavn(defaults.navn)
        outputPage.verificerEmail(defaults.email)
        outputPage.verificerHjemmeside(defaults.hjemmeside)
        outputPage.verificerErfaring(defaults.erfaring)
        outputPage.verificerEkspertise(defaults.ekspertise)
        outputPage.verificerUddannelse(defaults.uddannelse)
        outputPage.verificerKommentar(defaults.kommentar)
    }
}
