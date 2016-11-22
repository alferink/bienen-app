package bienen.app

class UrlMappings {

    static mappings = {
        def applicationMappings = { prefix ->
            "${prefix}/apiary"(resources: 'apiary') {}

            "${prefix}/beehiveCreation"(resources: 'beehiveCreation') {}
            "${prefix}/beehive"(resources: 'beehive') {
                "/feeding"(resources: 'feeding')
                "/honeyharvest"(resources: 'honeyHarvest')
                "/reviews"(resources: 'review')
                "/varroachecks"(resources: 'varroaCheck')
                "/varroatreatments"(resources: 'varroaTreatment')
                "/queenInstallations"(resources: 'queenInstallation')
                "/measurements"(resources: 'beehiveMeasurement')

                "/beehiveDissolved"(resources: 'beehiveDissolved')
            }
        }

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        applicationMappings("")
        applicationMappings("/api")

        "/"(controller: "apiary", action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
