// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.active = true
grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.alferink.bee.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.alferink.bee.security.UserRole'
grails.plugin.springsecurity.authority.className = 'de.alferink.bee.security.Role'
grails.plugin.springsecurity.securityConfigType = "Annotation"
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/metrics', access: ['permitAll']],
        [pattern: '/console/**', access: ['ROLE_ADMIN']],
        [pattern: '/dbconsole/**', access: ['ROLE_ADMIN']],
        [pattern: '/plugins/console*/**', access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.basic.realmName = "bee-app"

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/static/**', filters: 'none'],
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/api/**', filters: 'JOINED_FILTERS,-exceptionTranslationFilter'],
        [pattern: '/**', filters: 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter']
]

//

//grails.plugin.springsecurity.password.algorithm = 'bcrypt'
//grails.plugin.springsecurity.userLookup.passwordPropertyName = 'pass'