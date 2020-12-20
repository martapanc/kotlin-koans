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
            line.startsWith("Tile") -> {
                tileId = line.replace("Tile ", "").replace(":", "").toInt()
            }
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

fun findCornerTiles(tilesList: List<JigsawTile>): Long {
    val tileNeighborCounts = mutableMapOf<Int, List<Int>>()
    for (tile in tilesList) {
        for (border in tile.borderList) {
            for (candidateTile in tilesList) {
                if (candidateTile.tileId != tile.tileId) {
                    if (candidateTile.borderList.contains(border) ||
                        candidateTile.borderList.contains(border.reversed())
                    ) {
                        val list = tileNeighborCounts[tile.tileId]
                        val neighborsList = list?.toMutableList() ?: mutableListOf()
                        neighborsList.add(candidateTile.tileId)
                        tileNeighborCounts[tile.tileId] = neighborsList
                    }
                }
            }
        }
    }
    var checkProduct: Long = 1
    tileNeighborCounts.entries
        .asSequence()
        .filter { it.value.size == 2 }
        .forEach { checkProduct *= it.key }
    return checkProduct
}

private fun getListOfBorders(array: MutableMap<Coord, Char>): List<String> {
    var topHorizontal = ""
    var bottomHorizontal = ""
    var leftMost = ""
    var rightMost = ""
    for (i in 0..9) {
        topHorizontal += array[Coord(i, 0)]
        bottomHorizontal += array[Coord(i, 9)]
        leftMost += array[Coord(0, i)]
        rightMost += array[Coord(9, i)]
    }
    return listOf(topHorizontal, bottomHorizontal, leftMost, rightMost)
}

data class JigsawTile(var tileId: Int, var array: Map<Coord, Char>, var borderList: List<String>)

data class Coord(var x: Int, var y: Int)