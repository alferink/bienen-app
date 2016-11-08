import de.alferink.bee.security.Role
import de.alferink.bee.security.User
import de.alferink.bee.security.UserRole
import de.alferink.bee.validation.CascadeValidationConstraint
import grails.validation.ConstrainedProperty

class BootStrap {

    def init = { servletContext ->

        ConstrainedProperty.registerNewConstraint(
                CascadeValidationConstraint.NAME,
                CascadeValidationConstraint.class
        )

        if(Role.count() == 0) {
            Role adminRole = new Role(authority: 'ROLE_ADMIN')
            adminRole.save(flush: true)

            User admin = new User(username: 'admin', password: 'a')
            admin.save(flush: true)

            UserRole.create(admin, adminRole)
        }
    }
    def destroy = {
    }
}
