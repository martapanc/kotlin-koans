package examples.scopeFunctions

// When called on an object, let executes the given block of code and returns the result of its last expression.
// The object is accessible inside the block by the reference it.

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

// Like let, run is another scoping function from the standard library.
// Basically, it does the same: executes a code block and returns its result.
// The difference is that inside run the object is accessed by this.
// This is useful when you want to call the object's methods rather than pass it as an argument.

fun getNullableLength(ns: String?) {
    println("for \"$ns\":")
    ns?.run {
        println("\tis empty? " + isEmpty())
        println("\tlength = $length")
        length
    }
}

fun main() {
    println(" is empty: $empty")
    printNonNull(null)
    printNonNull("Hello world")

    getNullableLength(null)
    getNullableLength("")
    getNullableLength("I'm a string")
}

// 1. Calls the given block on the result on the string "test".
// 2. Calls the function on "test" by the it reference.
// 3. let returns the value of this expression.
// 4. Uses safe call, so let and its code block will be executed only on non-null values.
