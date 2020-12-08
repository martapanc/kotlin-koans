package adventOfCode2020.day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day8KtTest {

    private val input = readInputToMap("src/main/kotlin/adventOfCode2020/day8/input")
    private val input0 = readInputToMap("src/main/kotlin/adventOfCode2020/day8/input0")
    private val input0_modif = readInputToMap("src/main/kotlin/adventOfCode2020/day8/input0_modif")

    @Test
    fun readInputToMap() {
        println(input0)
        println(input)
        println(input0_modif)
    }

    @Test
    fun playTheGame() {
        assertEquals(GameOver(5, false), playTheGame(input0))
        assertEquals(GameOver(8, true), playTheGame(input0_modif))
        assertEquals(GameOver(1200, false), playTheGame(input))
    }
}