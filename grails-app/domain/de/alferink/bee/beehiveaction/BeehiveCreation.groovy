package de.alferink.bee.beehiveaction

import de.alferink.bee.Apiary
import de.alferink.bee.Beehive
import de.alferink.bee.HiveType
import de.alferink.bee.Queen

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

class BeehiveCreation {

    String id

    Date created
    String name
    Boolean hasQueen
    Queen queen

    Apiary apiary

    HiveType hiveType
    Integer broodChamber = 1
    Integer honeyChamber = 0

    String notes

    static belongsTo = [beehive: Beehive]

    static transients = ['type', 'dateTime']

    static constraints = {
        notes nullable: true, maxSize: 4000, widget: 'textarea'
        queen nullable: true
        hasQueen nullable: true
        created validator: { val, obj, errors  ->
            BeehiveAction latestAction = obj.beehive.actions?.max{ it.date }
            if (latestAction && obj.dateTime.isAfter(latestAction.dateTime)) {
                errors.rejectValue('created', 'actionBeforeCreation')
            }
            if (obj.beehive?.beehiveDissolved?.dateTime && obj.dateTime.isAfter(obj.beehive?.beehiveDissolved?.dateTime)) {
                errors.rejectValue('created', 'dissolvedBeforeCreated')
            }
        }
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
        beehive.broodChamber = broodChamber
        beehive.honeyChamber = honeyChamber
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

    LocalDateTime getDateTime() {
        Instant instant = Instant.ofEpochMilli(created.getTime());
        LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
