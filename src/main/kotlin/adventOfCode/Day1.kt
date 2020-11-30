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

fun computerRecursiveTotalFuel(massList: List<Int>): Int {
    var recursiveTotalFuel = 0;

    var computedFuel = computeTotalFuel(massList)
    while (computedFuel >= 0) {
        recursiveTotalFuel += computedFuel;
        computedFuel = computeFuel(computedFuel)
    }
    return recursiveTotalFuel;
}

fun main() {
    val massList = readInputFileToList("src/main/kotlin/adventOfCode/input.txt")

    println("Part 1: " + computeTotalFuel(massList))
    println("Part 2: " + computerRecursiveTotalFuel(massList))
}


