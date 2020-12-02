package adventOfCode2020.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day2KtTest {

    @Test
    fun testIsValidPassword() {
        assertTrue(isValidPassword(1, 3, 'a', "abcde"))
        assertTrue(isValidPassword(1, 1, 'b', "abcde"))
        assertFalse(isValidPassword(1, 3, 'a', "aaaaa"))
        assertFalse(isValidPassword(1, 1, 'a', "aabcd"))
    }

    @Test
    fun testCountValidPasswords() {
        assertEquals(2, countValidPasswords(readInputFileToList("src/main/kotlin/adventOfCode2020/day2/input0")))
        assertEquals(569, countValidPasswords(readInputFileToList("src/main/kotlin/adventOfCode2020/day2/input")))
    }

    @Test
    fun testReadInputToList() {
        println(readInputFileToList("src/main/kotlin/adventOfCode2020/day2/input0"))
    }
}