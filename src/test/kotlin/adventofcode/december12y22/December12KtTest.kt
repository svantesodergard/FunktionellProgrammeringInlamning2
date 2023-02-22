package adventofcode.december12y22

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

class December12KtTest {
    val testInput = File("src/test/kotlin/adventofcode/december12y22/test").readLines()
    @Test
    fun mapInputTest() {
        val expected = 'E'
        val actual = mapInput(testInput)[5][2]
        assertEquals(expected, actual)
    }
    @Test
    fun part1Test() {
        val expected = 31
        val actual = part1(testInput)
        assertEquals(expected, actual)
    }
}