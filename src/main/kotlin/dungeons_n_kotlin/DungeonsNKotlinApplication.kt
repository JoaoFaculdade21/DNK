package dungeons_n_kotlin

import dungeons_n_kotlin.classes.entities.Character
import dungeons_n_kotlin.classes.menus.*
import dungeons_n_kotlin.interfaces.breed.IBreed
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*



fun main(args: Array<String>) {
//	runApplication<DungeonsNKotlinApplication>(*args)
	val scanner = Scanner(System.`in`)
	val raceMenu = RaceChooseMenu()
	val selectedBreed = raceMenu.escolherRaca()
	val pointBuySystem = PointBuySystem()
	pointBuySystem.showMenu()

	val character = Character(
		name = "Hero",
		breed = selectedBreed,
		attributes = pointBuySystem.attributes // Passando os atributos modificados
	)

	println(character.listAttributes())

}

//Fazer menu com duas opções criar personagem ou sair
//definir nome, raça e atributo -> criar personagens | Distribuição de 27 pontos nos atributos

