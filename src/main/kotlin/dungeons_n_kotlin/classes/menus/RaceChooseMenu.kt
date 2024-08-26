package dungeons_n_kotlin.classes.menus

import dungeons_n_kotlin.classes.breeds.*
import dungeons_n_kotlin.interfaces.breed.IBreed
import java.util.*

class RaceChooseMenu {

    private val scanner = Scanner(System.`in`)

    fun escolherRaca(): IBreed {
        var selectedBreed: IBreed? = null

        do {
            // Exibir opções de raça
            println("Escolha uma raça ou sub-raça:")
            println("1 - Dragoborn")
            println("2 - Anão das Colinas")
            println("3 - Anão das Montanhas")
            println("4 - Elfo Drow")
            println("5 - Elfo da Floresta")
            println("6 - Elfo Alto")
            println("7 - Gnomo da Floresta")
            println("8 - Gnomo das Rochas")
            println("9 - Meio-Elfo")
            println("10 - Halfling Pé-Leve")
            println("11 - Halfling Robusto")
            println("12 - Meio-Orc")
            println("13 - Humano")
            println("14 - Tiefling")

            // Obter escolha do usuário
            print("Digite o número correspondente à raça ou sub-raça: ")
            val choice = scanner.nextInt()

            // Criar a raça com base na escolha do usuário
            selectedBreed = when (choice) {
                1 -> Dragonborn()
                2 -> DwarfHill()
                3 -> DwarfMountain()
                4 -> ElfDrow()
                5 -> ElfForest()
                6 -> ElfHigh()
                7 -> GnomeForest()
                8 -> GnomeRock()
                9 -> HalfElf()
                10 -> HalflingLightfoot()
                11 -> HalflingStout()
                12 -> HalfOrc()
                13 -> Human()
                14 -> Tiefling()
                else -> {
                    println("Escolha inválida. Por favor, tente novamente.")
                    println("")
                    null
                }
            }
        } while (selectedBreed == null)

        return selectedBreed
    }
}