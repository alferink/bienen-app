package de.alferink.bee.beehiveaction

import de.alferink.bee.Beehive

class Review extends BeehiveAction {

    // allgemeiner Befund
    Integer ei
    Integer made
    Integer verdeckelt
    Integer wabensitz
    Integer sanftmut
    Integer volksstaerke

    Boolean koeniginGesehen
    Boolean weiselrichtig

    // gegeben genommen
    Integer brutraum
    Integer honigraum
    Integer mittelwaende
    Integer leerwaben
    Integer brutwaben
    Integer futterwaben
    Integer drohnenwaben

    static constraints = {
        ei nullable: true, min: 0, max: 4
        made nullable: true, min: 0, max: 4
        verdeckelt nullable: true, min: 0, max: 4
        wabensitz nullable: true, min: 0, max: 4
        sanftmut nullable: true, min: 0, max: 4
        volksstaerke nullable: true, min: 0, max: 4

        koeniginGesehen nullable: true
        weiselrichtig nullable: true
        brutraum nullable: true
        honigraum nullable: true
        mittelwaende nullable: true
        leerwaben nullable: true
        brutwaben nullable: true
        futterwaben nullable: true
        drohnenwaben nullable: true
    }

    @Override
    void execute() {
        if(brutraum) {
            beehive.brutraum += brutraum
        }
        if(honigraum) {
            beehive.honigraum += honigraum
        }
    }
}
