package examples.controlFlow

val cakes = listOf("Carrot", "Cheese", "Chocolate")

fun main() {

    for (cake in cakes) {
        println("Yummy, it's a $cake cake")
    }

    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)


    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
    for (animal in zoo) {
        println("Watch out, there's a ${animal.name} crossing")
    }
}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")


class Animal(val name: String)
class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

// Defines an iterator in a class. It must be named iterator and have the operator modifier.
// Returns the iterator that meets the following method requirements:
// next(): Animal
// hasNext(): Boolean
// Loops through animals in the zoo with the user-defined iterator.