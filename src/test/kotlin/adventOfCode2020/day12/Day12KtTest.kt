package adventOfCode2020.day12

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day12KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day12/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day12/input0")

    @Test
    fun testReadInputToList() {
        println(input0)
        println(input)
    }

    @Test
    fun testNavigateShip() {
        assertEquals(25, navigateShip(input0))
        assertEquals(882, navigateShip(input))
    }

    @Test
    fun testNavigateShipAndWaypoint() {
        assertEquals(286, navigateShipAndWaypoint(input0))
        assertEquals(28885, navigateShipAndWaypoint(input))
    }
}