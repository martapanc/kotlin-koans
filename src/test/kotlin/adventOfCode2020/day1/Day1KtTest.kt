package adventOfCode2020.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1KtTest {

    private val testInput = "src/main/kotlin/adventOfCode2020/day1/input0"
    private val input = "src/main/kotlin/adventOfCode2020/day1/input"

    @Test
    fun testReadInputFileToMap() {
        println(readInputFileToMap(input))
    }

    @Test
    fun testFindPairAndMultiply() {
        assertEquals(514579, findPairAndMultiply(readInputFileToMap(testInput)))
        assertEquals(972576, findPairAndMultiply(readInputFileToMap(input)))
    }
}