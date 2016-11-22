package de.alferink.bee.beehiveaction

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VarroaCheckController extends BeehiveActionController<VarroaCheck> {

    VarroaCheckController() {
        super(VarroaCheck)
    }
}
