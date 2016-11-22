package de.alferink.bee

import de.alferink.bee.beehiveaction.BeehiveCreation
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

import java.time.LocalDate

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class BeehiveController extends RestfulController<Beehive> {

    BeehiveService beehiveService

    BeehiveController() {
        super(Beehive)
    }

    protected List<Beehive> listAllResources(Map params) {
        Apiary apiary = Apiary.get(params.apiary)
        if(apiary) {
            Beehive.findAllByApiary(apiary)
        } else {
            Beehive.list(params)
        }
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

    def show() {
        def beehive = queryForResource(params.id)
        respond beehive, [model: [beehiveStatistics: beehiveService.createBeehiveStatistics(beehive)]]
    }

}