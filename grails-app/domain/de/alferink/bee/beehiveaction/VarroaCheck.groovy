package de.alferink.bee.beehiveaction

class VarroaCheck extends BeehiveAction {

    Integer quantity
    Integer days

    static transients = ['quantityPerDay']

    static constraints = {
        quantity min: 0
        days min: 1
    }

    Integer getQuantityPerDay() {
        if(quantity != null && days != null) {
            return quantity / days
        }
        return null
    }
}
