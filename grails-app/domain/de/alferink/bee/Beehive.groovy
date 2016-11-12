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

    Set<BeehiveAction> actions
    BeehiveCreation beehiveCreation

    Apiary apiary

    Integer brutraum
    Integer honigraum

    static hasMany = [
            actions     : BeehiveAction,
            measurements: BeehiveMeasurement
    ]

    static transients = ['sortedActions']

    static constraints = {
        brutraum min: 1
        honigraum min: 0
        apiary nullable: true
        queen nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    List<BeehiveAction> getSortedActions(IntRange years) {
        actions.findAll {
            Calendar calendar = Calendar.getInstance()
            calendar.setTime(it.date)
            int year = calendar.get(Calendar.YEAR)
            years.containsWithinBounds(year)
        }.sort {
            it.date
        }.reverse()
    }

    String getLabel() {
        name
    }

    @Override
    String toString() {
        getLabel()
    }
}
