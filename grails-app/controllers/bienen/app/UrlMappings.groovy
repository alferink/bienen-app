package bienen.app

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/apiary"(resources: 'apiary') {}

        "/beehiveCreation"(resources: 'beehiveCreation') {}
//        "/beehiveCreation"(resources: 'beehiveCreation', excludes: ['edit', 'update']) {}
        "/beehive"(resources: 'beehive') {
            "/feeding"(resources: 'feeding')
            "/honeyharvest"(resources: 'honeyHarvest')
            "/reviews"(resources: 'review')
            "/varroachecks"(resources: 'varroaCheck')
            "/varroatreatments"(resources: 'varroaTreatment')
            "/queenInstallations"(resources: 'queenInstallation')

            "/measurements"(resources: 'beehiveMeasurement')
        }

        "/"(controller: "apiary", action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
