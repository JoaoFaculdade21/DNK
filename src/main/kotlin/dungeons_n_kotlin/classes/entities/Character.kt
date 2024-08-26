package dungeons_n_kotlin.classes.entities

import dungeons_n_kotlin.classes.attributes.Attributes
import dungeons_n_kotlin.interfaces.breed.IBreed

class Character(var name: String, var breed: IBreed, var attributes: Attributes) {
    var hitPoints: Int

    init {
        addAttributesBonus()
        hitPoints = calculateHitPoints()
    }
    private fun addAttributesBonus() {
        this.attributes.strength += this.breed.getStrength()
        this.attributes.dexterity += this.breed.getDexterity()
        this.attributes.constitution += this.breed.getConstitution()
        this.attributes.intelligence += this.breed.getIntelligence()
        this.attributes.wisdom += this.breed.getWisdom()
        this.attributes.charisma += this.breed.getCharisma()
    }

    private fun constitutionModifier(): Int {
        return (attributes.constitution - 10) / 2
    }

    private fun calculateHitPoints(): Int {
        return 10 + constitutionModifier()
    }

    fun listAttributes(): String {
        return """
            Strength: ${attributes.strength} (Modifier: ${attributes.strengthModifier()})
            Dexterity: ${attributes.dexterity} (Modifier: ${attributes.dexterityModifier()})
            Constitution: ${attributes.constitution} (Modifier: ${attributes.constitutionModifier()})
            Intelligence: ${attributes.intelligence} (Modifier: ${attributes.intelligenceModifier()})
            Wisdom: ${attributes.wisdom} (Modifier: ${attributes.wisdomModifier()})
            Charisma: ${attributes.charisma} (Modifier: ${attributes.charismaModifier()})
            Life: $hitPoints
        """.trimIndent()
    }

}