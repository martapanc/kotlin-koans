package functional

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int): Int = x + y

fun main() {
    val sumResult = calculate(4, 5, ::sum)
    val mulResult = calculate(4, 5) { a, b -> a * b }
    println("sum result $sumResult, mul result $mulResult")

    val func = operation()
    println(func(3))
}

fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x