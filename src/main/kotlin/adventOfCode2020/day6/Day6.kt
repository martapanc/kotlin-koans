package adventOfCode2020.day6

fun countUniqueLetters(answers: String): Int {
    val set = mutableSetOf<Char>()
    for (answer in answers.split(" ")) {
        for (char in answer) {
            set.add(char)
        }
    }
    return set.size
}

fun countCommonLetters(answersString: String): Int {
    val answerGroupList = answersString.split(" ")
    if (answerGroupList.size == 1) {
        return answerGroupList[0].length
    }

    val setOfLetters = mutableSetOf<Char>()
    for (answers in answerGroupList) {
        setOfLetters.addAll(answers.toList())
    }

    val setOfLettersCopy = setOfLetters.toMutableList()
    for (answer in answerGroupList) {
        setOfLetters
            .asSequence()
            .filterNot { answer.contains(it) }
            .forEach { setOfLettersCopy.remove(it) }
    }
    return setOfLettersCopy.size
}

fun countTotalAnswers(list: List<String>, countMethod: (String) -> Int): Int {
    return list.sumBy { countMethod(it) }
}
