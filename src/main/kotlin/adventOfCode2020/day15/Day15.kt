package adventOfCode2020.day15

fun readInputToList(input: String): MutableList<Int> {
    val list = mutableListOf<Int>()
    input.split(",").mapTo(list) { it.toInt() }
    return list
}

fun speakNumbers(list: MutableList<Int>): Int {
    while (list.size < 2020) {
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