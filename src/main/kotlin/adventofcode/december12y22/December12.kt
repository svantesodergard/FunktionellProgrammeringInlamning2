package adventofcode.december12y22

import java.io.File
import kotlin.math.abs

private val input = File("src/main/kotlin/adventofcode/december12y22/input").readLines()

fun part1(input : List<String>) : Int {
    val map = mapInput(input)
    val heights = map.map { it.map { c -> when (c) {
        'S' -> 'a'
        'E' -> 'z'
        else -> c
    } } }
    val leastSteps = map.map { it.map { Int.MAX_VALUE }.toMutableList() }.toMutableList()

    fun floodFill(coordinate : Pair<Int, Int>, steps : Int, height : Char) {
        val x = coordinate.first; val y = coordinate.second

        if (x < 0 || x >= map.size || y < 0 || y >= map[0].size) {
            return
        }

        if (steps >= leastSteps[x][y]) {
            return
        }

        if (heights[x][y] - height > 1) {
            return
        }

        leastSteps[x][y] = steps
        (-1..1).forEach { dx -> (-1 .. 1).forEach {
            dy ->
            if (abs(dx + dy) == 1) floodFill(Pair(x + dx, y + dy), steps + 1, heights[x][y])
        } }
    }

    var start = Pair(0, 0)
    map.forEachIndexed { x, col -> col.forEachIndexed { y, pos -> if (pos == 'S') start = Pair(x, y) }  }
    floodFill(start, 0, 'a')

    var end = Pair(0, 0)
    map.forEachIndexed { x, col -> col.forEachIndexed { y, pos -> if (pos == 'E') end = Pair(x, y) }  }

    return leastSteps[end.first][end.second]
}


fun mapInput(input: List<String>) : List<List<Char>> =
    (input[0].indices).map { x -> (input.indices).map { y -> input[y][x] } }

fun main() = println( part1(input) )