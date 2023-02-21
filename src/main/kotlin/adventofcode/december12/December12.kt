package adventofcode.december12

import java.io.File

private val input = File("src/main/kotlin/adventofcode/december12/input").readLines()
fun main() {
    println( part1(input) )
    println( part2(input) )
}

fun part2(input: List<String>) : Int {
    val caves = mapCaves(input)

    fun String.getPathsFrom(path : List<String>) : Int {
        if (this == "end") {
            return 1
        }

        if (path.count {it == "start"} != 1) {
            return 0
        }

        if (path.count { it == this } > 2 && this.isLowercase()) {
            return 0
        }

        val visitedLowerCaseCaves = path.filter { it.isLowercase() && it != path.last() }
        val duplicateVisitAllowed = visitedLowerCaseCaves.toSet().size == visitedLowerCaseCaves.size

        if (!duplicateVisitAllowed && path.count { it == this } > 1 && this.isLowercase()) {
            return 0
        }

        var paths = 0
        caves[this]?.forEach {
            paths += it.getPathsFrom(path.plus(it))
        }
        return paths
    }

    return "start".getPathsFrom(listOf("start"))
}

fun part1(input: List<String>) : Int {
    val caves = mapCaves(input)

    fun String.getPathsFrom(path : List<String>) : Int {
        if (this == "end") {
            return 1
        }

        if (path.count { it == this } > 1 && this.isLowercase()) {
            return 0
        }

        var paths = 0
        caves[this]?.forEach {
            paths += it.getPathsFrom(path.plus(it))
        }
        return paths
    }

    return "start".getPathsFrom(listOf("start"))
}


fun String.isLowercase() = this.lowercase() == this

fun mapCaves(input : List<String>) : Map<String, List<String>> {
    val caveToConnections = mutableMapOf<String, MutableList<String>>()

    fun addConnection(cave : String, connection : String) =
        caveToConnections[cave]?.add(connection) ?: caveToConnections.put(cave, mutableListOf(connection))

    input.forEach {
        val cave = it.substring(0, it.indexOf('-'))
        val connection = it.substring(it.indexOf('-') + 1)
        addConnection(cave, connection)
        addConnection(connection, cave)
    }

    return caveToConnections
}