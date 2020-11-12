package examples.scopeFunctions

data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

val jake = Person()
val stringDescription = jake.apply {
    name = "Jake"
    age = 30
    about = "Android developer"
}.toString()

val otherJake = Person("Jake", 30, "iOS Developer")
    .also {
        writeCreationLog(it)
    }

fun main() {
    println(stringDescription)
    println(otherJake)
}

fun writeCreationLog(p: Person) {
    println("A new person ${p.name} was created.")
}