package de.alferink.bee

import java.time.LocalDateTime

class BeehiveMeasurement {

    enum MeasurementTyp {
        RAW,
        HOURLY,
        DAILY
    }

    String id
    Date date
    Double outsideTemperature // °C
    Double insideTemperature // °C
    Double outsideHumidity // %
    Double weight // kg

    static belongsTo = [beehive: Beehive]

    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }
}
