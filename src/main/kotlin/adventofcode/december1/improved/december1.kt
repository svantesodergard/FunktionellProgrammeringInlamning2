/*
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/reduce.html
    https://www.reddit.com/r/adventofcode/comments/r66vow/comment/hmrhogs/?utm_source=share&utm_medium=web2x&context=3
 */
package adventofcode.december1.improved

import java.io.File

fun main() {
    val input = File("src/main/kotlin/adventofcode/december1/input").readLines().toList()
    println( part1(input) )
    //println( part2(input) )
}

fun part1(input : List<String>, entries: List<Int> = input.map { it.toInt() }) =
    entries.filter { 2020 - it in entries }.reduce { a, e -> a * e }

// fun part2(input : List<String>, entries: List<Int> = input.map { it.toInt() }) =
//    entries.filter { 2020 - it in entries }
