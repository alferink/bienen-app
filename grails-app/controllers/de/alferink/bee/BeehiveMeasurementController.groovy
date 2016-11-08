package de.alferink.bee

import grails.rest.RestfulController

class BeehiveMeasurementController extends RestfulController<BeehiveMeasurement> {

    BeehiveMeasurementController() {
        super(BeehiveMeasurement)
    }

    @Override
    Object index(Integer max) {
        params.sort = params.sort ?: 'date'
        return super.index(max)
    }
}
