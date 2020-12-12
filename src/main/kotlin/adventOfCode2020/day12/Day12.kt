package adventOfCode2020.day12

import java.io.File
import kotlin.math.abs

fun readInputToList(path: String): List<Instruction> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    return lineList.map { Instruction(it[0], it.substring(1).toInt()) }
}

fun navigateShip(instructions: List<Instruction>): Int {
    var position = Pair(0, 0)
    var facingDirection = CardinalPoints.EAST
    for (instruct in instructions) {
        when (instruct.direction) {
            'N' -> position = Pair(position.first, position.second + instruct.value)
            'S' -> position = Pair(position.first, position.second - instruct.value)
            'E' -> position = Pair(position.first + instruct.value, position.second)
            'W' -> position = Pair(position.first - instruct.value, position.second)
            'L' -> {
                facingDirection = when (facingDirection) {
                    CardinalPoints.EAST -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.NORTH
                            180 -> CardinalPoints.WEST
                            else -> CardinalPoints.SOUTH
                        }
                    }
                    CardinalPoints.SOUTH -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.EAST
                            180 -> CardinalPoints.NORTH
                            else -> CardinalPoints.WEST
                        }
                    }
                    CardinalPoints.WEST -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.SOUTH
                            180 -> CardinalPoints.EAST
                            else -> CardinalPoints.NORTH
                        }
                    }
                    CardinalPoints.NORTH -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.WEST
                            180 -> CardinalPoints.SOUTH
                            else -> CardinalPoints.EAST
                        }
                    }
                }
            }
            'R' -> {
                facingDirection = when (facingDirection) {
                    CardinalPoints.EAST -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.SOUTH
                            180 -> CardinalPoints.WEST
                            else -> CardinalPoints.NORTH
                        }
                    }
                    CardinalPoints.SOUTH -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.WEST
                            180 -> CardinalPoints.NORTH
                            else -> CardinalPoints.EAST
                        }
                    }
                    CardinalPoints.WEST -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.NORTH
                            180 -> CardinalPoints.EAST
                            else -> CardinalPoints.SOUTH
                        }
                    }
                    CardinalPoints.NORTH -> {
                        when (instruct.value) {
                            90 -> CardinalPoints.EAST
                            180 -> CardinalPoints.SOUTH
                            else -> CardinalPoints.WEST
                        }
                    }
                }
            }
            'F' -> {
                position = when (facingDirection) {
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

fun navigateShipAndWaypoint(instructions: List<Instruction>): Int {
    var shipPos = Pair(0, 0)
    var wpPos = Pair(10, 1)

    for (instruction in instructions) {
        when (instruction.direction) {
            'N' -> wpPos = Pair(wpPos.first, wpPos.second + instruction.value)
            'S' -> wpPos = Pair(wpPos.first, wpPos.second - instruction.value)
            'E' -> wpPos = Pair(wpPos.first + instruction.value, wpPos.second)
            'W' -> wpPos = Pair(wpPos.first - instruction.value, wpPos.second)
            'L' -> {
                val relativeWpPos = Pair(wpPos.first - shipPos.first, wpPos.second - shipPos.second)
                wpPos = when (instruction.value) {
                    90 -> Pair(shipPos.first - relativeWpPos.second, shipPos.second + relativeWpPos.first)
                    180 -> Pair(shipPos.first - relativeWpPos.first, shipPos.second - relativeWpPos.second)
                    else -> Pair(shipPos.first + relativeWpPos.second, shipPos.second - relativeWpPos.first)
                }
            }
            'R' -> {
                val relativeWpPos = Pair(wpPos.first - shipPos.first, wpPos.second - shipPos.second)
                wpPos = when (instruction.value) {
                    90 -> Pair(shipPos.first + relativeWpPos.second, shipPos.second - relativeWpPos.first)
                    180 -> Pair(shipPos.first - relativeWpPos.first, shipPos.second - relativeWpPos.second)
                    else -> Pair(shipPos.first - relativeWpPos.second, shipPos.second + relativeWpPos.first)
                }
            }
            'F' -> {
                val relativeWpPos = Pair(wpPos.first - shipPos.first, wpPos.second - shipPos.second)
                val newShipX = shipPos.first + relativeWpPos.first * instruction.value
                val newShipY = shipPos.second + relativeWpPos.second * instruction.value
                shipPos = Pair(newShipX, newShipY)
                wpPos = Pair(shipPos.first + relativeWpPos.first, shipPos.second + relativeWpPos.second)
            }
        }
    }
    return abs(shipPos.first) + abs(shipPos.second)
}

data class Instruction(var direction: Char, var value: Int)

enum class CardinalPoints(var char: Char) {
    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W')
}