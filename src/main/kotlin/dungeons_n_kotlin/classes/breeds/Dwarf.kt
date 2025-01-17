package dungeons_n_kotlin.classes.breeds

import dungeons_n_kotlin.interfaces.breed.IBreed

class Dwarf : IBreed {
    override fun getStrength(): Int {
        return 1
    }

    override fun getDexterity(): Int {
        return 0
    }

    override fun getConstitution(): Int {
        return 2
    }

    override fun getIntelligence(): Int {
        return 0
    }

    override fun getWisdom(): Int {
        return 0
    }

    override fun getCharisma(): Int {
        return 0
    }

}