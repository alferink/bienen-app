package de.alferink.bee.beehiveaction

import de.alferink.bee.Apiary
import de.alferink.bee.Beehive
import de.alferink.bee.HiveType
import de.alferink.bee.Queen

import java.time.LocalDate

class BeehiveCreation {

    String id

    Date created
    String name
    Boolean hasQueen
    Queen queen

    Apiary apiary

    HiveType hiveType
    Integer brutraum = 1
    Integer honigraum = 0

    String anmerkungen

    static belongsTo = [beehive: Beehive]

    static transients = ['type']

    static constraints = {
        anmerkungen nullable: true, maxSize: 4000, widget: 'textarea'
        beehive cascadeValidation: true
        queen nullable: true
        hasQueen nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    void execute() {
        beehive.created = created
        beehive.name = name
        if(hasQueen != false) {
            beehive.queen = queen
        } else {
            beehive.queen = null
        }
        beehive.apiary = apiary
        beehive.hiveType = hiveType
        beehive.brutraum = brutraum
        beehive.honigraum = honigraum
    }

    BeehiveActionType getType() {
        BeehiveActionType.CREATING
    }

    boolean isInYears(IntRange years) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(created)
        int year = calendar.get(Calendar.YEAR)
        years.containsWithinBounds(year)
    }
}
