package adventOfCode2020.day9

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day9KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day9/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day9/input0")
    //removed all numbers after N and some previous larger numbers
    private val inputEdit = readInputToList("src/main/kotlin/adventOfCode2020/day9/input_edit")

    @Test
    fun readInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun findFirstNumberNotTheSumOfPreviousN() {
        assertEquals(127, findFirstNumberNotTheSumOfPreviousN(input0, 5))
        assertEquals(10884537, findFirstNumberNotTheSumOfPreviousN(input, 25))
    }

    @Test
    fun testFindContiguousNumberGiving10884537() {
        assertEquals(62, findContiguousNumberGivingN(input0, 127))
        assertEquals(1261309, findContiguousNumberGivingN(inputEdit, 10884537))
    }
}