package examples.intro

fun main() {
    defaultFunctions()
    infixFunctions()
    operatorFunctions()
    varargFunctions()
}

private fun defaultFunctions() {
    printMessage("Hello world!")
    printMessageWithPrefix("Hiya!")
    printMessageWithPrefix("Hiya!", "Log")
    printMessageWithPrefix(message = "Booyakasha", prefix = "LogInfo")
    println(sum(15, 18))
    printMessageWithPrefix(multiply(2, 9).toString(), "Math")
}

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y

// https://kotlinlang.org/docs/reference/functions.html#infix-notation
fun infixFunctions() {
    infix fun Int.times(str: String) = str.repeat(this)      //1
    println(2 times "Bye ")                                     //2

    val pair = "Las Vegas" to "Reno"                            //3
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)    //4
    val pair2 = "Atlanta" onto "Georgia"
    println(pair2)

    val joe = Person("Joe")                               //5
    val alex = Person("Alexandria")
    joe likes alex
    alex likes joe
}

class Person(val name: String) {
    private val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {                             //6
        likedPeople.add(other)
        println(likedPeople)
    }
}

/*
* 1. Defines an infix extension function on Int.
* 2. Calls the infix function.
* 3. Creates a Pair by calling the infix function to from the standard library.
* 4. Here's your own implementation of to creatively called onto.
* 5. Infix notation also works on members functions (methods).
* 6. The containing class becomes the first parameter.
*/


// https://kotlinlang.org/docs/reference/operator-overloading.html
fun operatorFunctions() {
    operator fun Int.times(string: String) = string.repeat(this)
    println(3 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    val string = "STOP THE COUNT!"
    println(string[0..14])
}


// https://kotlinlang.org/docs/reference/functions.html#variable-number-of-arguments-varargs
fun varargFunctions() {
    printAll("Make", "America", "Great", "Again", "Again")
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )
    log("Bi", "den")
}

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    printAll(*entries)
}
