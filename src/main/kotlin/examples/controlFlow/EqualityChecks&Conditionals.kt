package examples.controlFlow

val authors = setOf("Shakespeare", "Hemingway", "Twain")
val writers = setOf("Twain", "Shakespeare", "Hemingway")

fun main() {
    println(authors == writers)
    println(authors === writers)

    println(max(2, 8))
}

//1 Returns true because it calls authors.equals(writers) and sets ignore element order.
//2 Returns false because authors and writers are distinct references.

fun max(a: Int, b: Int) = if (a > b) a else b
