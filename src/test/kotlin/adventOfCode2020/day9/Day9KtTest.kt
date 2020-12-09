package adventOfCode2020.day9

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day9KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day9/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day9/input0")

    @Test
    fun readInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun findFirstNumberNotTheSumOfPrevious2() {
        assertEquals(127, findFirstNumberNotTheSumOfPreviousN(input0, 5))
        assertEquals(10884537, findFirstNumberNotTheSumOfPreviousN(input, 25))
    }
}