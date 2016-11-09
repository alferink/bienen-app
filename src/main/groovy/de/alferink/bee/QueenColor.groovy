package de.alferink.bee

enum QueenColor {
    WHITE,
    YELLOW,
    RED,
    GREEN,
    BLUE,
    NONE

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}