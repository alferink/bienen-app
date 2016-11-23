package de.alferink.bee.beehiveaction

import de.alferink.bee.I18nUtils
import grails.util.GrailsNameUtils
import grails.util.Holders
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

enum BeehiveActionType {

    CREATING(BeehiveCreation),
    FEEDING(Feeding),
    HONEY_HARVEST(HoneyHarvest),
    REVIEW(Review),
    VARROA_CHECK(VarroaCheck),
    VARROA_TREATMENT(VarroaTreatment),
    QUEEN_INSTALLATION(QueenInstallation),
    MOVE_BEEHIVE(MoveBeehive),
    BEEHIVE_DISSOLVED(BeehiveDissolved)

    final Class<? extends BeehiveAction> actionClass

    BeehiveActionType(Class<? extends BeehiveAction> actionClass) {
        this.actionClass = actionClass
    }

    String getPropertyName() {
        GrailsNameUtils.getPropertyName(actionClass)
    }

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}
