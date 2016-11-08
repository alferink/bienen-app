package de.alferink.bee

import de.alferink.bee.beehiveaction.BeehiveAction
import de.alferink.bee.beehiveaction.BeehiveCreation

import java.time.LocalDate

class Beehive {

    String id
    String name
    Queen queen

    Date created
    HiveType hiveType

    List<BeehiveAction> actions
    BeehiveCreation beehiveCreation

    Apiary apiary

    Integer brutraum
    Integer honigraum

    static hasMany = [
            actions: BeehiveAction,
            measurements: BeehiveMeasurement
    ]

    static constraints = {
        brutraum min: 1
        honigraum min: 0
        apiary nullable: true
        queen nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }
}
