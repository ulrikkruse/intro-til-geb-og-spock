package geb.pages

import geb.Page

class OutputPage extends Page {

    static url = "samplepagetest/?contact-form-id/"

    static content = {
        titel { $('#contact-form-2599').find('h3').text().trim() }
        gaaTilbage { $('#contact-form-2599 > h3:nth-child(1) > a:nth-child(1)') }
    }

    static at = {
        titel == "Message Sent (go back)"
    }

    void returnerTilForside() {
        gaaTilbage.click()
    }
}

