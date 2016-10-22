package de.alferink.bienen

class Bienenstand {

    String id
    String name
    String standort
    BigDecimal x
    BigDecimal y

    static hasMany = [
            voelker: Bienenvolk
    ]

    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }
}
