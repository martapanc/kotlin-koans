package adventOfCode2020.day19

import java.io.File

fun readRulesToMap(path: String): Map<String, String> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    val inputMap = mutableMapOf<String, String>()
    lineList
        .map { it.split(": ") }
        .forEach { inputMap[it[0]] = it[1] }
    return inputMap
}

fun readMessagesToList(path: String): List<String> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    return lineList
}

fun findRegex(map: Map<String, String>): String {
    return recursivelyReplace("0", map)
}

fun recursivelyReplace(rule: String, map: Map<String, String>): String {
    val ruleValue = map[rule]
    if (ruleValue == "a" || ruleValue == "b") {
        return ruleValue
    }
    var regex = if (ruleValue!!.contains("|")) "(" else ""
    for ((index, split) in ruleValue.split("|").withIndex()) {
        val rules = split.trim().split(" ")
        for (r in rules) {
            val recursivelyReplace = recursivelyReplace(r, map)
            regex = "$regex$recursivelyReplace"
        }
        if (ruleValue.contains("|") && index == 0) {
            regex += "|"
        }
    }
    if (ruleValue.contains("|")) regex += ")"
    return regex
}

fun countValidMessages(messages: List<String>, regexString: String): Int {
    var count = 0
    for (message in messages) {
        val regex = Regex(regexString)
        if (regex.matches(message)) {
            count++
        }
    }
    return count
}