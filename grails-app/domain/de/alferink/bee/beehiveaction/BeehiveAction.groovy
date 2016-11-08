package de.alferink.bee.beehiveaction

import de.alferink.bee.Beehive

import java.time.LocalDate

class BeehiveAction {

    String id
    Date date
    String anmerkungen
    static belongsTo = [beehive: Beehive]

    static constraints = {
        anmerkungen nullable: true, maxSize: 4000, widget: 'textarea'
        beehive cascadeValidation: true
    }

    static transients = ['type']

    static mapping = {
        id generator: 'uuid'
    }

    BeehiveActionType getType() {
        BeehiveActionType.values().find { it.actionClass == this.class }
    }

    void execute() {
    }
}
