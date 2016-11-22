package de.alferink.bee

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class BeehiveMeasurementController extends RestfulController<BeehiveMeasurement> {

    BeehiveMeasurementController() {
        super(BeehiveMeasurement)
    }

    @Override
    Object index(Integer max) {
        params.sort = params.sort ?: 'date'
        return super.index(max ?: 100)
    }

    @Override
    protected List<BeehiveMeasurement> listAllResources(Map params) {
        return BeehiveMeasurement.findAllByBeehiveAndType(
                Beehive.get(params.beehiveId),
                params.type ? BeehiveMeasurement.MeasurementTyp.valueOf(params.type) : BeehiveMeasurement.MeasurementTyp.DAILY,
                params)
    }
}
