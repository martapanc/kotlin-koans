package adventOfCode2020.day10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day10KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day10/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day10/input0")
    private val input1 = readInputToList("src/main/kotlin/adventOfCode2020/day10/input1")

    @Test
    fun readInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun findJoltsDifferences() {
//        assertEquals(35, findJoltsDifferences(input0))
        assertEquals(220, findJoltsDifferences(input1))
        assertEquals(1984, findJoltsDifferences(input))
    }

    @Test
    fun printSubsets() {
        assertEquals(listOf(listOf<Int>()), generateSubsets(mutableListOf()))
        assertEquals(listOf(listOf(), listOf(1)), generateSubsets(mutableListOf(1)))
        assertEquals(4, generateSubsets(mutableListOf(1, 2)).size)
        assertEquals(8, generateSubsets(mutableListOf(1, 2, 3)).size)
        println(generateSubsets(mutableListOf(1, 2, 3, 4)))
    }

    @Test
    fun generateValidSubsets() {
        assertEquals(7, getNumberOfValidSubsets(listOf(1, 2, 3)))
        assertEquals(7, generateValidSubsets((listOf(4, 5, 6))).size)
        assertEquals(13, generateValidSubsets((listOf(4, 5, 6, 7))).size)
        assertEquals(24, generateValidSubsets((listOf(4, 5, 6, 7, 8))).size)
        assertEquals(44, generateValidSubsets((listOf(4, 5, 6, 7, 8, 9))).size)
        assertEquals(81, generateValidSubsets((listOf(4, 5, 6, 7, 8, 9, 10))).size)
    }

    @Test
    fun findPermutations() {
        assertEquals(8, findPermutations(input0))
        assertEquals(19208, findPermutations(input1))
        assertEquals(3543369523456, findPermutations(input))
    }
}