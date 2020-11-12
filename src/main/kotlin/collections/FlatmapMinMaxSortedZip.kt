package collections

import kotlin.math.abs

val numbers3 = listOf(1, 2, 3)

val tripled3 = numbers.flatMap { listOf(it, it, it) }
val empty3 = emptyList<Int>()

val shuffled = listOf(5, 4, 2, 1, 3, -10)
val natural = shuffled.sorted()
val inverted = shuffled.sortedBy { -it }
val descending = shuffled.sortedDescending()
val descendingBy = shuffled.sortedByDescending { abs(it)  }

val A = listOf("a", "b", "c")
val B = listOf(1, 2, 3, 4)

val resultPair = A zip B
val resultReduce = A.zip(B) {a, b -> "$a$b"}


fun main() {
    println(tripled3)
    println("Numbers: $numbers3, min = ${numbers3.min()} max = ${numbers3.max()}") // 1
    println("Empty: $empty3, min = ${empty3.min()}, max = ${empty3.max()}")        // 2

    println(natural)
    println(inverted)
    println(descending)
    println(descendingBy)

    println(resultPair)
    println(resultReduce)
}