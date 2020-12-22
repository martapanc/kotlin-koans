package adventOfCode2020.day22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day22KtTest {

    private val input0 = readInputToLists("src/main/kotlin/adventOfCode2020/day22/input0")
    private val input = readInputToLists("src/main/kotlin/adventOfCode2020/day22/input")

    @Test
    fun readInputToLists() {
        assertEquals(listOf(9, 2, 6, 3, 1), input0.first)
        assertEquals(5, input0.second.size)
        assertEquals(25, input.first.size)
        assertEquals(25, input.second.size)
    }

    @Test
    fun playGame() {
        assertEquals(306, playGame(input0))
        assertEquals(33631, playGame(input))
    }
}