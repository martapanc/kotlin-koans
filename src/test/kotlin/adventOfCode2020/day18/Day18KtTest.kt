package adventOfCode2020.day18

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day18KtTest {

    private val input = readInput("src/main/kotlin/adventOfCode2020/day18/input")
    private val input0 = readInput("src/main/kotlin/adventOfCode2020/day18/input0")

    @Test
    fun readInput() {
        println(input0)
        println(input)
    }

    @Test
    fun testRunOperations() {
        assertEquals(35, runOperations(listOf("( 2 + 3 ) * 7")))
        assertEquals(35, runOperations(listOf("2 + 3 * 7")))
        assertEquals(23, runOperations(listOf("3 * 7 + 2")))
        assertEquals(58, runOperations(listOf("5 + 3 * 7 + 2")))
        assertEquals(72, runOperations(listOf("( 5 + 3 ) * ( 7 + 2 )")))
        assertEquals(580, runOperations(listOf("( ( 5 + 3 ) * 7 ) + 2 * 10")))
        assertEquals(437, runOperations(listOf("5 + ( 8 * 3 + 9 + 3 * 4 * 3 )")))
        assertEquals(12240, runOperations(listOf("5 * 9 * ( 7 * 3 * 3 + 9 * 3 + ( 8 + 6 * 4 ) )")))
        assertEquals(13632, runOperations(listOf("( ( 2 + 4 * 9 ) * ( 6 + 9 * 8 + 6 ) + 6 ) + 2 + 4 * 2")))
        assertEquals(148, runOperations(input0))
        assertEquals(45283905029161, runOperations(input))
    }
}