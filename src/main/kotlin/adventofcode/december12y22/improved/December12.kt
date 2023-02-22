/*
    Inspiration:
    https://github.com/abrudin/advent-of-code-2022/blob/main/src/main/kotlin/Day12.kt
 */
package adventofcode.december12y22.improved

import java.io.File
import kotlin.math.abs

private val input = File("src/main/kotlin/adventofcode/december12y22/input").readLines()

data class Hill(val c : Char, val height : Char, var steps : Int)

fun part1(input : List<String>) : Int {
    val map = mapInput(input)

    fun floodFill(x : Int, y : Int, steps: Int, height : Char) {
        val hill = map.getOrNull(x)?.getOrNull(y)
        if ((hill?.steps ?: -1) < steps || (hill?.height?.minus(height) ?: 2) > 1) return
        hill?.steps = steps

        (-1..1).forEach { dx -> (-1..1).forEach { dy ->
            if (abs(dx+dy) == 1) floodFill(x + dx, y + dy, hill!!.steps + 1, hill!!.height)
        } }
    }

    map.forEachIndexed { x, col -> col.forEachIndexed { y, h -> if (h.c == 'S') floodFill(x, y, 0, 'a') }  }
    map.forEachIndexed { x, col -> col.forEachIndexed { y, h -> if (h.c == 'E') return map[x][y].steps }  }
    throw Exception("No Solution Found")
}


fun mapInput(input: List<String>) : List<List<Hill>> =
    (input[0].indices).map { x -> (input.indices).map { y -> Hill(input[y][x], when (input[y][x]) {
        'S' -> 'a'
        'E' -> 'z'
        else -> input[y][x] },
        Int.MAX_VALUE)
    } }

fun main() = println( part1(input) )