package adventOfCode2020.day7

import adventOfCode2020.day4.readInputFile
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day7KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day7/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day7/input0")

    @Test
    fun readInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun testFindContainingBags() {
        assertEquals(4, findContainingBags(input0))
    }
}