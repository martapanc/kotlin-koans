package adventOfCode2020.day5

import java.io.File
import java.io.InputStream
import kotlin.math.pow

fun readInputToList(path: String): List<String> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    return lineList.toList();
}

fun fromStringToRowAndColumn(input: String): Array<Int> {
    val binary = input
        .replace("F", "0")
        .replace("B", "1")
        .replace("L", "0")
        .replace("R", "1")
    val row = binaryToDecimal(binary.substring(0, 7).toInt())
    val column = binaryToDecimal(binary.substring(7, 10).toInt())
    return arrayOf(row, column, row * 8 + column)
}

fun binaryToDecimal(input: Int): Int {
    var num = input
    var decimalNumber = 0
    var i = 0
    var remainder: Int
    while (num != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * 2.0.pow(i.toDouble())).toInt()
        ++i
    }
    return decimalNumber
}

fun findHighestSeatId(inputList: List<String>): Int? {
    val idList = inputList
        .map { fromStringToRowAndColumn(it) }
        .map { it[2] }
    return idList.maxOrNull()
}