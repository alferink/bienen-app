package de.alferink.bee.beehiveaction

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ReviewController extends BeehiveActionController<Review> {

    ReviewController() {
        super(Review)
    }
}
