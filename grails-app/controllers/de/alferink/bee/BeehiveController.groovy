package de.alferink.bee

import de.alferink.bee.beehiveaction.BeehiveCreation
import grails.rest.RestfulController

class BeehiveController extends RestfulController<Beehive> {

    BeehiveService beehiveService

    BeehiveController() {
        super(Beehive)
    }

    @Override
    protected Beehive createResource() {
        BeehiveCreation beehiveCreation = new BeehiveCreation()
        bindData beehiveCreation, getObjectToBind()
        if (!beehiveCreation.created) {
            beehiveCreation.created = new Date()
        }
        beehiveService.createBeehive(beehiveCreation)
    }
}