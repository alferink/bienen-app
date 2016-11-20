package de.alferink.bee

import de.alferink.bee.beehiveaction.BeehiveAction
import de.alferink.bee.beehiveaction.BeehiveActionType
import de.alferink.bee.beehiveaction.BeehiveCreation
import de.alferink.bee.beehiveaction.HoneyHarvest
import grails.transaction.Transactional

import java.time.LocalDateTime

@Transactional
class BeehiveService {

    BeehiveStatistics createBeehiveStatistics(Beehive beehive, LocalDateTime dateTime = LocalDateTime.now()) {

        List<HoneyHarvest> honeyHarvests = beehive.actions.findAll{
            it.type == BeehiveActionType.HONEY_HARVEST
        } as List

        BeehiveStatistics statistics = new BeehiveStatistics()
        statistics.beehive = beehive
        statistics.dateTime = dateTime
        statistics.honeyQuantity = honeyHarvests.findAll{ it.dateTime.year == dateTime.year }.sum{ it.quantity } ?: 0
        statistics.honeyQuantityLastYear = honeyHarvests.findAll{ it.dateTime.year == dateTime.year-1 }.sum{ it.quantity } ?: 0

        def query = BeehiveMeasurement.where{
            beehive == beehive &&
                    type == de.alferink.bee.BeehiveMeasurement.MeasurementTyp.HOURLY
        }.order('date', 'desc')
        statistics.latestMeasurement = query.find()

        statistics
    }

    Beehive updateBeehive(Beehive beehive) {
        beehive.beehiveCreation.execute()
        beehive.actions.each { action ->
            executeAction(action)
        }
        beehive
    }

    Beehive createBeehive(BeehiveCreation beehiveCreation) {
        Beehive beehive = new Beehive()
        beehiveCreation.beehive = beehive
        beehive.beehiveCreation = beehiveCreation
        beehiveCreation.execute()

        beehive
    }

    void executeAction(BeehiveAction beehiveAction) {
        beehiveAction.execute()
    }
}