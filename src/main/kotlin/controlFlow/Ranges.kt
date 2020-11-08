package controlFlow

fun main() {
    for(i in 0..3) {
        print(i)
    }
    println()

    for (i in 0..10 step 2) {
        print(i)
    }
    println()

    for (i in 3 downTo 0) {
        print(i)
    }
    println()

    for (c in 'z' downTo 's' step 2) {
        print(c)
    }
    println()

    val x = 2
    if (x in 1..5) {
        print("x=${x} is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {
        print("x is not in range from 6 to 10")
    }
    println()

    for (i in 1 until 10) {       // i in [1, 10), 10 is excluded
        print(i)
    }
}