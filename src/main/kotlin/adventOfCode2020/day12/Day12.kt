package adventOfCode2020.day12

import java.io.File
import kotlin.math.abs

fun readInputToList(path: String): List<Instruction> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    return lineList.map { Instruction(it[0], it.substring(1).toInt()) }
}

fun navigate(instructions: List<Instruction>): Int {
    var position = Pair(0, 0)
    var facingDirection = CardinalPoints.EAST
    for (instruct in instructions) {
        when(instruct.direction) {
            'N' -> position = Pair(position.first, position.second + instruct.value)
            'S' -> position = Pair(position.first, position.second - instruct.value)
            'E' -> position = Pair(position.first + instruct.value, position.second)
            'W' -> position = Pair(position.first - instruct.value, position.second)
            'L' -> {
                facingDirection = when(facingDirection) {
                    CardinalPoints.EAST -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.NORTH
                            180 -> CardinalPoints.WEST
                            else -> CardinalPoints.SOUTH
                        }
                    }
                    CardinalPoints.SOUTH -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.EAST
                            180 -> CardinalPoints.NORTH
                            else -> CardinalPoints.WEST
                        }
                    }
                    CardinalPoints.WEST -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.SOUTH
                            180 -> CardinalPoints.EAST
                            else -> CardinalPoints.NORTH
                        }
                    }
                    CardinalPoints.NORTH -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.WEST
                            180 -> CardinalPoints.SOUTH
                            else -> CardinalPoints.EAST
                        }
                    }
                }
            }
            'R' -> {
                facingDirection = when(facingDirection) {
                    CardinalPoints.EAST -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.SOUTH
                            180 -> CardinalPoints.WEST
                            else -> CardinalPoints.NORTH
                        }
                    }
                    CardinalPoints.SOUTH -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.WEST
                            180 -> CardinalPoints.NORTH
                            else -> CardinalPoints.EAST
                        }
                    }
                    CardinalPoints.WEST -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.NORTH
                            180 -> CardinalPoints.EAST
                            else -> CardinalPoints.SOUTH
                        }
                    }
                    CardinalPoints.NORTH -> {
                        when(instruct.value) {
                            90 -> CardinalPoints.EAST
                            180 -> CardinalPoints.SOUTH
                            else -> CardinalPoints.WEST
                        }
                    }
                }
            }
            'F' -> {
                position = when(facingDirection) {
                    CardinalPoints.EAST -> Pair(position.first + instruct.value, position.second)
                    CardinalPoints.SOUTH -> Pair(position.first, position.second - instruct.value)
                    CardinalPoints.WEST -> Pair(position.first - instruct.value, position.second)
                    CardinalPoints.NORTH -> Pair(position.first, position.second + instruct.value)
                }
            }
        }
    }
    return abs(position.first) + abs(position.second)
}

data class Instruction(var direction: Char, var value: Int)

enum class CardinalPoints(var char: Char) {
    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W')
}