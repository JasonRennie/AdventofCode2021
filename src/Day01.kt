import kotlin.system.measureTimeMillis

fun main() {
    fun part1(lines: List<String>): Int {
        return lines.filterIndexed { i, n -> i != 0 && n.toInt() > lines[i-1].toInt() }.size
    }

    fun part2(lines: List<String>): Int {
        return lines.filterIndexed { i, n -> i > 2 && n.toInt() > lines[i-3].toInt() }.size
    }

    // Test
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    println("Test 1 passed!")
    check(part2(testInput) == 5)
    println("Test 2 passed!")

    // Use given input
    val input = readInput("Day01")
    var time = measureTimeMillis {
        println("Part 1: ${part1(input)}")
    }
    println("Time: $time ms")
    time = measureTimeMillis {
        println("Part 2: ${part2(input)}")
    }
    println("Time: $time ms")
}
