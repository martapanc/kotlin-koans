package adventOfCode2020.day11

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day11KtTest {

    private val input = readInputToMap("src/main/kotlin/adventOfCode2020/day11/input")
    private val input0 = readInputToMap("src/main/kotlin/adventOfCode2020/day11/input0")


    @Test
    fun readInputToMap() {
//        println(input0)
//        println(input)
        printSeatMap(input0, 9, 9)
        printSeatMap(input, 90, 93)
    }

    @Test
    fun testRunRounds() {
        assertEquals(37, runRounds(input0))
        assertEquals(2222, runRounds(input))
    }


}