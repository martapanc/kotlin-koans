package adventOfCode2020.day24

import adventOfCode2020.day20.Coord
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
                hexNeighbors.add(HexNeighbors.valueOf(line.substring(i, i + 2).toUpperCase()))
                i += 2
            }
        }
        inputList.add(hexNeighbors)
    }
    return inputList
}

fun findTilesAndCountBlackOnes(input: List<List<HexNeighbors>>): Int {
    val tilesMap = mutableMapOf<Coord, TileColor>()
    tilesMap[Coord(0, 0)] = TileColor.WHITE

    val deltaMap = getDeltaMap()
    for (instructionList in input) {
        var currentTile = Coord(0, 0)
        for (instruction in instructionList) {
            val delta = deltaMap[instruction]
            val nextTileCoord = Coord(currentTile.x + delta!!.x, currentTile.y + delta.y)
            if (!tilesMap.containsKey(nextTileCoord)) {
                tilesMap[nextTileCoord] = TileColor.WHITE
            }
            currentTile = nextTileCoord
        }

        if (tilesMap.containsKey(currentTile)) {
            tilesMap[currentTile] = if (tilesMap[currentTile] == TileColor.WHITE) TileColor.BLACK else TileColor.WHITE
        } else {
            tilesMap[currentTile] = TileColor.BLACK
        }
    }

    return tilesMap.values.count { it == TileColor.BLACK }
}

private fun getDeltaMap(): MutableMap<HexNeighbors, Coord> {
    val deltaMap = mutableMapOf<HexNeighbors, Coord>()
    deltaMap[HexNeighbors.NW] = Coord(0, 1)
    deltaMap[HexNeighbors.NE] = Coord(1, 1)
    deltaMap[HexNeighbors.E] = Coord(1, 0)
    deltaMap[HexNeighbors.SE] = Coord(0, -1)
    deltaMap[HexNeighbors.SW] = Coord(-1, -1)
    deltaMap[HexNeighbors.W] = Coord(-1, 0)
    return deltaMap
}

enum class HexNeighbors { E, NE, SE, W, NW, SW }

enum class TileColor { WHITE, BLACK }
