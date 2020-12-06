package adventOfCode2020.day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day6KtTest {

    private val input = readInput("src/main/kotlin/adventOfCode2020/day6/input")
    private val input0 = readInput("src/main/kotlin/adventOfCode2020/day6/input0")

    @Test
    fun readInput() {
        println(input)
        println(input0)
    }

    @Test
    fun testCountUniqueLetters() {
        assertEquals(2, countUniqueLetters("i x i i"))
        assertEquals(3, countUniqueLetters("ab ac"))
        assertEquals(3, countUniqueLetters("abc"))
        assertEquals(6, countUniqueLetters("abcx abcy abcz"))
    }

    @Test
    fun testCountCommonLetters() {
        assertEquals(3, countCommonLetters("abc"))
        assertEquals(0, countCommonLetters("i x i i"))
        assertEquals(1, countCommonLetters("ab ac"))
        assertEquals(3, countCommonLetters("abcx abcy abcz"))
    }

    @Test
    fun testCountTotalAnswers() {
        assertEquals(17, countTotalAnswers(input0))
        assertEquals(17, countTotalAnswers(input))
    }

    @Test
    fun testCountCommonAnswers() {
        assertEquals(9, countTotalCommonAnswers(input0))
        assertEquals(17, countTotalCommonAnswers(input))
    }
}