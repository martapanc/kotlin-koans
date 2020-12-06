package adventOfCode2020.day6

import adventOfCode2020.day4.readInputFile
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day6KtTest {

    private val input = readInputFile("src/main/kotlin/adventOfCode2020/day6/input")
    private val input0 = readInputFile("src/main/kotlin/adventOfCode2020/day6/input0")

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
        assertEquals(0, countCommonLetters("i x i i"))
        assertEquals(1, countCommonLetters("ab ac"))
        assertEquals(3, countCommonLetters("abc"))
        assertEquals(3, countCommonLetters("abcx abcy abcz"))
    }

    @Test
    fun testCountTotalAnswers() {
        assertEquals(17, countTotalAnswers(input0, ::countUniqueLetters))
        assertEquals(6768, countTotalAnswers(input, ::countUniqueLetters))
    }

    @Test
    fun testCountCommonAnswers() {
        assertEquals(9, countTotalAnswers(input0, ::countCommonLetters))
        assertEquals(3489, countTotalAnswers(input, ::countCommonLetters))
    }
}