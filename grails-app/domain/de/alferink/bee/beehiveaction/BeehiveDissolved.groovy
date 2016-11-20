package de.alferink.bee.beehiveaction

import de.alferink.bee.Beehive

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class BeehiveDissolved {

    String id
    Date date
    String anmerkungen
    static belongsTo = [beehive: Beehive]

    static constraints = {
        anmerkungen nullable: true, maxSize: 4000, widget: 'textarea'
        date validator: { val, obj, errors  ->
            BeehiveAction latestAction = obj.beehive.actions?.max{ it.date }
            if (latestAction && obj.dateTime.isBefore(latestAction.dateTime)) {
                errors.rejectValue('date', 'actionAfterDissolved')
            }
            if (obj.beehive?.beehiveCreation?.dateTime && obj.dateTime.isBefore(obj.beehive?.beehiveCreation?.dateTime)) {
                errors.rejectValue('date', 'dissolvedAfterCreated')
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

    boolean isInYears(IntRange years) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(date)
        int year = calendar.get(Calendar.YEAR)
        years.containsWithinBounds(year)
    }

    void execute() {
        beehive?.beehiveDissolved = this
    }
}
