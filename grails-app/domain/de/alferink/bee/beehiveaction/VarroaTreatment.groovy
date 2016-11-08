package de.alferink.bee.beehiveaction

import de.alferink.bee.VarroaTreatmentDrug
import de.alferink.bee.VarroaTreatmentType

class VarroaTreatment extends BeehiveAction {

    VarroaTreatmentDrug mittel
    VarroaTreatmentType methode
    String chargenNummer
    BigDecimal menge
    Integer befallNachBehandlung

    static constraints = {
        chargenNummer nullable: true
        befallNachBehandlung nullable: true
    }
}
