package adventOfCode2020.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day20KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day20/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day20/input0")

    @Test
    fun readInputToList() {
        assertEquals(9, input0.size)
        assertEquals(144, input.size)
    }

    @Test
    fun findCornerTiles() {
        assertEquals(20899048083289, findCornerTiles(input0))
        assertEquals(18262194216271, findCornerTiles(input))
    }
}