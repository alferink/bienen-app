// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.alferink.bienen.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.alferink.bienen.security.UserRole'
grails.plugin.springsecurity.authority.className = 'de.alferink.bienen.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/metrics', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/test/**', access: ['ROLE_ADMIN']],
        [pattern: '/console/**', access: ['permitAll']],
        [pattern: '/dbconsole/**', access: ['permitAll']],
        [pattern: '/plugins/console*/**', access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

//

grails.plugin.springsecurity.password.algorithm = 'bcrypt'

environments {
    production {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            url = System.getenv("DB_URL")
            username = System.getenv("DB_USERNAME")
            password = System.getenv("DB_PASSWORD")
        }
    }
}