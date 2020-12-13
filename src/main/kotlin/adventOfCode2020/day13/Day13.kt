package adventOfCode2020.day13


fun readInputToList(input: String): List<Int> {
    val list = mutableListOf<Int>()
    for (v in input.split(",")) {
        if (v == "x") {
            list.add(-1)
        } else {
            list.add(v.toInt())
        }
    }
    return list
}

// 1068781 = 152682 * 7
// 1068782 = 82214 * 13
// 1068785 = 18115 * 59
fun findEarliestTimestamp(inputList: List<Int>, min: Int, max: Int, indices: List<Int>): Long {
    val listOfMultiplesOfFirstNumber = mutableListOf<Long>()
    val listOfMultiplesOfSecondNumber = mutableListOf<Long>()
    val listOfMultiplesOfThirdNumber = mutableListOf<Long>()
//    val listOfMultiplesOfFourthNumber = mutableListOf<Long>()
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

// 100000000000000 / 37  = 2702702702702
// 100000000000000 / 41  = 2439024390243
// 100000000000000 / 587 =  170357751277
// 100000000000000 / 13  = 7692 307 692 307
// 100000000000000 / 733 =  136 425 648 021
fun findEarliestTimestamp2(inputList: List<Int>): Long {
    val indices = inputList.filter { it != -1 }.map { inputList.indexOf(it) }

    val listOfMultiplesOfFirstNumber = mutableListOf<Long>()
    val listOfMultiplesOfSecondNumber = mutableListOf<Long>()
    val listOfMultiplesOfThirdNumber = mutableListOf<Long>()
    for (i in 2702702736321..2702702802702) {
        listOfMultiplesOfFirstNumber.add((inputList[indices[0]] * i))
    }
    for (i in 2439024390243..2439024490243) {
        listOfMultiplesOfSecondNumber.add((inputList[indices[1]] * i))
    }
    for (i in 170357751277..170357851277) {
        listOfMultiplesOfThirdNumber.add((inputList[indices[2]] * i))
    }

    val candidates = mutableListOf<Long>()
    for (first in listOfMultiplesOfFirstNumber) {
        if (listOfMultiplesOfSecondNumber.contains(first + indices[1])
            && listOfMultiplesOfThirdNumber.contains(first + indices[2])
        ) {
            candidates.add(first)
        }
    }

    return -1
}