package adventOfCode2020.day1

import java.io.File
import java.io.InputStream

fun readInputFileToMap(path: String): Map<Int, Int> {
    val inputMap = mutableMapOf<Int, Int>()
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    lineList
        .asSequence()
        .map { it.toInt() }
        .forEach { inputMap[it] = 2020 - it }

    return inputMap;
}

fun findPairAndMultiply(inputMap: Map<Int, Int>) : Int {
    var first = 0
    var second = 0

    for (input in inputMap) {
        if (inputMap.containsKey(input.value)) {
            first = input.key
            second = input.value
            break
        }
    }

    return first * second
}

fun findTripletAndMultiply(inputMap: Map<Int, Int>) : Int {
    var first = 0
    var second = 0
    var third = 0

    for (input1 in inputMap) {
        val diff = input1.value

        for (input2 in inputMap) {
            val candidateSecond = input2.key
            if (candidateSecond < diff) {
                val candidateThird = diff - candidateSecond
                if (inputMap.containsKey(candidateThird)) {
                    first = input1.key
                    second = candidateSecond
                    third = candidateThird
                    break
                }
            }
        }

        if (first != 0) {
            break
        }
    }

    return first * second * third
}
