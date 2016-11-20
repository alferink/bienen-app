package de.alferink.bee

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class BeehiveMeasurement {

    enum MeasurementTyp {
        RAW,
        HOURLY,
        DAILY
    }

    String id
    Date dateCreated
    Date lastUpdated

    Date date
    Double outsideTemperature // °C
    Double insideTemperature // °C
    Double outsideHumidity // %
    Double weight // kg
    Double weightDifference // kg

    MeasurementTyp type

    static belongsTo = [beehive: Beehive]

    static transients = ['dateTime']

    static constraints = {
        weightDifference nullable: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    LocalDateTime getDateTime() {
        if(date) {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }
    }
}
