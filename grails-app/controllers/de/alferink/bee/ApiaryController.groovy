package de.alferink.bee

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ApiaryController extends RestfulController<Apiary> {

    ApiaryController() {
        super(Apiary)
    }

    def index(Integer max) {
        super.index(max ?: 100)
    }
}
