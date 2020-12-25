package adventOfCode2020.day25

fun findEncryptionKey(doorPubKey: Int, cardPubKey: Int, subjectNum: Int = 7): Long {
    val constant = 20201227
    var doorLoopNum = 0
    var cardLoopNum = 0

    var doorComputedPubKey = 1
    var cardComputedPubKey = 1

    while (cardComputedPubKey != cardPubKey) {
        cardComputedPubKey *= subjectNum
        cardComputedPubKey %= constant
        cardLoopNum++
    }
    while (doorComputedPubKey != doorPubKey) {
        doorComputedPubKey *= subjectNum
        doorComputedPubKey %= constant
        doorLoopNum++
    }

    var computedEncryptionKey = 1L
    for (i in 0 until cardLoopNum) {
        computedEncryptionKey *= doorPubKey
        computedEncryptionKey %= constant
    }

    var computerEncryptionKeyCheck = 1L
    for (i in 0 until doorLoopNum) {
        computerEncryptionKeyCheck *= cardPubKey
        computerEncryptionKeyCheck %= constant
    }

    if (computedEncryptionKey == computerEncryptionKeyCheck)
        return computedEncryptionKey
    return -1
}