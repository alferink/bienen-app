package de.alferink.bienen

class Bienenvolk {

    String id
    String name
    Koenigin koenigin

    Date erstellt

    // String stockart

    // String beute



    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }
}
