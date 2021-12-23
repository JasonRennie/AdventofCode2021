import kotlin.system.measureTimeMillis

fun main() {
    fun part1(lines: List<String>): Int {
        var pos = 0
        var depth = 0

        lines.forEach {
            val command = it.split(" ")
            when (command[0]) {
                "forward" -> pos += command[1].toInt()
                "up" -> depth -= command[1].toInt()
                "down" -> depth += command[1].toInt()
            }
        }
        return pos*depth
    }

    fun part2(lines: List<String>): Int {
        var pos = 0
        var depth = 0
        var aim = 0

        lines.forEach {
            val command = it.split(" ")
            when (command[0]) {
                "forward" -> {
                    pos += command[1].toInt()
                    depth += aim*command[1].toInt()
                }
                "up" -> aim -= command[1].toInt()
                "down" -> aim += command[1].toInt()
            }
        }
        return pos*depth
    }

    // Test
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    println("Test 1 passed!")
    check(part2(testInput) == 900)
    println("Test 2 passed!")

    // Use given input
    val input = readInput("Day02")
    var time = measureTimeMillis {
        println("Part 1: ${part1(input)}")
    }
    println("Time: $time ms")
    time = measureTimeMillis {
        println("Part 2: ${part2(input)}")
    }
    println("Time: $time ms")
}
