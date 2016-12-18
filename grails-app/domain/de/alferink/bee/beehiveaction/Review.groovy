package de.alferink.bee.beehiveaction

import de.alferink.bee.Beehive

class Review extends BeehiveAction {

    // allgemeiner Befund
    Integer egg // Ei
    Integer larva // Made
    Integer cellCapped // verdeckelt
    Integer wabensitz
    Integer sanftmut
    Integer volksstaerke

    Boolean koeniginGesehen
    Boolean weiselrichtig

    // gegeben genommen
    Integer broodChamber
    Integer honeyChamber
    Integer mittelwaende
    Integer leerwaben
    Integer brutwaben
    Integer futterwaben
    Integer drohnenwaben

    static constraints = {
        egg nullable: true, min: 0, max: 4
        larva nullable: true, min: 0, max: 4
        cellCapped nullable: true, min: 0, max: 4
        wabensitz nullable: true, min: 0, max: 4
        sanftmut nullable: true, min: 0, max: 4
        volksstaerke nullable: true, min: 0, max: 4

        koeniginGesehen nullable: true
        weiselrichtig nullable: true
        broodChamber nullable: true
        honeyChamber nullable: true
        mittelwaende nullable: true
        leerwaben nullable: true
        brutwaben nullable: true
        futterwaben nullable: true
        drohnenwaben nullable: true
    }

    @Override
    void execute() {
        super.execute()
        if(broodChamber) {
            beehive.broodChamber += broodChamber
        }
        if(honeyChamber) {
            beehive.honeyChamber += honeyChamber
        }
    }
}
