import kotlin.system.measureTimeMillis

fun main() {
    fun part1(lines: List<String>): Int {
        var counters = List(lines[0].length) {0}
        val total = lines.size

        lines.forEach {
            val bits = it.toList().map { n -> n.digitToInt() }
            counters = counters.zip(bits) {a,b -> a + b}
        }

        val gamma = counters.map { if (it > total/2) 1 else 0 }.joinToString("").toInt(2)
        val epsilon = counters.map { if (it > total/2) 0 else 1 }.joinToString("").toInt(2)

        return gamma*epsilon
    }

    fun part2helper(lines: List<String>, bitIndex: Int, ratingType: String): Int {
        var counter = 0
        lines.forEach {
            when (it[bitIndex].digitToInt()) {
                1 -> counter += 1
                0 -> counter -= 1
            }
        }

        val correctBit = if ((ratingType == "oxygen" && counter >= 0) || (ratingType == "co2" && counter < 0)) { 1 } else { 0 }
        val filtered = lines.filter { it[bitIndex].digitToInt() == correctBit }

        if (filtered.size == 1) {
            return filtered[0].toInt(2)
        }
        return part2helper(filtered, bitIndex+1, ratingType)
    }

    fun part2(lines: List<String>): Int {
        return part2helper(lines, 0, "oxygen")*part2helper(lines, 0, "co2")
    }

    // Test
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    println("Test 1 passed!")
    check(part2(testInput) == 230)
    println("Test 2 passed!")

    // Use given input
    val input = readInput("Day03")
    var time = measureTimeMillis {
        println("Part 1: ${part1(input)}")
    }
    println("Time: $time ms")
    time = measureTimeMillis {
        println("Part 2: ${part2(input)}")
    }
    println("Time: $time ms")
}
