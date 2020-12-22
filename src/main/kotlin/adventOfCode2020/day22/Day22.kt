package adventOfCode2020.day22

import java.io.File

fun readInputToLists(path: String): Pair<List<Int>, List<Int>> {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }
    val playerOne = mutableListOf<Int>()
    val playerTwo = mutableListOf<Int>()
    val iterator = lineList.iterator()
    while (iterator.hasNext()) {
        var line = iterator.next()
        if (line.startsWith("Player 1:")) {
            line = iterator.next()
            while (line != "") {
                playerOne.add(line.toInt())
                line = iterator.next()
            }
        }
        if (line.startsWith("Player 2:")) {
            line = iterator.next()
            while (line != "") {
                playerTwo.add(line.toInt())
                line = iterator.next()
            }
        }
    }
    return Pair(playerOne, playerTwo)
}

fun playGame(decks: Pair<List<Int>, List<Int>>): Long {
    val playerOne = decks.first.toMutableList()
    val playerTwo = decks.second.toMutableList()

    while (playerOne.size != 0 && playerTwo.size != 0) {
        val onePlays = playerOne.removeAt(0)
        val twoPlays = playerTwo.removeAt(0)
        if (onePlays > twoPlays) {
            playerOne.add(onePlays)
            playerOne.add(twoPlays)
        } else {
            playerTwo.add(twoPlays)
            playerTwo.add(onePlays)
        }
    }
    val winner = if (playerOne.size != 0) playerOne else playerTwo
    return (winner.size downTo 1)
        .mapIndexed { index, num -> (num * winner[index]).toLong() }
        .sum()
}