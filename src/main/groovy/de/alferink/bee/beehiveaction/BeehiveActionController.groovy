package de.alferink.bee.beehiveaction

import de.alferink.bee.BeeRestfulController
import de.alferink.bee.Beehive
import de.alferink.bee.BeehiveService
import grails.artefact.Artefact
import grails.rest.RestfulController

@Artefact("Controller")
class BeehiveActionController<T extends BeehiveAction> extends BeeRestfulController<T> {

    BeehiveService beehiveService

    BeehiveActionController(Class<T> resource) {
        super(resource)
    }

    @Override
    protected T createResource() {
        T beehiveAction = super.createResource()
        if (!beehiveAction.date) {
            beehiveAction.date = new Date()
        }
        if (!beehiveAction.beehive) {
            beehiveAction.beehive = Beehive.get(params.beehiveId)
        }
        beehiveService.executeAction(beehiveAction)
        beehiveAction
    }

    @Override
    def show() {
        T beehiveAction = queryForResource(params.id)
        redirect beehiveAction.beehive
    }

    @Override
    protected T updateResource(T resource) {
        beehiveService.updateBeehive(resource.beehive)
        resource.beehive.save flush: true
        return resource
    }

    @Override
    protected void redirectAfterDelete(T beehiveAction) {
        redirect resource: "beehive", method: "GET", id: beehiveAction?.beehive?.id
    }
}