package adventOfCode2020.day18

import java.io.File

fun readInput(path: String): List<String> {
    val list = mutableListOf<String>()
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    for (line in lineList) {
        list.add(line)
    }
    return list
}

fun runOperations(inputList: List<String>): Long {
    var totalSum = 0L
    for (operation in inputList) {
        val stack = ArrayDeque<String>()
        for (char in operation.split(" ")) {
            if (char == ")") {
                var lastElem = stack.last()
                var bracketContent = ""
                while (lastElem != "(") {
                    bracketContent = "$lastElem $bracketContent"
                    stack.removeLast()
                    lastElem = stack.last()
                }
                stack.removeLast()
                stack.add(computeOperationLeftToRight(bracketContent.trim()).toString())
            } else {
                stack.add(char)
            }
        }
        totalSum += computeOperationLeftToRight(operationStackToString(stack))
    }
    return totalSum
}

fun computeOperationLeftToRight(operation: String): Long {
    var accumulator = 0L
    val stack = ArrayDeque<String>()
    val split = operation.split(" ")
    var i = 0
    while (i < split.size) {
        val current = split[i]
        if (current == "+" || current == "*") {
            val prevNumber = stack.last().toLong()
            when (current) {
                "+" -> accumulator = prevNumber + split[i + 1].toLong()
                "*" -> accumulator = prevNumber * split[i + 1].toLong()
            }
            stack.removeLast()
            stack.add(accumulator.toString())
            i += 2
        } else {
            stack.add(current)
            i++
        }
    }
    return accumulator
}

fun operationStackToString(stack: ArrayDeque<String>): String {
    var string = ""
    stack.forEach { elem -> string += "$elem " }
    return string.trim()
}