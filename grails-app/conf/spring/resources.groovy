import org.flywaydb.core.Flyway

// Place your Spring DSL code here
beans = {
    if (application.config.flyway.enabled) {

        flyway(Flyway) { bean ->
            bean.initMethod = 'migrate'
            dataSource = ref('dataSource')
        }

        def sessionFactoryBeanDef = getBeanDefinition('sessionFactory')
        if (sessionFactoryBeanDef) {
            // make it depend on flyway
            sessionFactoryBeanDef.dependsOn = ['flyway'] as String[]
        }
    }
}
