package de.alferink.bee

class Apiary {

    String id
    String name
    String standort
    BigDecimal x
    BigDecimal y

    static hasMany = [
            beehives: Beehive
    ]

    static constraints = {
        x nullable: true
        y nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    String getLabel() {
        name
    }

    @Override
    String toString() {
        getLabel()
    }
}
