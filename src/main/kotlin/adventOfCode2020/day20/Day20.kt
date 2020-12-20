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

fun findCornersCheckProduct(tilesList: List<JigsawTile>): Long {
    var checkProduct: Long = 1
    findTileNeighbors(tilesList).entries
        .asSequence()
        .filter { it.value.size == 2 }
        .forEach { checkProduct *= it.key }
    return checkProduct
}

fun drawFirstLine(tilesList: List<JigsawTile>) {
    val tilesAndNeighbors: Map<Int, List<NeighborEdge>> = findTileNeighbors(tilesList)
    val tileIdToTile = mutableMapOf<Int, JigsawTile>()
    for (tile in tilesList) tileIdToTile[tile.tileId] = tile

    val topLeftId = 2273
    val topLeftTile: JigsawTile = tileIdToTile[topLeftId]!!
    val rightNeighbor: NeighborEdge = (tilesAndNeighbors[topLeftId] ?: error(""))[1]

    for (tile in tilesAndNeighbors) {
        if (tile.value.contains(rightNeighbor) ||
            tile.value.contains(NeighborEdge(rightNeighbor.tileId, rightNeighbor.edge.reversed()))) {
            print(tile.key)
        }
    }

    val second = 1543
    val secondTile: JigsawTile = tileIdToTile[second]!!

    println()
}

fun createCompletePuzzle(tilesList: List<JigsawTile>) {
    val tilesAndNeighbors = findTileNeighbors(tilesList)
//    val cornerTiles = tilesAndNeighbors.filter { it.value.size == 2 }
//    val borderTiles = tilesAndNeighbors.filter { it.value.size == 3 }

    val tileIdToTile = mutableMapOf<Int, JigsawTile>()
    for (tile in tilesList) tileIdToTile[tile.tileId] = tile

//    printTile(rotateOrFlip(tileIdToTile[1549]!!, flip = 'v'))
    printTile(rotateOrFlip(tileIdToTile[2243]!!, rotate = true, deg=90, flip = 'z'))
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
    println(tileNeighborCounts)
    return tileNeighborCounts
}

private fun getListOfBorders(array: MutableMap<Coord, Char>): List<String> {
    var topHorizontal = ""
    var bottomHorizontal = ""
    var leftMost = ""
    var rightMost = ""
    (0..9).forEach { i ->
        topHorizontal += array[Coord(i, 0)]
        rightMost += array[Coord(9, i)]
        bottomHorizontal += array[Coord(i, 9)]
        leftMost += array[Coord(0, i)]
    }
    return listOf(topHorizontal, bottomHorizontal, leftMost, rightMost)
}

fun cheating(tilesList: List<JigsawTile>) {
    var borderCount = 0
    var innerCount = 0
    for (tile in tilesList) {
        val totalCount = tile.array.count{ it.value == '#'}
        var currBorderCount = 0
        for ((index, border) in tile.borderList.withIndex()) {
            currBorderCount += if (index == 1 || index == 2) {
                border.reversed().substring(0, border.length - 1).count { it == '#' }
            } else {
                border.substring(0, border.length - 1).count { it == '#' }
            }
        }
        borderCount += currBorderCount
        innerCount += (totalCount - currBorderCount)
    }
}

fun rotateOrFlip(tile: JigsawTile, rotate: Boolean = false, deg: Int = 0, flip: Char = '0'): JigsawTile {
    var array = tile.array
    var editedArray = mutableMapOf<Coord, Char>()

    if (rotate) {
        when (deg) {
            90 -> editedArray = rotate90DegClockwise(array).toMutableMap()
            180 -> {
                editedArray = rotate90DegClockwise(array).toMutableMap()
                editedArray = rotate90DegClockwise(editedArray).toMutableMap()
            }
            270 -> {
                editedArray = rotate90DegClockwise(array).toMutableMap()
                editedArray = rotate90DegClockwise(editedArray).toMutableMap()
                editedArray = rotate90DegClockwise(editedArray).toMutableMap()
            }
        }
        array = editedArray
    }

    if (flip == 'v') {
        editedArray = flipVertically(array).toMutableMap()
    }
    if (flip == 'h') {
        editedArray = flipHorizontally(array).toMutableMap()
    }

    return JigsawTile(tile.tileId, editedArray, tile.borderList)
}

private fun rotate90DegClockwise(array: Map<Coord, Char>): Map<Coord, Char> {
    val rotatedArray = mutableMapOf<Coord, Char>()
    for (coord in array.entries) {
        rotatedArray[Coord(9 - coord.key.y, coord.key.x)] = array[coord.key] ?: error("")
    }
    return rotatedArray
}

private fun flipVertically(array: Map<Coord, Char>): Map<Coord, Char> {
    val flippedArray = mutableMapOf<Coord, Char>()
    for (coord in array.entries) {
        flippedArray[Coord(9 - coord.key.x, coord.key.y)] = array[coord.key] ?: error("")
    }
    return flippedArray
}

private fun flipHorizontally(array: Map<Coord, Char>): Map<Coord, Char> {
    val flippedArray = mutableMapOf<Coord, Char>()
    for (coord in array.entries) {
        flippedArray[Coord(coord.key.x, 9 - coord.key.y)] = array[coord.key] ?: error("")
    }
    return flippedArray
}

fun printTile(tile: JigsawTile) {
    println("Tile " + tile.tileId + ":")
    for (y in 0..9) {
        for (x in 0..9) {
            print(tile.array[Coord(x, y)])
        }
        println()
    }
    println()
}

data class JigsawTile(var tileId: Int, var array: Map<Coord, Char>, var borderList: List<String>)
data class NeighborEdge(var tileId: Int, var edge: String)

data class Coord(var x: Int, var y: Int)