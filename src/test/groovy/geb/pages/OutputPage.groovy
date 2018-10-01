package geb.pages

import geb.Page

class OutputPage extends Page {

    static url = "samplepagetest/?contact-form-id/"

    static content = {
        titel { $('#contact-form-2599').find('h3').text().trim() }
        navn { $('.contact-form-submission').find('p', 0) }
        email { $('.contact-form-submission').find('p', 1) }
        hjemmeside { $('.contact-form-submission').find('p', 2) }
        erfaring { $('.contact-form-submission').find('p', 3) }
        ekspertise { $('.contact-form-submission').find('p', 4) }
        uddannelse { $('.contact-form-submission').find('p', 5) }
        kommentar { $('.contact-form-submission').find('p', 6) }
        gaaTilbage { $('#contact-form-2599').find('a') }
    }

    static at = {
        titel == "Message Sent (go back)"
    }

    void returnerTilForside() {
        gaaTilbage.click()
    }

    void verificerNavn(String navn) {
        assert this.navn.text() == 'Name: ' + navn
    }

    void verificerEmail(String email) {
        assert this.email.text() == 'Email: ' + email
    }

    void verificerHjemmeside(String hjemmeside) {
        if (hjemmeside == '') {
            assert this.hjemmeside.text() == 'Website:' + hjemmeside
        } else {
            assert this.hjemmeside.text() == 'Website: ' + hjemmeside
        }
    }

    void verificerErfaring(String erfaring) {
        assert this.erfaring.text() == 'Experience (In Years): ' + erfaring
    }

    void verificerEkspertise(String ekspertise) {
        if (ekspertise == '') {
            assert this.ekspertise.text() == 'Expertise ::' + ekspertise
        } else {
            assert this.ekspertise.text() == 'Expertise :: ' + ekspertise
        }
    }

    void verificerUddannelse(String uddannelse) {
        if (uddannelse == '') {
            assert this.uddannelse.text() == 'Education:' + uddannelse
        } else {
            assert this.uddannelse.text() == 'Education: ' + uddannelse
        }
    }

    void verificerKommentar(String kommentar) {
        assert this.kommentar.text() == 'Comment: ' + kommentar
    }
}

