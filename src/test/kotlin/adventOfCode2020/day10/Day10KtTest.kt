package adventOfCode2020.day10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day10KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day10/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day10/input0")
    private val input1 = readInputToList("src/main/kotlin/adventOfCode2020/day10/input1")

    @Test
    fun readInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun findJoltsDifferences() {
        assertEquals(35, findJoltsDifferences(input0))
        assertEquals(220, findJoltsDifferences(input1))
        assertEquals(1984, findJoltsDifferences(input))
    }
}