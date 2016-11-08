package de.alferink.bee.beehiveaction

import de.alferink.bee.BeehiveService
import grails.rest.RestfulController

class BeehiveCreationController extends RestfulController<BeehiveCreation> {

    BeehiveService beehiveService

    BeehiveCreationController() {
        super(BeehiveCreation)
    }

    @Override
    protected BeehiveCreation createResource() {
        BeehiveCreation beehiveCreation = super.createResource(params)
        if (!beehiveCreation.created) {
            beehiveCreation.created = new Date()
        }
        beehiveService.createBeehive(beehiveCreation)
        beehiveCreation
    }

    @Override
    def show() {
        BeehiveCreation beehiveCreation = queryForResource(params.id)
        redirect beehiveCreation.beehive
    }

    @Override
    protected BeehiveCreation updateResource(BeehiveCreation beehiveCreation) {
        beehiveService.updateBeehive(beehiveCreation.beehive)
        beehiveCreation.beehive.save flush: true
        return beehiveCreation
    }
}
