package adventOfCode2020.day23

import com.ginsberg.cirkle.circular

fun playGame(input: List<Int>, moves: Int): String {
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