package adventofcode.december3y22

fun part1(input : List<String>) : Int {
    val leftCompartments = input.map { it.substring(0, it.length / 2) }
    val rightCompartments = input.map { it.substring(it.length / 2) }
    return ( leftCompartments.mapIndexed { i, it -> it.first { c -> rightCompartments[i].contains(c) } }
        .sumOf { if (it.isUpperCase()) it.code - 'A'.code + 27 else it.code - 'a'.code + 1  } )
}

fun part2(input: List<String>) : Int {
    return (input.indices step 3).map { i -> input[i].first { input[i + 1].contains(it) && input[i + 2].contains(it) } }
        .sumOf { if (it.isUpperCase()) it.code - 'A'.code + 27 else it.code - 'a'.code + 1  }
}