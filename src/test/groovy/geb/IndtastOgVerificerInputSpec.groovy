package geb

import geb.pages.InputPage
import geb.pages.OutputPage

class IndtastOgVerificerInputSpec extends GebCommon {

    void "Indtast valid (obligatorisk) input og returner til forsiden"() {
        given: "man er på forsiden (input)"
        InputPage inputPage = to InputPage

        when: "man indtaser valid input"
        indtastInput()

        and: "trykker på 'Submit'"
        inputPage.indsend()

        then: "vises det indtastede input på kvitteringssiden (output)"
        OutputPage outputPage = at OutputPage

        when: "man trykker på 'Go back'"
        outputPage.returnerTilForside()

        then: "vises forsiden igen"
        at inputPage

        expect: "og input-felterne er cleared"
        inputPage.navn == ''
    }
}