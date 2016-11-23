package de.alferink.bee.beehiveaction

import de.alferink.bee.BeeRestfulController
import de.alferink.bee.Beehive
import de.alferink.bee.BeehiveService
import grails.artefact.Artefact

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
        beehiveAction
    }

    @Override
    protected T saveResource(T beehiveAction) {
        beehiveService.updateBeehive(beehiveAction.beehive)
        beehiveAction.beehive.save flush: true
        beehiveAction.save flush: true
    }

    @Override
    def show() {
        T beehiveAction = queryForResource(params.id)
        redirect beehiveAction.beehive
    }

    @Override
    protected T updateResource(T beehiveAction) {
        beehiveService.updateBeehive(beehiveAction.beehive)
        beehiveAction.beehive.save flush: true
        beehiveAction.save flush: true
    }

    @Override
    protected void redirectAfterDelete(T beehiveAction) {
        redirect resource: "beehive", method: "GET", id: beehiveAction?.beehive?.id
    }
}