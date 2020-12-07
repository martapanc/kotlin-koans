package adventOfCode2020.day7

import java.io.File
import java.io.InputStream

fun readInputToList(path: String): Map<String, List<String>> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val inputMap = mutableMapOf<String, List<String>>()
    for (line in lineList) {
        val data = line
            .replace(".", "")
            .replace(" bags", "")
            .replace(" bag", "")
            .split(" contain ")
        val bagList: List<String> = data[1].split(", ")
        inputMap[data[0]] = bagList
    }
    return inputMap
}