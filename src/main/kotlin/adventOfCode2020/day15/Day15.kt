package adventOfCode2020.day15

fun readInputToList(input: String): MutableList<Int> {
    val list = mutableListOf<Int>()
    input.split(",").mapTo(list) { it.toInt() }
    return list
}

fun speakNumbers(list: MutableList<Int>, limit: Long): Int {
    while (list.size < limit) {
        val lastNumberAdded = list.last()
        val subList = list.subList(0, list.size - 1)
        if (subList.contains(lastNumberAdded)) {
            val lastIndex = subList.lastIndexOf(lastNumberAdded)
            val currentIndex = list.lastIndexOf(lastNumberAdded)
            list.add(currentIndex - lastIndex)
        } else {
            list.add(0)
        }
    }
    return list.last()
}

fun speakNumbersV2(list: MutableList<Int>, limit: Long): Int {
    val numbersSeenToIndex = mutableMapOf<Int, Int>()
    for ((index, num) in list.withIndex()) {
        numbersSeenToIndex[num] = index
    }
    var i = list.size
    var lastNumberAdded = 0
    while (i < limit - 1) {
        if (numbersSeenToIndex.keys.contains(lastNumberAdded)) {
            val lastIndex = numbersSeenToIndex[lastNumberAdded]!!
            numbersSeenToIndex[lastNumberAdded] = i
            lastNumberAdded = i - lastIndex
        } else {
            numbersSeenToIndex[lastNumberAdded] = i
            lastNumberAdded = 0
        }
        i++
    }
    return lastNumberAdded
}