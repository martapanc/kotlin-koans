package adventOfCode2020.day6

import java.io.File
import java.io.InputStream

fun readInput(path: String) : List<String> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val answersList = mutableListOf<String>()
    var answers = ""
    for (line in lineList) {
        if (line.isNotEmpty()) {
            answers += if (answers.isBlank()) { line } else { " $line" }
        } else {
            answersList.add(answers)
            answers = ""
        }
    }
    return answersList;
}

fun countUniqueLetters(answers: String): Int {
    val set = mutableSetOf<Char>()
    for (answer in answers.split(" ")) {
        for (char in answer) {
            set.add(char)
        }
    }
    return set.size
}

fun countTotalAnswers(list: List<String>): Int {
    return list.sumBy { countUniqueLetters(it) }
}

fun countCommonLetters(answersString: String): Int {
    val answerGroupList = answersString.split(" ")
    if (answerGroupList.size == 1) {
        return answerGroupList[0].length
    }
    for (answers in answerGroupList) {
        if (answers.length == 1) {
        }
    }
    return 0
}