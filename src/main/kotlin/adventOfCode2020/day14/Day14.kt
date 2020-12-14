package adventOfCode2020.day14

import java.io.File
import kotlin.math.pow

fun readInputToList(path: String): Map<String, List<String>> {
    val map = mutableMapOf<String, List<String>>()
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    for (line in lineList) {
        if (line.startsWith("mask")) {
            val writeList = mutableListOf<String>()
            var index = lineList.indexOf(line) + 1
            while (index < lineList.size && !lineList[index].startsWith("mask")) {
                writeList.add(lineList[index])
                index++
            }
            val mask = line.replace("mask = ", "")
            map[mask] = writeList
        }
    }
    return map
}

fun runInitProgramme(map: Map<String, List<String>>): Long {
    val memoryMap = mutableMapOf<Int, Long>()
    for (mask in map.entries) {
        for (instruction in mask.value) {
            val split = instruction.split(" = ")
            val memAddress = split[0].replace("mem[", "").replace("]", "").toInt()

            var binaryInstruction = Integer.toBinaryString(split[1].toInt())
            for (i in 0 until (mask.key.length - binaryInstruction.length)) {
                binaryInstruction = "0$binaryInstruction"
            }

            for ((index, char) in mask.key.withIndex()) {
                if (char != 'X') {
                    binaryInstruction = binaryInstruction.replaceRange(index..index, char.toString())
                }
            }
            memoryMap[memAddress] = binaryToDecimal(binaryInstruction)
        }
    }
    return memoryMap.values.sum()
}

fun binaryToDecimal(input: String): Long {
    var result = 0L
    val reversed = input.reversed()
    for ((index, bit) in reversed.withIndex()) {
        result += 2.0.pow(index.toDouble()).toLong() * bit.toString().toInt()
    }
    return result
}