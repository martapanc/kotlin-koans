package adventOfCode2020.day3

import java.io.File
import java.io.InputStream
import java.util.stream.IntStream.range

// 11x11 area, (3r, 1d) = 33x = repeat 3 times
// 31x323 area, (3r, 1d) = 11x

fun readInputFileToMap(path: String): Map<Pair<Int, Int>, Boolean> {
    val inputMap = mutableMapOf<Pair<Int, Int>, Boolean>()
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    var x = 0
    for ((y, line) in lineList.withIndex()) {
        line.forEach { char ->
            inputMap[Pair(x, y)] = char == '#'
            x++
        }
        x = 0
    }

    return inputMap;
}

fun countTreesInMap(inputMap: Map<Pair<Int, Int>, Boolean>): Int {
    var count = 0

    val (maxX, maxY) = inputMap.keys.unzip();

//    for (x in range(0, maxX)) {
//
//    }
    return count
}