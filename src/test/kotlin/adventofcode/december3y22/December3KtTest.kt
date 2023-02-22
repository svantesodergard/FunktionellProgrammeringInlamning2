package adventofcode.december3y22

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

class December3KtTest {

    private val testInput = File("src/test/kotlin/adventofcode/december3y22/test").readLines()
    @Test
    fun part1() {
        val expected = 157
        val actual = part1(testInput)
        assertEquals(expected, actual)
    }

    @Test
    fun part2() = assertEquals(70, part2(testInput))
}