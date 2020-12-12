package adventOfCode2020.day12

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day12KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day12/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day12/input0")

    @Test
    fun testReadInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun testNavigate() {
        assertEquals(25, navigate(input0))
        assertEquals(882, navigate(input))
    }
}