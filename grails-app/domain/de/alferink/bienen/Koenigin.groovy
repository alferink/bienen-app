package de.alferink.bienen

class Koenigin {

    String id
    Integer geburtsjahr

    // String rasse
    //

    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }
}
