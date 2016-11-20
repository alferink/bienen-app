package de.alferink.bee.beehiveaction

import de.alferink.bee.BeeRestfulController

class BeehiveDissolvedController extends BeeRestfulController<BeehiveDissolved> {

    BeehiveDissolvedController() {
        super(BeehiveDissolved)
    }

    @Override
    def show() {
        BeehiveDissolved beehiveDissolved = queryForResource(params.id)
        redirect beehiveDissolved.beehive
    }

    @Override
    protected BeehiveDissolved createResource() {
        BeehiveDissolved beehiveDissolved = super.createResource(params)
        if (!beehiveDissolved.date) {
            beehiveDissolved.date = new Date()
        }
        beehiveDissolved.execute()

        beehiveDissolved
    }

    @Override
    protected BeehiveDissolved saveResource(BeehiveDissolved beehiveDissolved) {
        return super.saveResource(beehiveDissolved)
    }

    @Override
    protected void deleteResource(BeehiveDissolved beehiveDissolved) {
        beehiveDissolved.beehive?.beehiveDissolved = null
        beehiveDissolved.beehive?.save(flush: true)
        super.deleteResource(beehiveDissolved)
    }

    @Override
    protected void redirectAfterDelete(BeehiveDissolved beehiveDissolved) {
        redirect resource: "beehive", method: "GET", id: beehiveDissolved?.beehive?.id
    }
}
