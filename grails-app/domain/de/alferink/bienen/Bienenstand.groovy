package de.alferink.bienen

class Bienenstand {

    String name
    String standort
    BigDecimal x
    BigDecimal y

    static hasMany = [
            voelker: Bienenvolk
    ]

    static constraints = {
    }
}
