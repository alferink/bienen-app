package de.alferink.bee

class Apiary {

    String id
    String name

    static hasMany = [
            beehives: Beehive
    ]

    static transients = ['sortedBeehive']

    static constraints = {
    }

    static mapping = {
        id generator: 'uuid'
    }

    String getLabel() {
        name
    }

    @Override
    String toString() {
        getLabel()
    }

    List<Beehive> getSortedBeehives() {
        beehives.sort { it.name }
    }

    Beehive getPrevBeehive(Beehive beehive) {
        getBeehiveAt(getIndex(beehive) - 1)
    }

    Beehive getNextBeehive(Beehive beehive) {
        getBeehiveAt(getIndex(beehive) + 1)
    }

    Integer getIndex(Beehive beehive) {
        sortedBeehives.indexOf(beehive)
    }

    Beehive getBeehiveAt(int index) {
        if (index >= 0 && index < beehives.size()) {
            return sortedBeehives[index]
        } else {
            return null
        }
    }
}
