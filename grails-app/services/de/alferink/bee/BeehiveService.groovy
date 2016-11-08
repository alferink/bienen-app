package de.alferink.bee

import de.alferink.bee.beehiveaction.BeehiveAction
import de.alferink.bee.beehiveaction.BeehiveCreation
import grails.transaction.Transactional

@Transactional
class BeehiveService {

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