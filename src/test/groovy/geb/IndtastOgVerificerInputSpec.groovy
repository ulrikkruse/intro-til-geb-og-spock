package geb

import geb.pages.InputPage
import geb.pages.OutputPage
import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll

@Stepwise
class IndtastOgVerificerInputSpec extends GebCommon {

    void "Indtast valid input"() {
        given: "man er på forsiden (input)"
        InputPage inputPage = to InputPage

        when: "man indtaser valid input"
        indtastInput()

        and: "trykker på 'Submit'"
        inputPage.indsend()

        then: "vises det indtastede input på kvitteringssiden (output)"
        at OutputPage
    }

    void "Verificer det indtasted input og returner til forsiden"() {
        given: "man er på kvitteringssiden (output)"
        OutputPage outputPage = at OutputPage

        expect: "det indtastede input vises korrekt"
        verificerOutput()

        when: "man trykker på 'Go back'"
        outputPage.returnerTilForside()

        then: "vises forsiden igen"
        InputPage inputPage = at InputPage

        expect: "og input-felterne er cleared"
        inputPage.navn == ''
    }

    @IgnoreRest
    @Unroll
    void "Verificer at man kan indtaste forskellige navne (#navn)"() {
        given: "man er på forsiden (input)"
        InputPage inputPage = to InputPage

        when: "man indtaser et navn"
        indtastInput([navn: navn])

        and: "trykker på 'Submit'"
        inputPage.indsend()

        then: "vises det indtastede input på kvitteringssiden (output)"
        at OutputPage
        verificerOutput([navn: forventetNavn])

        where:
        navn     || forventetNavn
        'Hesten' || 'Hesten'
        'Katten' || 'Katten'
        'Koen'   || 'Koen'
    }
}