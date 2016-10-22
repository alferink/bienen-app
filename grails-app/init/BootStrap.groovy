import de.alferink.bienen.security.Role
import de.alferink.bienen.security.User
import de.alferink.bienen.security.UserRole

class BootStrap {

    def init = { servletContext ->

        Role adminRole = new Role(authority: 'ROLE_ADMIN')
        adminRole.save(flush: true)

        User admin = new User(username: 'admin', password: 'a')
        admin.save(flush: true)

        UserRole.create(admin, adminRole)
    }
    def destroy = {
    }
}
