package de.alferink.bee

enum VarroaTreatmentDrug {
    AMEISENSAEURE_60,
    MILCHSAEURE,
    OXALSAEURE

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}