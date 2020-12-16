package adventOfCode2020.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1KtTest {

    private val testInputMap = readInputFileToMap("src/main/kotlin/adventOfCode2020/day1/input0")
    private val inputMap = readInputFileToMap("src/main/kotlin/adventOfCode2020/day1/input_fields")

    @Test
    fun testReadInputFileToMap() {
        println(inputMap)
    }

    @Test
    fun testFindPairAndMultiply() {
        assertEquals(514579, findPairAndMultiply(testInputMap))
        assertEquals(972576, findPairAndMultiply(inputMap))
    }

    @Test
    fun testFindTripletAndMultiply() {
        assertEquals(241861950, findTripletAndMultiply(testInputMap))
        assertEquals(199300880, findTripletAndMultiply(inputMap))
    }
}