package adventofcode.december1

import org.junit.Test
import java.io.File

class December1KtTest {
    private val testInput = File("src/test/kotlin/adventofcode/december1/test").readLines()
    @Test
    fun part1test() {
        val expected = 514579
        val actual = part1(testInput)
        assert(expected == actual)
    }
}