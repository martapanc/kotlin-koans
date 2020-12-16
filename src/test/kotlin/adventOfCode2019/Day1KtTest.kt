package adventOfCode2019

import adventOfCode2019.day1.computeFuel
import adventOfCode2019.day1.computeTotalFuel
import adventOfCode2019.day1.computerRecursiveTotalFuel
import adventOfCode2019.day1.readInputFileToList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1KtTest {

    @Test
    fun testComputeFuel() {
        assertEquals(2, computeFuel(12))
        assertEquals(2, computeFuel(14))
        assertEquals(-1, computeFuel(5))
        assertEquals(0, computeFuel(6))
        assertEquals(1, computeFuel(9))
        assertEquals(9, computeFuel(35))
        assertEquals(654, computeFuel(1969))
        assertEquals(33583, computeFuel(100756))
        assertEquals(1049008, computeFuel(3147032))
        assertEquals(349667, computeFuel(1049008))
    }

    @Test
    fun testComputeTotalFuel() {
        assertEquals(4, computeTotalFuel(listOf(12, 14)))
        assertEquals(658, computeTotalFuel(listOf(12, 14, 1969)))
        assertEquals(33583, computeTotalFuel(listOf(100756)))
    }

    @Test
    fun testReadInputFileToList() {
        print(readInputFileToList("src/main/kotlin/adventOfCode2019/day1/input.txt"))
    }

    @Test
    fun testComputeRecursiveTotalFuel() {
        assertEquals(2, computerRecursiveTotalFuel(listOf(12)))
        assertEquals(10, computerRecursiveTotalFuel(listOf(35)))
        assertEquals(966, computerRecursiveTotalFuel(listOf(1969)))
        assertEquals(50346, computerRecursiveTotalFuel(listOf(100756)))
    }
}