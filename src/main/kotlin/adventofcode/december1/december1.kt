package adventofcode.december1

import java.io.File

fun main() {
    val input = File("src/main/kotlin/adventofcode/december1/input").readLines().toList()
    println( part2(input) )
}

fun part1(input : List<String>) : Int {
    val entries = input.map { it.toInt() }
    entries.forEach { a -> entries.find { a + it == 2020 }?.let { return a * it } }
    throw Exception("No Solution Found")
}

fun part2(input: List<String>) : Int {
    val entries = input.map { it.toInt() }
    entries.forEach { a -> entries.forEach { b -> entries.find { a + b + it == 2020 }?.let { return a * b * it } } }
    throw Exception("No Solution Found")
}