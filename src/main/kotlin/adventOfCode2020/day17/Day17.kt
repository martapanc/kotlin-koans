package adventOfCode2020.day17

import adventOfCode2020.day11.computeRound
import java.io.File

data class Coord (var x: Int, var y: Int, var z: Int)

fun readInputToMap(path: String): Map<Coord, Char> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    val inputMap = mutableMapOf<Coord, Char>()
    var x = 0
    for ((y, line) in lineList.withIndex()) {
        line.forEach { char ->
            inputMap[Coord(x, y, 0)] = char
            x++
        }
        x = 0
    }
    return inputMap
}

fun runCycles(map: Map<Coord, Char>, cycleNumber: Int) : Int {
    var finalMap = computeCycle(map)
    var finalMapString = mapToString(finalMap)
    var i = 0
    while (i < cycleNumber) {
        finalMap = computeCycle(finalMap)
        finalMapString = mapToString(finalMap)
        i++
    }
    return finalMapString.count{ it == '#'}
}

// cube active && exactly 2 or 3 of its neighbors are also active, the cube remains active. Otherwise, the cube becomes inactive.
// cube inactive && exactly 3 of its neighbors are active, the cube becomes active. Otherwise, the cube remains inactive.
fun computeCycle(inputMap: Map<Coord, Char>): Map<Coord, Char> {
    val finalMap = mutableMapOf<Coord, Char>()
    for (cell in inputMap.entries) {
        when (cell.value) {
            '#' -> {
                if (are2Or3NeighborsActive(cell.key, inputMap)) finalMap[cell.key] = '#'
                else finalMap[cell.key] = '.'
            }
            '.' -> {
                if (are3NeighborsActive(cell.key, inputMap)) finalMap[cell.key] = '#'
                else finalMap[cell.key] = '.'
            }
        }
    }
    return finalMap
}

private fun are2Or3NeighborsActive(cell: Coord, map: Map<Coord, Char>): Boolean {
    val count = getNeighbors(cell, map).count { it == '#' }
    return count == 2 || count == 3
}

private fun are3NeighborsActive(cell: Coord, map: Map<Coord, Char>): Boolean {
    return getNeighbors(cell, map).count { it == '#' } == 3
}

fun getNeighbors(cell: Coord, map: Map<Coord, Char>): List<Char> {
    val listOfNeighbors = mutableListOf<Char>()
    val listOfCombinations = mutableListOf<Coord>()
    for (z in -1..1)
        for (y in -1..1)
            (-1..1)
                .filterNot { it == 0 && y == 0 && z == 0 }
                .forEach { listOfCombinations.add(Coord(it, y, z)) }
    listOfCombinations
        .map { Coord(cell.x + it.x, cell.y + it.y, cell.z + it.z) }
        .filter { map[it] != null }
        .mapTo(listOfNeighbors) { map[it] ?: error("") }
    return listOfNeighbors
}

fun mapToString(finalMap: Map<Coord, Char>): String {
    var mapString = ""
    for (value in finalMap.values) { mapString += value }
    return mapString
}
