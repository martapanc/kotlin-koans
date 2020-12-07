package adventOfCode2020.day7

import java.io.File
import java.io.InputStream

data class BagQuantity(var quantity: Int, var color: String)

fun readInputToList(path: String): Map<String, List<BagQuantity>> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val inputMap = mutableMapOf<String, List<BagQuantity>>()
    for (line in lineList) {
        val data = line
            .replace(".", "")
            .replace(" bags", "")
            .replace(" bag", "")
            .split(" contain ")
        val bagListAsStrings: List<String> = data[1].split(", ")
        val bagList = mutableListOf<BagQuantity>()
        for (bagString in bagListAsStrings) {
            if (bagString == "no other") {
                bagList.add(BagQuantity(0, "None"))
            } else {
                val bagAndQuantity = bagString.split(Regex("\\s"), 2)
                bagList.add(BagQuantity(bagAndQuantity[0].toInt(), bagAndQuantity[1]))
            }
        }
        inputMap[data[0]] = bagList
    }
    return inputMap
}

fun findContainingBags(bagMap: Map<String, List<BagQuantity>>): List<String> {
    val bagList = mutableListOf<String>()
    val tempBagList = mutableListOf<String>()

    for (bagEntry in bagMap.entries) {
        val entryValue: List<BagQuantity> = bagEntry.value
        for (bag in entryValue) {
            if (bag.color == "shiny gold") {
                bagList.add(bagEntry.key)
            }
        }
    }

    for (bag in bagList) {
        for (bagEntry in bagMap.entries) {
            val entryValue: List<BagQuantity> = bagEntry.value
            for (bagVal in entryValue) {
                if (bagVal.color == bag) {
                    bagList.add(bagEntry.key)
                }
            }
        }
    }

    return bagList
}
