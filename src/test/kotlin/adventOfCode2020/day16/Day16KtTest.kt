package adventOfCode2020.day16

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day16KtTest {

    private val inputFields = readInputFieldsToMap("src/main/kotlin/adventOfCode2020/day16/input_fields")
    private val inputTickets = readInputTicketsToList("src/main/kotlin/adventOfCode2020/day16/input_tickets")
    private val input0 = readInputFieldsToMap("src/main/kotlin/adventOfCode2020/day16/input0")

    @Test
    fun readInputFieldsToMap() {
        assertEquals(20, inputFields.size)
    }

    @Test
    fun readInputTicketsToList() {
        assertEquals(235, inputTickets.size)
    }

    @Test
    fun computeTicketScanningErrorRate() {
        assertEquals(19070, computeTicketScanningErrorRate(inputTickets, inputFields))
    }
}