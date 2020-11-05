package intro
var mutableVariable: String = "initial"
val immutable: Int = 1
val immutableWithTypeInference = 2

//var notInitialized: Int

/* Variables must be initialized */
//val d: Int
//
//if (someCondition()) {
//    d = 1
//} else {
//    d = 2
//}

var neverNull: String = "I can't be null"
var nullable: String? = "I can be null"
var inferredNonNull = "Compiler assumes I'm not null"

fun describeString(maybeString: String?): String {
    return if (maybeString != null && maybeString.isNotEmpty()) {
        "\"${maybeString}\": String of length ${maybeString.length}"
    } else {
        "\"${maybeString}\": Empty or null string"
    }
}

fun main() {
    println(describeString("Come on Nevada"))
    println(describeString(""))
    println(describeString(null))
}
