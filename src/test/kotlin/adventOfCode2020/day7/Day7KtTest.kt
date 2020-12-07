package adventOfCode2020.day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day7KtTest {

    private val input = readInputToMap("src/main/kotlin/adventOfCode2020/day7/input")
    private val input0 = readInputToMap("src/main/kotlin/adventOfCode2020/day7/input0")
    private val input2= readInputToMap("src/main/kotlin/adventOfCode2020/day7/input2")

    @Test
    fun readInputToList() {
        println(input0)
        println(input)

        println(buildMapFromContainedBags(input0))
        println(buildMapFromContainedBags(input))
    }

    @Test
    fun testFindContainingBags() {
        assertEquals(4, findContainingBags(buildMapFromContainedBags(input0), "shiny gold"))
        assertEquals(179, findContainingBags(buildMapFromContainedBags(input), "shiny gold"))
    }

    @Test
    fun testFindContainedIndividualBags() {
        assertEquals(32, findContainedIndividualBags(input0, "shiny gold"))
        assertEquals(126, findContainedIndividualBags(input2, "shiny gold"))
        assertEquals(18925, findContainedIndividualBags(input, "shiny gold"))
    }
}