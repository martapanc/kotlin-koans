package adventOfCode2020.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day20KtTest {

    private val input = readInputToList("src/main/kotlin/adventOfCode2020/day20/input")
    private val input0 = readInputToList("src/main/kotlin/adventOfCode2020/day20/input0")

    @Test
    fun readInputToList() {
        assertEquals(9, input0.size)
        assertEquals(144, input.size)
    }

    @Test
    fun findCornerTiles() {
        assertEquals(18262194216271, findCornersCheckProduct(input))
        assertEquals(20899048083289, findCornersCheckProduct(input0))
    }

    @Test
    fun createCompletePuzzle() {
//        createCompletePuzzle(input0)
        createCompletePuzzle(input)
    }

    @Test
    fun rotateTile90DegreesClockwise() {
//        printTile(rotateOrFlip(input0[0], rotate = true, deg = 90, flip = '0'))
//        printTile(rotateOrFlip(input0[0], rotate = true, deg = 180, flip = '0'))
//        printTile(rotateOrFlip(input0[0], rotate = true, deg = 270, flip = '0'))
//        printTile(rotateOrFlip(input0[0], rotate = false, deg = 0, flip = 'v'))
//        printTile(rotateOrFlip(input0[0], rotate = false, deg = 0, flip = 'h'))
        printTile(rotateOrFlip(input0[0], rotate = true, deg = 90, flip = 'h'))
        printTile(rotateOrFlip(input0[0], rotate = true, deg = 90, flip = 'v'))
    }

    @Test
    fun drawFirstLine() {
        drawFirstLine(input)
    }
}