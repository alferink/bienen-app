package de.alferink.bienen.aktionen

class Aktion {

    String id
    Date datum

    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }
}
