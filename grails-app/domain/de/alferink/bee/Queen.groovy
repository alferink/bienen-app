package de.alferink.bee

class Queen {

    String id

    Integer year
    QueenColor color
    BeeBreed breed
    String zeichen
    String belegstelle

    static constraints = {
        year nullable: true
        color nullable: true
        breed nullable: true
        zeichen nullable: true
        belegstelle nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    String getLabel() {
        "$breed $year" + (zeichen ? "($zeichen)" : '')
    }

    @Override
    String toString() {
        label
    }
}
