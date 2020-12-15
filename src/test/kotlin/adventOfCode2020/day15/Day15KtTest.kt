package adventOfCode2020.day15

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day15KtTest {

    private val input = readInputToList("6,13,1,15,2,0")
    private val input0 = readInputToList("0,3,6")
    private val input1 = readInputToList("1,3,2")
    private val input2 = readInputToList("2,1,3")

    @Test
    fun readInputToList() {
        println(input0)
        println(input1)
        println(input)
    }

    @Test
    fun testSpeakNumbers() {
        assertEquals(436, speakNumbers(input0))
        assertEquals(1, speakNumbers(input1))
        assertEquals(10, speakNumbers(input2))
        assertEquals(1194, speakNumbers(input))
    }
}