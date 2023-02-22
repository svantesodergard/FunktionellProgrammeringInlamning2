/*
    Inspired by:
    https://github.com/nrsherr2/advent-of-code-2022/blob/master/src/main/kotlin/Day03.kt
    https://www.reddit.com/r/adventofcode/comments/r66vow/comment/hmrhogs/?utm_source=share&utm_medium=web2x&context=3
 */
package adventofcode.december3y22.improved

import java.io.File

val input = File("src/main/kotlin/adventofcode/december3y22/input").readLines()

fun part1(input : List<String>) : Int {
    val leftCompartments = input.map { it.substring(0, it.length / 2) }
    val rightCompartments = input.map { it.substring(it.length / 2) }
    return ( leftCompartments.mapIndexed { i, it -> it.first { c -> rightCompartments[i].contains(c) } }
        .sumOf { it.getPriority() } )
}

fun part2(input: List<String>) =
    input.windowed(3, 3).map { trio -> trio[0].first { it in trio[1] && it in trio[2] } }.sumOf { it.getPriority() }

fun Char.getPriority() = if (this.isUpperCase()) this.code - 'A'.code + 27 else this.code - 'a'.code + 1