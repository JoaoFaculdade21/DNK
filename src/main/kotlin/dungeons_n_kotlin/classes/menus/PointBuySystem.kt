package dungeons_n_kotlin.classes.menus

import dungeons_n_kotlin.classes.attributes.Attributes

class PointBuySystem {
    private val pointsPerAttribute = mapOf(
        8 to 0,
        9 to 1,
        10 to 2,
        11 to 3,
        12 to 4,
        13 to 5,
        14 to 7,
        15 to 9
    )

    val attributes = Attributes(8, 8, 8, 8, 8, 8)

    var remainingPoints = 27
        private set

    fun calculateCost(attributeValue: Int): Int {
        return pointsPerAttribute[attributeValue] ?: 0
    }

    fun canSpendPoints(currentValue: Int, newValue: Int): Boolean {
        val costDifference = calculateCost(newValue) - calculateCost(currentValue)
        return remainingPoints >= costDifference
    }

    fun spendPoints(attributeName: String, newValue: Int) {
        val currentValue = getAttributeValue(attributeName)
        if (canSpendPoints(currentValue, newValue)) {
            val costDifference = calculateCost(newValue) - calculateCost(currentValue)
            remainingPoints -= costDifference
            setAttributeValue(attributeName, newValue)
        } else {
            throw IllegalArgumentException("Not enough points to set $attributeName to $newValue.")
        }
    }

    private fun getAttributeValue(attributeName: String): Int {
        return when (attributeName.lowercase()) {
            "strength" -> attributes.strength
            "dexterity" -> attributes.dexterity
            "constitution" -> attributes.constitution
            "intelligence" -> attributes.intelligence
            "wisdom" -> attributes.wisdom
            "charisma" -> attributes.charisma
            else -> throw IllegalArgumentException("Unknown attribute: $attributeName")
        }
    }

    private fun setAttributeValue(attributeName: String, newValue: Int) {
        when (attributeName.lowercase()) {
            "strength" -> attributes.strength = newValue
            "dexterity" -> attributes.dexterity = newValue
            "constitution" -> attributes.constitution = newValue
            "intelligence" -> attributes.intelligence = newValue
            "wisdom" -> attributes.wisdom = newValue
            "charisma" -> attributes.charisma = newValue
            else -> throw IllegalArgumentException("Unknown attribute: $attributeName")
        }
    }

    fun showMenu() {
        while (remainingPoints > 0) {
            println(listAttributes())
            println("Pontos de Distribuição Restantes: $remainingPoints")
            println("Escolha o qual Atributo modificar (ou digite 'sair' para sair): ")

            val input = readLine()?.trim()?.lowercase() ?: "sair"
            if (input == "sair") break

            println("Escolha o novo valor para $input (8 a 15): ")
            val newValue = readLine()?.toIntOrNull() ?: continue

            if (newValue in 8..15) {
                try {
                    spendPoints(input, newValue)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            } else {
                println("Valor inválido. Por favor, escolha um valor entre 8 e 15.")
            }
        }

        if (remainingPoints == 0) {
            println("Pontos de Distribuição Restantes: 0")
            println("Gostaria de criar o personagem ou mudar um atributo?")
            println("1. Mudar Atributo")
            println("2. Criar")

            when (readLine()?.trim()) {
                "1" -> showMenu()
                "2" -> println("Personagem criado!")
                else -> println("Opção inválida. Personagem criado por padrão.")
            }
        }
    }

    fun listAttributes(): String {
        return """
            Strength: ${attributes.strength} (Modifier: ${attributes.strengthModifier()})
            Dexterity: ${attributes.dexterity} (Modifier: ${attributes.dexterityModifier()})
            Constitution: ${attributes.constitution} (Modifier: ${attributes.constitutionModifier()})
            Intelligence: ${attributes.intelligence} (Modifier: ${attributes.intelligenceModifier()})
            Wisdom: ${attributes.wisdom} (Modifier: ${attributes.wisdomModifier()})
            Charisma: ${attributes.charisma} (Modifier: ${attributes.charismaModifier()})
        """.trimIndent()
    }


}
