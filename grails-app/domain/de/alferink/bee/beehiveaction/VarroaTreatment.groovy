package de.alferink.bee.beehiveaction

import de.alferink.bee.VarroaTreatmentDrug
import de.alferink.bee.VarroaTreatmentType

class VarroaTreatment extends BeehiveAction {

    VarroaTreatmentDrug medicine
    VarroaTreatmentType method
    String lotNumber
    BigDecimal quantity
    Integer infestationAfterTreatment

    static constraints = {
        lotNumber nullable: true
        infestationAfterTreatment nullable: true
    }
}
