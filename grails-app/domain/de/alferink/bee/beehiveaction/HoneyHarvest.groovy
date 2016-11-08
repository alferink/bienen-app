package de.alferink.bee.beehiveaction

import de.alferink.bee.HoneyType

class HoneyHarvest extends BeehiveAction {

    HoneyType honeyType // sorte
    BigDecimal quantity
    BigDecimal waterContent

    static constraints = {
        quantity min: 0.0
        waterContent nullable: true, min: 0.0, max: 100.0
    }
}
