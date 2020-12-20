package adventOfCode2020.day20

import java.io.File

fun readInputToList(path: String): List<JigsawTile> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    val list = mutableListOf<JigsawTile>()
    var array = mutableMapOf<Coord, Char>()
    var tileId = 0
    var y = 0
    for (line in lineList) {
        when {
            line == "" -> {
                list.add(JigsawTile(tileId, array, getListOfBorders(array)))
                array = mutableMapOf()
                y = 0
            }
            line.startsWith("Tile") -> tileId = line.replace("Tile ", "").replace(":", "").toInt()
            else -> {
                for ((index, x) in (0..9).withIndex()) {
                    array[Coord(x, y)] = line[index]
                }
                y++
            }
        }
    }
    return list
}

fun findCornersCheckproduct(tilesList: List<JigsawTile>): Long {
    var checkProduct: Long = 1
    findTileNeighbors(tilesList).entries
        .asSequence()
        .filter { it.value.size == 2 }
        .forEach { checkProduct *= it.key }
    return checkProduct
}

fun findTileNeighbors(tilesList: List<JigsawTile>): Map<Int, List<NeighborEdge>> {
    val tileNeighborCounts = mutableMapOf<Int, List<NeighborEdge>>()
    for (tile in tilesList)
        tile.borderList.forEach { border ->
            for (candidateTile in tilesList)
                if (candidateTile.tileId != tile.tileId &&
                    (candidateTile.borderList.contains(border) || candidateTile.borderList.contains(border.reversed()))
                ) {
                    val list = tileNeighborCounts[tile.tileId]
                    val neighborsList = list?.toMutableList() ?: mutableListOf()
                    neighborsList.add(NeighborEdge(candidateTile.tileId, border))
                    tileNeighborCounts[tile.tileId] = neighborsList
                }
        }
    return tileNeighborCounts
}

private fun getListOfBorders(array: MutableMap<Coord, Char>): List<String> {
    var topHorizontal = ""
    var bottomHorizontal = ""
    var leftMost = ""
    var rightMost = ""
    (0..9).forEach { i ->
        topHorizontal += array[Coord(i, 0)]
        bottomHorizontal += array[Coord(i, 9)]
        leftMost += array[Coord(0, i)]
        rightMost += array[Coord(9, i)]
    }
    return listOf(topHorizontal, bottomHorizontal, leftMost, rightMost)
}

data class JigsawTile(var tileId: Int, var array: Map<Coord, Char>, var borderList: List<String>)
data class NeighborEdge(var tileId: Int, var edge: String)

data class Coord(var x: Int, var y: Int)