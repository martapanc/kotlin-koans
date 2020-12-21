package adventOfCode2020.day21

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day21KtTest {

    private val input0 = readInputToMap("src/main/kotlin/adventOfCode2020/day21/input0")
    private val input = readInputToMap("src/main/kotlin/adventOfCode2020/day21/input")

    @Test
    fun readInputToMap() {
        println(input0)
    }

    @Test
    fun compute() {
        assertEquals(5, compute(input0))
        assertEquals(1913, compute(input))
    }
}