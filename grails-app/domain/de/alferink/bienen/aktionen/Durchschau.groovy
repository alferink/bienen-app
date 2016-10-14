package de.alferink.bienen.aktionen

class Durchschau extends Aktion {

    Integer volksstaerke
    Integer brut
    Integer wabensitz
    Integer sanftmut

    Integer mittelwaende
    Integer brutwaben
    Integer ausgebauteWaben
    Integer futterwaben

    Boolean drohnenbrutGeschnitten
    Boolean koeniginGesehen

    // weiselrichtigkeit?!

    String bemerkung


    static constraints = {
        bemerkung maxSize: 4000
    }
}
