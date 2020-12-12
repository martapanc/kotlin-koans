package adventOfCode2020.day12

import java.io.File
import kotlin.math.abs

fun readInputToList(path: String): List<Instruction> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    return lineList.map { Instruction(it[0], it.substring(1).toInt()) }
}

fun navigateShip(instructions: List<Instruction>): Int {
    var position = CC(0, 0)
    var facingDirection = CardinalPoints.EAST
    for (instruct in instructions) {
        when (instruct.direction) {
            'N' -> position = CC(position.x, position.y + instruct.value)
            'S' -> position = CC(position.x, position.y - instruct.value)
            'E' -> position = CC(position.x + instruct.value, position.y)
            'W' -> position = CC(position.x - instruct.value, position.y)
            'L', 'R' -> facingDirection = rotateShip(facingDirection, instruct.value, instruct.direction)
            'F' -> {
                position = when (facingDirection) {
                    CardinalPoints.EAST -> CC(position.x + instruct.value, position.y)
                    CardinalPoints.SOUTH -> CC(position.x, position.y - instruct.value)
                    CardinalPoints.WEST -> CC(position.x - instruct.value, position.y)
                    CardinalPoints.NORTH -> CC(position.x, position.y + instruct.value)
                }
            }
        }
    }
    return abs(position.x) + abs(position.y)
}

/**
 * Compute new direction of the ship after a rotation
 *
 * @param facingDirection: the initial direction of the ship (NORTH, SOUTH, EAST, WEST)
 * @param degrees: amount of rotation degrees (0, 90, 180, 270)
 * @param direction: left ('L') or right ('R')
 * @return the new facing direction of the ship
 */
fun rotateShip(facingDirection: CardinalPoints, degrees: Int, direction: Char): CardinalPoints {
    val clockwise = listOf(CardinalPoints.NORTH, CardinalPoints.EAST, CardinalPoints.SOUTH, CardinalPoints.WEST)
    var rotationAmount = listOf(0, 90, 180, 270).indexOf(degrees)
    rotationAmount = if (direction == 'R') rotationAmount else -rotationAmount
    var newDirectionIndex = clockwise.indexOf(facingDirection) + rotationAmount
    // Sadly, Kotlin doesn't support negative indices for lists...
    newDirectionIndex = if (newDirectionIndex < 0) 4 + newDirectionIndex else newDirectionIndex % 4
    return clockwise[newDirectionIndex]
}

fun navigateShipAndWaypoint(instructions: List<Instruction>): Int {
    var shipPos = CC(0, 0)
    var wpPos = CC(10, 1)

    for (instruction in instructions) {
        val relativeWpPos = CC(wpPos.x - shipPos.x, wpPos.y - shipPos.y)
        when (instruction.direction) {
            'N' -> wpPos = CC(wpPos.x, wpPos.y + instruction.value)
            'S' -> wpPos = CC(wpPos.x, wpPos.y - instruction.value)
            'E' -> wpPos = CC(wpPos.x + instruction.value, wpPos.y)
            'W' -> wpPos = CC(wpPos.x - instruction.value, wpPos.y)
            'L' -> {
                wpPos = when (instruction.value) {
                    90 -> CC(shipPos.x - relativeWpPos.y, shipPos.y + relativeWpPos.x)
                    180 -> CC(shipPos.x - relativeWpPos.x, shipPos.y - relativeWpPos.y)
                    else -> CC(shipPos.x + relativeWpPos.y, shipPos.y - relativeWpPos.x)
                }
            }
            'R' -> {
                wpPos = when (instruction.value) {
                    90 -> CC(shipPos.x + relativeWpPos.y, shipPos.y - relativeWpPos.x)
                    180 -> CC(shipPos.x - relativeWpPos.x, shipPos.y - relativeWpPos.y)
                    else -> CC(shipPos.x - relativeWpPos.y, shipPos.y + relativeWpPos.x)
                }
            }
            'F' -> {
                val newShipX = shipPos.x + relativeWpPos.x * instruction.value
                val newShipY = shipPos.y + relativeWpPos.y * instruction.value
                shipPos = CC(newShipX, newShipY)
                wpPos = CC(shipPos.x + relativeWpPos.x, shipPos.y + relativeWpPos.y)
            }
        }
    }
    return abs(shipPos.x) + abs(shipPos.y)
}

data class Instruction(var direction: Char, var value: Int)

enum class CardinalPoints { NORTH, SOUTH, EAST, WEST }

class CC(var x: Int, var y: Int)