package adventOfCode2020.day24

import java.io.File

fun readInputToList(path: String): List<List<HexNeighbors>> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    val inputList = mutableListOf<List<HexNeighbors>>()
    for (line in lineList) {
        val hexNeighbors = mutableListOf<HexNeighbors>()
        var i = 0
        while (i < line.length) {
            if (line[i] == 'e' || line[i] == 'w') {
                hexNeighbors.add(HexNeighbors.valueOf(line[i].toString().toUpperCase()))
                i++
            } else {
                hexNeighbors.add(HexNeighbors.valueOf(line.substring(i, i+2).toUpperCase()))
                i += 2
            }
        }
        inputList.add(hexNeighbors)
    }
    return inputList
}

enum class HexNeighbors { E, NE, SE, W, NW, SW }