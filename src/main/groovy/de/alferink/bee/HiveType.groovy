package de.alferink.bee

enum HiveType {
    SEGEBERGER_BEUTE,
    LIEBIG_BEUTE_12_DN

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}