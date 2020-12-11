package adventOfCode2020.day11

import java.io.File

fun readInputToMap(path: String): Map<Pair<Int, Int>, Char> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    val inputMap = mutableMapOf<Pair<Int, Int>, Char>()
    var x = 0
    for ((y, line) in lineList.withIndex()) {
        line.forEach { char ->
            inputMap[Pair(x, y)] = char
            x++
        }
        x = 0
    }
    return inputMap
}

// If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
// If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
fun computeRound(map: Map<Pair<Int, Int>, Char>): Map<Pair<Int, Int>, Char> {
    val finalMap = mutableMapOf<Pair<Int, Int>, Char>()
    for (entry in map.entries) {
        when (entry.value) {
            'L' -> {
                if (areAdjacentSeatsFree(entry, map))
                    finalMap[entry.key] = '#'
                else finalMap[entry.key] = 'L'
            }
            '#' -> {
                if (areFourOrMoreAdjacentSeatsOccupied(entry, map))
                    finalMap[entry.key] = 'L'
                else finalMap[entry.key] = '#'
            }
            '.' -> finalMap[entry.key] = '.'
        }
    }
    return finalMap
}

fun runRounds(map: Map<Pair<Int, Int>, Char>): Int {
    var finalMap = computeRound(map)
    var mapString = mapToString(map)
    var finalMapString = mapToString(finalMap)

    while (mapString != finalMapString) {
        mapString = finalMapString
//        printSeatMap(finalMap, 9, 9)
        finalMap = computeRound(finalMap)
        finalMapString = mapToString(finalMap)
    }
    return finalMapString.count { it == '#' }
}

private fun mapToString(finalMap: Map<Pair<Int, Int>, Char>): String {
    var mapString = ""
    for (value in finalMap.values) {
        mapString += value
    }
    return mapString
}

private fun areAdjacentSeatsFree(seat: Map.Entry<Pair<Int, Int>, Char>, map: Map<Pair<Int, Int>, Char>): Boolean {
    return getAdjacentSeatsContent(seat, map).all { it == 'L' || it == '.' }
}

private fun areFourOrMoreAdjacentSeatsOccupied(seat: Map.Entry<Pair<Int, Int>, Char>, map: Map<Pair<Int, Int>, Char>): Boolean {
    return getAdjacentSeatsContent(seat, map).count { it == '#' } >= 4
}

private fun getAdjacentSeatsContent(seat: Map.Entry<Pair<Int, Int>, Char>, map: Map<Pair<Int, Int>, Char>): MutableList<Char> {
    val adjacentSeatsContent = mutableListOf<Char>()
    val seatX = seat.key.first
    val seatY = seat.key.second
    for (y in (seatY - 1).rangeTo(seatY + 1)) {
        for (x in (seatX - 1).rangeTo(seatX + 1)) {
            if (!(seatX == x && seatY == y) && map[Pair(x, y)] != null) {
                adjacentSeatsContent.add(map[Pair(x, y)] ?: error(""))
            }
        }
    }
    return adjacentSeatsContent
}

fun printSeatMap(map: Map<Pair<Int, Int>, Char>, maxX: Int, maxY: Int) {
    for (y in 0..maxY) {
        for (x in 0..maxX) {
            print(map[Pair(x, y)])
        }
        println()
    }
    println("")
}