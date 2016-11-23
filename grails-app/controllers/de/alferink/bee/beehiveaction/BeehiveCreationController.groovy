package de.alferink.bee.beehiveaction

import de.alferink.bee.BeeRestfulController
import de.alferink.bee.BeehiveService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class BeehiveCreationController extends BeeRestfulController<BeehiveCreation> {

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
        beehiveCreation
    }

    @Override
    def show() {
        BeehiveCreation beehiveCreation = queryForResource(params.id)
        redirect beehiveCreation.beehive
    }

    @Override
    protected BeehiveCreation saveResource(BeehiveCreation beehiveCreation) {
        beehiveService.createBeehive(beehiveCreation)
        beehiveCreation.beehive.save flush: true
        return beehiveCreation
    }

    @Override
    protected BeehiveCreation updateResource(BeehiveCreation beehiveCreation) {
        beehiveService.updateBeehive(beehiveCreation.beehive)
        beehiveCreation.beehive.save flush: true
        return beehiveCreation
    }
}
