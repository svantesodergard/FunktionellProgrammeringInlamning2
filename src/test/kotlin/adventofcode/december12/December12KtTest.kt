package adventofcode.december12

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

class December12KtTest {
    private val testInput1 = File("src/test/kotlin/adventofcode/december12/test").readLines()
    private val testInput2 = File("src/test/kotlin/adventofcode/december12/test2").readLines()
    private val testInput3 = File("src/test/kotlin/adventofcode/december12/test3").readLines()
    @Test
    fun part1Test() {
        val expected1 = 10
        val actual1 = part1(testInput1)
        assertEquals(expected1, actual1)

        val expected2 = 19
        val actual2 = part1(testInput2)
        assertEquals(expected2, actual2)

        val expected3 = 226
        val actual3 = part1(testInput3)
        assertEquals(expected3, actual3)
    }

    @Test
    fun mapCavesTest() {
        val expectedA = setOf("start", "c", "b", "end")
        val actualA = mapCaves(testInput1)["A"]?.toSet()
        assertEquals(expectedA, actualA)
    }

    @Test
    fun part2Test() {
        val expected1 = 36
        val actual1 = part2(testInput1)
        assertEquals(expected1, actual1)

        val expected2 = 103
        val actual2 = part2(testInput2)
        assertEquals(expected2, actual2)

        val expected3 = 3509
        val actual3 = part2(testInput3)
        assertEquals(expected3, actual3)
    }
}