package examples.controlFlow

import examples.intro.Customer


fun main() {
    cases("Hello")
    cases("1")
    cases(2)
    cases(2L)
    cases(Customer())
    cases(MyClass())
    cases("hello")

    println(whenAssign(1))
    println(whenAssign("Hello"))
    println(whenAssign(4L))
    println(whenAssign(MyClass()))
}

fun cases(obj: Any) {
    print("${obj}: ")
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

fun whenAssign(obj: Any): Any {
    return when(obj) {
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
}

class MyClass