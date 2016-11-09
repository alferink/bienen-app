package de.alferink.bee

enum BeeBreed {

    CARNICA,
    BUCKFAST,
    LIQUSTICA,
    MELLIFERA

    String getLabel() {
        I18nUtils.getLabel(this)
    }

    @Override
    String toString() {
        getLabel()
    }
}