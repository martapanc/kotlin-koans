package adventOfCode2020.day13


fun readInputToList(input: String): List<Int> {
    val list = mutableListOf<Int>()
    for (v in input.split(",")) {
        if (v == "x") { list.add(-1) } else { list.add(v.toInt()) }
    }
    return list
}

fun readInputToListExcludeX(input: String): List<Int> {
    return input.split(",")
        .filter { it != "x" }
        .map { it.toInt() }
}

fun findFirstAvailableBus(timestamp: Long, inputList: List<Int>): Int {
    val minWaitTime = mutableMapOf<Int, Int>()
    for (arrivalInterval in inputList) {
        val waitTime = ((timestamp / arrivalInterval) + 1) * arrivalInterval - timestamp
        minWaitTime[waitTime.toInt()] = arrivalInterval
    }

    val min = minWaitTime.keys.minOrNull()
    if (min != null) {
        return min * minWaitTime[min]!!
    }
    return -1
}

// This loops through the available buses and their arrival times finding multiples of the interval, but uses the LCM to update the interval,
// based on the multiplier found at every loop (which saves a lot of iterations), until a common multiple is found
fun findEarliestTimestampMathEdition(inputList: List<Int>): Long {
    val busList = mutableListOf<Bus>()
    inputList
        .filter { it != -1 }
        .mapTo(busList) { Bus(inputList.indexOf(it).toLong(), it.toLong()) }

    var index = busList[0].index
    var interval = busList[0].departureInterval
    var temp = 0L
    for (bus in busList.subList(1, busList.size)) {
        for (i in index until Long.MAX_VALUE step interval) {
            temp = i
            if ((i + bus.index) % bus.departureInterval == 0L) {
                break
            }
        }
        interval = lcm(interval, bus.departureInterval)
        index = temp
    }
    return index
}

private fun lcm(a: Long, b: Long): Long {
    return a * b / gcd(a, b)
}

private fun gcd(a: Long, b: Long): Long {
    if (a == 0L) return b
    return gcd(b % a, a)
}

class Bus(var index: Long, var departureInterval: Long)
