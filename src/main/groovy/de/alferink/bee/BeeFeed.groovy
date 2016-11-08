package de.alferink.bee

enum BeeFeed {
    FUTTERSIRUP,
    FUTTERTEIG,
    ZUCKER_3_2,
    ZUCKER_1_1,
    EIWEISSFUTTERTEIG

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}