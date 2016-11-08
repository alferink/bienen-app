package de.alferink.bee

class Queen {

    String id
    Integer yearOfBirth

    // String rasse
    //

    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }
}
