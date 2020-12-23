package adventOfCode2020.day23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day23KtTest {

    val input0 = listOf(3, 8, 9, 1, 2, 5, 4, 6, 7)
    val input = listOf(3, 6, 2, 9, 8, 1, 7, 5, 4)

    @Test
    fun playGame() {
        assertEquals("92658374", playGame(input0, 10))
        assertEquals("67384529", playGame(input0))
        assertEquals("24798635", playGame(input))
    }

    @Test
    fun playGameP2() {
        assertEquals(149245887792, playGameP2(input))
    }
}