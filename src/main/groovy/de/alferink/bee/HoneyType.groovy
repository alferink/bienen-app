package de.alferink.bee

enum HoneyType {

    SPRING_HONEY,
    SUMMER_HONEY

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}