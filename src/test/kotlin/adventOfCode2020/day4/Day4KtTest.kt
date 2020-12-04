package adventOfCode2020.day4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day4KtTest {

    private val inputFile = readInputFile("src/main/kotlin/adventOfCode2020/day4/input")
    private val input0File = readInputFile("src/main/kotlin/adventOfCode2020/day4/input0")

    @Test
    fun readInputFile() {
        println(inputFile)
        println(input0File)
        assertEquals(4, input0File.size)
    }

    @Test
    fun testCountValidPassports() {
        assertEquals(2, countValidPassports(input0File))
        assertEquals(123, countValidPassports(inputFile))
    }
}