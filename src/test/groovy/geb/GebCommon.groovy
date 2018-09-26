package geb

import geb.konstanter.Brugeroplysninger
import geb.pages.InputPage
import geb.spock.GebSpec

class GebCommon extends GebSpec {

    void indtastInput(Map options = [:]) {
        Map defaults = [navn     : Brugeroplysninger.DEFAULT_NAVN,
                        email    : Brugeroplysninger.DEFAULT_EMAIL,
                        kommentar: Brugeroplysninger.DEFAULT_KOMMENTAR
        ]
        defaults << options

        InputPage inputPage = at InputPage

        inputPage.indtastNavn(defaults.navn)
        inputPage.indtasEmail(defaults.email)
        inputPage.indtasKommentar(defaults.kommentar)
    }
}