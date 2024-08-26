package dungeons_n_kotlin.classes.attributes

class Attributes(
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int
) {

    fun getModifier(attributeValue: Int): Int {
        return (attributeValue - 10) / 2
    }

    fun strengthModifier(): Int {
        return getModifier(strength)
    }

    fun dexterityModifier(): Int {
        return getModifier(dexterity)
    }

    fun constitutionModifier(): Int {
        return getModifier(constitution)
    }

    fun intelligenceModifier(): Int {
        return getModifier(intelligence)
    }

    fun wisdomModifier(): Int {
        return getModifier(wisdom)
    }

    fun charismaModifier(): Int {
        return getModifier(charisma)
    }
}