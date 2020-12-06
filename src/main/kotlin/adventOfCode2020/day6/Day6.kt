package adventOfCode2020.day6

fun countUniqueChars(answers: String): Int {
    val set = mutableSetOf<Char>()
    for (answer in answers.split(" ")) {
        for (char in answer) {
            set.add(char)
        }
    }
    return set.size
}

fun countCommonChars(answersString: String): Int {
    val setOfUniqueChars = mutableSetOf<Char>()
    for (answers in answersString.split(" ")) {
        setOfUniqueChars.addAll(answers.toList())
    }

    val setOfUniqueCharsCopy = setOfUniqueChars.toMutableList()
    for (answer in answersString.split(" ")) {
        setOfUniqueChars
            .asSequence()
            .filterNot { answer.contains(it) }
            .forEach { setOfUniqueCharsCopy.remove(it) }
    }
    return setOfUniqueCharsCopy.size
}

fun countTotalAnswers(list: List<String>, countMethod: (String) -> Int): Int {
    return list.sumBy { countMethod(it) }
}
