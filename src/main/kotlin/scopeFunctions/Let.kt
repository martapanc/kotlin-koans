package scopeFunctions

fun customPrint(string: String) {
    print(string.toUpperCase())
}

val empty = "test".let {    // 1
    customPrint(it)         // 2
    it.isEmpty()            // 3
}

fun printNonNull(string: String?) {
    println("Printing \"$string\":")
    string?.let {           // 4
        print("\t")
        customPrint(it)
        println()
    }
}

fun main() {
    println(" is empty: $empty")
    printNonNull(null)
    printNonNull("Hello world")
}

// 1. Calls the given block on the result on the string "test".
// 2. Calls the function on "test" by the it reference.
// 3. let returns the value of this expression.
// 4. Uses safe call, so let and its code block will be executed only on non-null values.
