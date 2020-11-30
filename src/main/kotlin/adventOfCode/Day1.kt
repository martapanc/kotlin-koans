package adventOfCode

import java.io.File
import java.io.InputStream

fun computeFuel(mass: Int): Int {
    return kotlin.math.floor((mass / 3).toDouble()).toInt() - 2;
}

fun computeTotalFuel(massList: List<Int>): Int {
    return massList.sumBy { computeFuel(it) };
}

fun readInputFileToList(path: String): List<Int> {
    val inputList = mutableListOf<Int>()
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    lineList.mapTo(inputList) { it.toInt() }
    return inputList;
}

fun main() {
    print(computeTotalFuel(readInputFileToList("src/main/kotlin/adventOfCode/input.txt")))
}


