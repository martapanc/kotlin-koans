package adventOfCode2020.day8

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day8KtTest {

    private val input = readInputToMap("src/main/kotlin/adventOfCode2020/day8/input")
    private val input0 = readInputToMap("src/main/kotlin/adventOfCode2020/day8/input0")

    @Test
    fun readInputToMap() {
        println(input0)
        println(input)
    }

    @Test
    fun playTheGame() {
        assertEquals(5, playTheGame(input0))
        assertEquals(1200, playTheGame(input))
    }
}