package de.alferink.bee

enum VarroaTreatmentType {
    SCHWAMMTUCH_OBEN,
    TRAEUFELMETHODE

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}