// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.active = false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.alferink.bee.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.alferink.bee.security.UserRole'
grails.plugin.springsecurity.authority.className = 'de.alferink.bee.security.Role'
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
        [pattern: '/apiary/**', access: ['ROLE_ADMIN']],
        [pattern: '/beehive/**', access: ['ROLE_ADMIN']],
        [pattern: '/beehive/**', access: ['ROLE_ADMIN']],
        [pattern: '/beehiveMeasurement/**', access: ['ROLE_ADMIN']],
        [pattern: '/beehiveAction/**', access: ['ROLE_ADMIN']],
        [pattern: '/test/**', access: ['ROLE_ADMIN']],
        [pattern: '/console/**', access: ['ROLE_ADMIN']],
        [pattern: '/dbconsole/**', access: ['ROLE_ADMIN']],
        [pattern: '/plugins/console*/**', access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/static/**', filters: 'none'],
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

//

//grails.plugin.springsecurity.password.algorithm = 'bcrypt'
//grails.plugin.springsecurity.userLookup.passwordPropertyName = 'pass'