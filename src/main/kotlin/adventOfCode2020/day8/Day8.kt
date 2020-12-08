package adventOfCode2020.day8

import java.io.File
import java.io.InputStream

fun readInputToMap(path: String): Map<Int, GameData> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val inputMap = mutableMapOf<Int, GameData>()
    for ((i, line) in lineList.withIndex()) {
       val data = line.split(" ")
        inputMap[i] = GameData(data[0], data[1].toInt(), false)
    }
    return inputMap
}

fun playTheGame(inputMap: Map<Int, GameData>): GameOver {
    var accumulator = 0
    var index = 0
    while (true) {
        val current: GameData? = inputMap[index]
        if (current == null || current.executed) {
            break
        }
        when (current.command) {
            "nop" -> {
                index++
            }
            "acc" -> {
                accumulator += current.amount
                index++
            }
            "jmp" -> {
                index += current.amount
            }
            else -> println("error")
        }
        current.executed = true
    }

    return GameOver(accumulator, index >= inputMap.size)
}

data class GameData(var command: String, var amount: Int, var executed: Boolean) {}

data class GameOver(var accumulator: Int, var terminated: Boolean)