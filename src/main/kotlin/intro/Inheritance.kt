package intro

open class Dog {
    open fun sayHello() {
        println("Woof woof!")
    }
}

class Yorkshire : Dog() {
    override fun sayHello() {
        println("Wif wif!")
    }
}

open class Tiger(private val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger: Tiger("Siberia")


open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India")

fun main() {
    val dog = Dog()
    val yorkshire: Dog = Yorkshire()
    dog.sayHello()
    yorkshire.sayHello()

    val indianTiger = Tiger("India")
    val siberianTiger: Tiger = SiberianTiger()
    indianTiger.sayHello()
    siberianTiger.sayHello()

    val simba = Lion("Simba", "Kenya")
    val fluffy : Lion = Asiatic("Fluffy")
    simba.sayHello()
    fluffy.sayHello()
}