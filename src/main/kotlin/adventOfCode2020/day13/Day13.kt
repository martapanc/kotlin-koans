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

// 1068781 = 152682 * 7
// 1068782 = 82214 * 13
// 1068785 = 18115 * 59
fun findEarliestTimestamp(inputList: List<Int>, min: Int, max: Int, indices: List<Int>): Long {
    val listOfMultiplesOfFirstNumber = mutableListOf<Long>()
    val listOfMultiplesOfSecondNumber = mutableListOf<Long>()
    val listOfMultiplesOfThirdNumber = mutableListOf<Long>()
    val firstNum = inputList[0]
    val secondNum = inputList[1]
    val thirdNum = inputList[4]
    val fourthNum = inputList[6]
    val fifthNum = inputList[7]
    for (i in min..max) {
        listOfMultiplesOfFirstNumber.add((firstNum * i).toLong())
        listOfMultiplesOfSecondNumber.add((secondNum * i).toLong())
        listOfMultiplesOfThirdNumber.add((thirdNum * i).toLong())
    }

    val candidates = mutableListOf<Long>()
    for (first in listOfMultiplesOfFirstNumber) {
        if (listOfMultiplesOfSecondNumber.contains(first + 1)
            && listOfMultiplesOfThirdNumber.contains(first + 4)
        ) {
            candidates.add(first)
        }
    }

    val reducedCandidates = mutableListOf<Long>()
    for (c in candidates) {
        if ((c + 6) % fourthNum == 0L && (c + 7) % fifthNum == 0L) {
            reducedCandidates.add(c)
        }
    }
    return candidates[0]
}

// This takes a lot - run at your own risk
fun findEarliestTimestamp2(inputList: List<Int>): Long {
    val indices = inputList.filter { it != -1 }.map { inputList.indexOf(it) }

    val candidates = mutableListOf<Long>()
    for (i in 2702702736321..27027027027027) {
        val product = inputList[indices[0]] * i
        if ((product + indices[1]) % inputList[indices[1]] == 0L
            && (product + indices[2]) % inputList[indices[2]] == 0L
            && (product + indices[3]) % inputList[indices[3]] == 0L
            && (product + indices[4]) % inputList[indices[4]] == 0L
            && (product + indices[5]) % inputList[indices[5]] == 0L
            && (product + indices[6]) % inputList[indices[6]] == 0L
            && (product + indices[7]) % inputList[indices[7]] == 0L
            && (product + indices[8]) % inputList[indices[8]] == 0L
        ) {
            candidates.add(product)
        }
    }
    return candidates[0]
}

fun findEarliestTimestampMathEdition(inputList: List<Int>): Long {
    val busIndexAndIdList = mutableListOf<Bus>()
    inputList
        .filter { it != -1 }
        .mapTo(busIndexAndIdList) { Bus(inputList.indexOf(it).toLong(), it.toLong()) }

    var index = busIndexAndIdList[0].index
    var interval = busIndexAndIdList[0].departureInterval
    var temp = 0L
    for (bus in busIndexAndIdList.subList(1, busIndexAndIdList.size)) {
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
