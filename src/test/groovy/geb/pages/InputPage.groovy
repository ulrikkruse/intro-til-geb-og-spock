package geb.pages

import geb.Page

class InputPage extends Page {

    static url = "samplepagetest/"

    static content = {
        titel { $('.page_heading').find('h1').text().trim() }
        navn {  $('#g2599-name') }
        email {  $('#g2599-email') }
        erfaring { $('#g2599-experienceinyears') }
        kommentar { $('#contact-form-comment-g2599-comment') }
        indsend { $('.pushbutton-wide') }
    }

    static at = {
        titel == "Sample Page Test"
    }

    void indtastNavn(String navn) {
        this.navn = navn
    }

    void indtasEmail(String email) {
        this.email = email
    }

    void indtasKommentar(String kommentar) {
        this.kommentar = kommentar
    }

    void indsend() {
        this.indsend.click()
    }

    void vaelgErfaring(String niveau) {
        erfaring.find("option").find{ it.value() == niveau }.click()
    }
}

