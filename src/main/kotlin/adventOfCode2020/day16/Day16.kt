package adventOfCode2020.day16

import java.io.File

data class TicketField(var name: String, var range1: Pair<Int, Int>, var range2: Pair<Int, Int>)

fun readInputFieldsToMap(path: String): Map<String, TicketField> {
    val map = mutableMapOf<String, TicketField>()
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    for (line in lineList) {
        val split = line.split(": ")
        val ranges = split[1].split(" or ")
        val range1 = ranges[0].split("-")
        val range2 = ranges[1].split("-")
        map[split[0]] = TicketField(
            split[0],
            Pair(range1[0].toInt(), range1[1].toInt()),
            Pair(range2[0].toInt(), range2[1].toInt())
        )
    }
    return map
}

fun readInputTicketsToList(path: String): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    for (line in lineList) {
        val currList = mutableListOf<Int>()
        val numbers = line.split(",")
        numbers.mapTo(currList) { it.toInt() }
        list.add(currList)
    }
    return list
}

fun computeTicketScanningErrorRate(ticketList: List<List<Int>>, ranges: Map<String, TicketField>): Int {
    var ticketScanningErrorRate = 0
    val validRanges = mutableListOf<Pair<Int, Int>>()
    for (range in ranges.values) {
        validRanges.add(range.range1)
        validRanges.add(range.range2)
    }
    for (ticket in ticketList) {
        for (value in ticket) {
            val valueBelongsToValidRange = validRanges.any { value in it.first..it.second }
            if (!valueBelongsToValidRange) {
                ticketScanningErrorRate += value
            }
        }
    }
    return ticketScanningErrorRate
}