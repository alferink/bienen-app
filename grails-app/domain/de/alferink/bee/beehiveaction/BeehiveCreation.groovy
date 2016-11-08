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
    Queen queen

    Apiary apiary

    HiveType hiveType
    Integer brutraum
    Integer honigraum

    String anmerkungen

    static belongsTo = [beehive: Beehive]

    static transients = ['type']

    static constraints = {
        anmerkungen nullable: true, maxSize: 4000, widget: 'textarea'
        beehive cascadeValidation: true
        queen nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    void execute() {
        beehive.created = created
        beehive.name = name
        beehive.queen = queen
        beehive.apiary = apiary
        beehive.hiveType = hiveType
        beehive.brutraum = brutraum
        beehive.honigraum = honigraum
    }

    BeehiveActionType getType() {
        BeehiveActionType.CREATING
    }
}
