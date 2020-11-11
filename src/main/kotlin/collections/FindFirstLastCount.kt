package collections

val words = listOf("Lets", "find", "something", "in", "collection", "somehow")

val first = words.find { it.startsWith("some") }
val last = words.findLast { it.startsWith("some") }

val nothing = words.find { it.contains("nothing") }

val numbers2 = listOf(1, -2, 3, -4, 5, -6)

val firstNum = numbers2.first()
val lastNum = numbers2.last()

val firstEven = numbers2.first { it % 2 == 0 }
val lastOdd = numbers2.last { it % 2 != 0 }

val words2 = listOf("foo", "bar", "baz", "faz")
val empty = emptyList<String>()

val firstW = empty.firstOrNull()
val lastW = empty.lastOrNull()

val firstF = words.firstOrNull { it.startsWith('f') }
val firstZ = words.firstOrNull { it.startsWith('z') }
val lastF = words.lastOrNull { it.endsWith('f') }
val lastZ = words.lastOrNull { it.endsWith('z') }

val totalCount = numbers2.count()
val totalOdd = numbers2.count { it % 2 == 1 }

fun main() {
    println(first)
    println(last)
    println(nothing)
    println(firstNum)
    println(lastNum)
    println(firstEven)
    println(lastOdd)
    println(firstW)
    println(lastW)
    println(firstF)
    println(firstZ)
    println(lastF)
    println(lastZ)
    println(totalCount)
    println(totalOdd)
}