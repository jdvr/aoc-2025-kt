package dev.juanvega

fun main() {
    val dayId = "Day02"
    val DEBUG = true
    val debug = consoleDebug(DEBUG)


    fun part1(lines: List<String>): Long {
        val ranges = lines[0].split(",").map {
            val (start, end) = it.split("-")
            start.toLong() .. end.toLong()
        }

        val invalids = ranges.map { range ->
            range.filter { id ->
                val asText = id.toString()
                asText.length.isEven() && run {
                    val (left, right) = asText.chunked(asText.length / 2)
                    left == right
                }
            }
        }.flatten()
        invalids.forEach {
            debug("found $it")
        }
        return invalids.sum()
    }

    fun part2(lines: List<String>): Long = -2

    val res1Test = part1(readInput(dayId, isTest = true))
    println("Part 1: $res1Test")
    check(res1Test == 1227775554L)
    val res1 = part1(readInput(dayId))
    println("Part 1: $res1")
    check(res1 == -2L)

    val res2Test = part2(readInput(dayId, isTest = true))
    check(res2Test == 4174379265L) {
        "part 2 test failed with $res2Test"
    }

    val res2 = part2(readInput(dayId))
    println("Part 2: $res2")
    check(res2 == -2L) {
        "part 2 failed with $res2"
    }
}