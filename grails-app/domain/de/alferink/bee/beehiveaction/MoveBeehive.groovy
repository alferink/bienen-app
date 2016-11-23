package de.alferink.bee.beehiveaction

import de.alferink.bee.Apiary

class MoveBeehive extends BeehiveAction {

    Apiary moveTo

    static constraints = {
    }

    @Override
    void execute() {
        super.execute()
        beehive.apiary = moveTo
    }
}
