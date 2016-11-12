package de.alferink.bee

import grails.transaction.Transactional

import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.concurrent.ThreadLocalRandom

@Transactional
class BeehiveMeasurementService {

    def aggregateMeasurements(Beehive beehive) {
        List<BeehiveMeasurement> result = []

        List<BeehiveMeasurement> measurements = beehive.measurements.findAll{
            it.type == BeehiveMeasurement.MeasurementTyp.RAW
        } as List

        if(!measurements.isEmpty()) {
            LocalDateTime start = measurements.collect{ it.dateTime }.min()
            LocalDateTime end = measurements.collect{ it.dateTime }.max()

            start = start.with(LocalTime.of(start.getHour(), 0, 0, 0))
            end = end.with(LocalTime.of(end.getHour(), 0, 0, 0))

            calculateMeasurements(start, end, measurements, beehive, BeehiveMeasurement.MeasurementTyp.HOURLY)
            calculateMeasurements(start, end, measurements, beehive, BeehiveMeasurement.MeasurementTyp.DAILY)

            Beehive.withSession {
                it.flush()
            }
        }
    }

    BeehiveMeasurement generateNewMeasurement(Beehive beehive, LocalDateTime date, BeehiveMeasurement lastMeasurement) {
        BeehiveMeasurement latestMeasurement = lastMeasurement ?: BeehiveMeasurement.find("from BeehiveMeasurement m where m.beehive =:beehive order by date", [beehive: beehive])

        double outsideTemperature = latestMeasurement?.outsideTemperature ?: 20
        double insideTemperature = latestMeasurement?.insideTemperature ?: 37
        double outsideHumidity = latestMeasurement?.outsideHumidity ?: 60
        double weight = latestMeasurement?.weight ?: 40

        BeehiveMeasurement m = new BeehiveMeasurement(
                date: Date.from(date.atZone(ZoneId.systemDefault()).toInstant()),
                type: BeehiveMeasurement.MeasurementTyp.RAW,
                outsideTemperature: Math.max(-20, Math.min(35.0, outsideTemperature + ThreadLocalRandom.current().nextDouble(-2, 2))),
                insideTemperature: Math.max(20, Math.min(42.0, insideTemperature + ThreadLocalRandom.current().nextDouble(-1, 1))),
                outsideHumidity: Math.max(30, Math.min(99.0, outsideHumidity + ThreadLocalRandom.current().nextDouble(-2, 2))),
                weight: Math.max(20, Math.min(60.0, weight  + ThreadLocalRandom.current().nextDouble(-1, 1))),
                beehive: beehive
        )
        m.save()
    }

    private void calculateMeasurements(LocalDateTime start, LocalDateTime end, List<BeehiveMeasurement> measurements, Beehive beehive, BeehiveMeasurement.MeasurementTyp type) {
        LocalDateTime currentDate = start
        while (currentDate.isBefore(end)) {
            LocalDateTime from = currentDate.minusMinutes(type == BeehiveMeasurement.MeasurementTyp.HOURLY ? 30 : 720)
            LocalDateTime till = currentDate.plusMinutes(type == BeehiveMeasurement.MeasurementTyp.HOURLY ? 30 : 720)

            List<BeehiveMeasurement> measurementForDate = measurements.findAll {
                it.dateTime.isAfter(from) &&
                        it.dateTime.isBefore(till)
            }

            if (!measurementForDate.isEmpty()) {
                int count = measurementForDate.size()

                BeehiveMeasurement m = new BeehiveMeasurement(
                        type: type,
                        date: Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant()),
                        outsideTemperature: measurementForDate.sum { it.outsideTemperature } / count,
                        insideTemperature: measurementForDate.sum { it.insideTemperature } / count,
                        outsideHumidity: measurementForDate.sum { it.outsideHumidity } / count,
                        weight: measurementForDate.sum { it.weight } / count,
                        beehive: beehive
                )
                m.save()
            } else {
                println 'NICHT GEFUNEN'
            }

            currentDate = currentDate.plusHours(type == BeehiveMeasurement.MeasurementTyp.HOURLY ? 1 : 24)
        }
    }
}
