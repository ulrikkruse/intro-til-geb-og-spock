package geb.pages

import geb.Page

class InputPage extends Page {

    static url = "samplepagetest/"

    static content = {
        titel { $('.page_heading > h1:nth-child(1)').text().trim() }
        navn {  $('#g2599-name') }
        email {  $('#g2599-email') }
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
}

