package adventOfCode2020.day23

import com.ginsberg.cirkle.circular

fun playGame(input: List<Int>, moves: Int = 100): String {
    var list = input.toMutableList().circular()
    var currentCup = input[0]
    for (move in (1..moves)) {
        val currentCupIndex = list.indexOf(currentCup)
        list = rotateListToHaveCurrentAtTheStart(currentCupIndex, list)

        val listCopy = list.toMutableList()
        val pickUp = listOf(list.removeAt(1), list.removeAt(1), list.removeAt(1))
        val min = list.minOrNull()
        val listMinusLargerThanCurrent = list.toMutableList()
        list
            .filter { it >= currentCup }
            .forEach { listMinusLargerThanCurrent.remove(it) }
        val nextCup = list[list.indexOf(currentCup) + 1]
        val max = listMinusLargerThanCurrent.maxOrNull()
        val indexToDropPickups = if (currentCup == min) {
            listCopy.indexOf(list.maxOrNull())
        } else {
            listCopy.indexOf(max)
        }
        for (pu in pickUp) {
            listCopy.remove(pu)
            listCopy.add(indexToDropPickups, pu)
        }
        list = listCopy.circular()
        currentCup = nextCup
    }
    return listAfter1ToString(list)
}

fun playGameP2(input: List<Int>, moves: Long = 10000000): Long {
    var list = addCupsToList(input)
    var currentCup = input[0]
    for (move in (1..moves)) {
        val pickUp = listOf(list.removeAt(1), list.removeAt(1), list.removeAt(1))
        val nextCup = list[list.indexOf(currentCup) + 1]

        var candidate = currentCup - 1
        while (!list.contains(candidate)) {
            if (candidate <= 0) {
                candidate = 1000000
            } else {
                candidate -= 1
            }
        }
        val indexToDropPickups = list.indexOf(candidate) + 1

        for (pu in pickUp.reversed()) {
            list.add(indexToDropPickups, pu)
        }
        list.remove(currentCup)
        list.add(currentCup)
        currentCup = nextCup
    }

    return list[list.indexOf(1) + 1].toLong() * list[list.indexOf(1) + 2]
}

private fun rotateListToHaveCurrentAtTheStart(index: Int, list: List<Int>): MutableList<Int> {
    val listWithCurrentAtStart = mutableListOf<Int>().circular()
    (index until list.size + index).mapTo(listWithCurrentAtStart) { list[it] }
    return listWithCurrentAtStart
}

private fun listAfter1ToString(list: List<Int>): String {
    val newList = rotateListToHaveCurrentAtTheStart(list.indexOf(1), list)
    var string = ""
    for (n in 1 until newList.size) {
        string += newList[n]
    }
    return string
}

private fun addCupsToList(input: List<Int>): MutableList<Int> {
    val newInputList = input.toMutableList()
    newInputList += 10..1000000
    return newInputList
}