package adventOfCode2020.day13

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day13KtTest {

    private val input = readInputToList("37,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,587,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,13,19,x,x,x,23,x,x,x,x,x,29,x,733,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,17")
    private val input0 = readInputToList("7,13,x,x,59,x,31,19")
    private val input1 = readInputToList("17,x,13,19")
    private val input2 = readInputToList("67,7,59,61")
    private val input3 = readInputToList("67,x,7,59,61")
    private val input4 = readInputToList("67,7,x,59,61")
    private val input5 = readInputToList("1789,37,47,1889")

    @Test
    fun testReadInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun testFindEarliestTimestamp() {
        assertEquals(1068781, findEarliestTimestamp(input0, 10000, 180000))
    }
}