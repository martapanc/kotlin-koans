package adventOfCode2020.day10

import java.io.File

fun readInputToList(path: String): List<Int> {
    val lineList = mutableListOf<Int>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it.toInt()) }
    lineList.sort()
    lineList.add(0, 0)
    lineList.add(lineList[lineList.size-1] + 3)
    return lineList
}

fun findJoltsDifferences(list: List<Int>): Int {
    var diffOf1Count = 0
    var diffOf3Count = 0
    for (i in 0 until list.size - 1) {
        when (list[i+1] - list[i]) {
            1 -> diffOf1Count++
            3 -> diffOf3Count++
        }
    }
    return diffOf1Count * diffOf3Count
}