package adventOfCode2020.day24

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day24KtTest {

    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day24/input0")
    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day24/input")

    @Test
    fun readInputToList() {
        println(input0)
        assertEquals(20, input0.size)
        assertEquals(597, input.size)
    }

    @Test
    fun findTiles() {
        assertEquals(10, findTilesAndCountBlackOnes(input0))
        assertEquals(549, findTilesAndCountBlackOnes(input))
    }
}