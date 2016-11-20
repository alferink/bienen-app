package de.alferink.bee.beehiveaction

import de.alferink.bee.Beehive

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

class BeehiveAction {

    String id
    Date date
    String anmerkungen
    static belongsTo = [beehive: Beehive]

    static constraints = {
        anmerkungen nullable: true, maxSize: 4000, widget: 'textarea'
        beehive cascadeValidation: true
        date validator: { val, obj, errors  ->
            if (obj.beehive?.beehiveCreation?.dateTime && obj.beehive?.beehiveCreation?.dateTime?.isAfter(obj.dateTime)) {
                errors.rejectValue('date', 'actionBeforeCreation')
            }
            if (obj.beehive?.beehiveDissolved?.dateTime && obj.dateTime?.isAfter(obj.beehive?.beehiveDissolved?.dateTime)) {
                errors.rejectValue('date', 'actionAfterDissolved')
            }
        }
    }

    static transients = ['type', 'dateTime']

    static mapping = {
        id generator: 'uuid'
    }

    BeehiveActionType getType() {
        BeehiveActionType.values().find { it.actionClass == this.class }
    }

    LocalDateTime getDateTime() {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    void execute() {
        beehive?.addToActions(this)
    }
}
