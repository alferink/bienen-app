package de.alferink.bee

import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ApiaryController extends RestfulController<Apiary> {

    ApiaryController() {
        super(Apiary)
    }

    def index(Integer max) {
        super.index(max ?: 100)
    }
}
