package collections

val numbers = listOf(1, -2, 3, -4, 5, -6)

val positives = numbers.filter { x -> x > 0 }
val negatives = numbers.filter { it < 0 }

val doubled = numbers.map { x -> x * 2 }
val tripled = numbers.map { it * 3 }

val anyNegative = numbers.any { it < 0 }
val anyGT6 = numbers.any { it > 6 }

val allEven = numbers.all { x -> x % 2 == 0 }
val allLT6 = numbers.all { it < 6 }

val allOdd = numbers.none { it % 2 == 1 }
val allLT5 = numbers.none { it > 5 }


fun main() {
    println(positives)
    println(negatives)
    println(doubled)
    println(tripled)
    println(anyNegative)
    println(anyGT6)
    println(allEven)
    println(allLT6)
    println(allOdd)
    println(allLT5)
}