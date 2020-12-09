package adventOfCode2020.day9

import java.io.File
import java.io.InputStream

fun readInputToList(path: String): List<Long> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<Long>()
    inputStream.bufferedReader().forEachLine { lineList.add(it.toLong()) }
    return lineList.toList();
}

fun findFirstNumberNotTheSumOfPreviousN(list: List<Long>, previousN: Int): Long {
    for (i in previousN until list.size - 1) {
        val number = list[i]
        val mapOfPreviousFive = mutableMapOf<Long, Long>()
        for (j in i - previousN until i) {
            if (list[j] != number - list[j] && number - list[j] >= 0) {
                mapOfPreviousFive[list[j]] = number - list[j]
            }
        }
        var pairFound = false
        for (prevNum: Long in mapOfPreviousFive.keys) {
            if (mapOfPreviousFive.containsValue(prevNum)) {
                pairFound = true
                continue
            }
        }

        if (!pairFound) {
            return number
        }
    }
    return -1
}

fun findContiguousNumberGivingN(list: List<Long>, resultFromP1: Long): Long? {
    var combinations = 4
    val p1Result: Long = resultFromP1

    while (combinations < list.size) {
        for (i in 0 until list.size - combinations) {
            var sum: Long = 0
            val numList = mutableListOf<Long>()
            for (j in i until i+combinations) {
                sum += list[j]
                numList.add(list[j])
            }
            if (sum == p1Result) {
                println(sum)
                return numList.minOrNull()!! + numList.maxOrNull()!!
            }
        }
        combinations++
    }

    return -1
}