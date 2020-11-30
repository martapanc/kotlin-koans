package adventOfCode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1KtTest {

    @Test
    fun testComputeFuel() {
        assertEquals(2, computeFuel(12))
        assertEquals(2, computeFuel(14))
        assertEquals(654, computeFuel(1969))
        assertEquals(33583, computeFuel(100756))
    }

    @Test
    fun testComputeTotalFuel() {
        assertEquals(4, computeTotalFuel(listOf(12, 14)))
        assertEquals(658, computeTotalFuel(listOf(12, 14, 1969)))
        assertEquals(33583, computeTotalFuel(listOf(100756)))
    }

    @Test
    fun testReadInputFileToList() {
        print(readInputFileToList("src/main/kotlin/adventOfCode/input.txt"))
    }
}