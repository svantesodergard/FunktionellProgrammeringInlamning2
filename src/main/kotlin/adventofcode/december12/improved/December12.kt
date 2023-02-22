/*
Inspired By:
https://www.reddit.com/r/adventofcode/comments/rehj2r/comment/ho8swsk/?utm_source=share&utm_medium=web2x&context=3
 */
package adventofcode.december12.improved

import adventofcode.december12.isLowercase
import adventofcode.december12.mapCaves
import java.io.File
import kotlin.system.measureTimeMillis

private val input = File("src/main/kotlin/adventofcode/december12/input").readLines()
fun main() {
    println( measureTimeMillis {  part1(input) } )
}

fun part1(input: List<String>) : Int {
    val caves = mapCaves(input)
    var paths = listOf( listOf("start") )

    while (paths.any { it.last() != "end" }) {
        paths = paths.flatMap { path -> when {
            path.last() == "end" -> listOf(path)
            else -> ( caves.getValue(path.last()).filterNot { it.isLowercase() && path.contains(it) } )
                .map { path + it }
        } }
    }

    return paths.size
}