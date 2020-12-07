package adventOfCode2020.day7

import java.io.File
import java.io.InputStream

data class BagQuantity(var quantity: Int, var color: String)

fun readInputToMap(path: String): Map<String, List<BagQuantity>> {
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

fun buildMapFromContainedBags(inputMap: Map<String, List<BagQuantity>>): Map<String, List<String>?> {
    val outputMap : MutableMap<String, MutableList<String>?> = HashMap()

    for (entry in inputMap.entries) {
        entry.value
            .filter { it.color != "None" }
            .forEach {
                if (outputMap.containsKey(it.color)) {
                    val list = outputMap[it.color]?.toMutableList()
                    list?.add(entry.key)
                    outputMap[it.color] = list?.toMutableList()
                } else {
                    val newList = mutableListOf(entry.key)
                    outputMap[it.color] = newList
                }
            }
    }
    return outputMap
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
