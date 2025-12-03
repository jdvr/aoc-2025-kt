package dev.juanvega

fun main() {
    val dayId = "Day02"
    val DEBUG = false
    val debug = consoleDebug(DEBUG)

    fun part1(ranges: List<LongRange>): Long {
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

    fun part2(ranges: List<LongRange>): Long {
        val invalids = ranges.map { range ->
            range.filter { id ->
                val asText = id.toString()
                val length = asText.length
                // If the pattern is repeated at least twice, then pattern must be smaller than length/2
                (1..length / 2).any { patternLength ->
                    length % patternLength == 0 && run {
                        // 1, 2, 3...
                        val pattern = asText.substring(0, patternLength)
                        (patternLength until length step patternLength).all { idx ->
                            asText.substring(idx, idx + patternLength) == pattern
                        }
                    }
                }
            }
        }.flatten()
        invalids.forEach {
            debug("found $it")
        }
        return invalids.sum()
    }

    val testRanges = readInput(dayId, isTest = true)[0].split(",").map {
        val (start, end) = it.split("-")
        start.toLong()..end.toLong()
    }

    val ranges = readInput(dayId)[0].split(",").map {
        val (start, end) = it.split("-")
        start.toLong()..end.toLong()
    }

    val res1Test = part1(testRanges)
    println("Part 1: $res1Test")
    check(res1Test == 1227775554L)
    val res1 = part1(ranges)
    println("Part 1: $res1")
    check(res1 == 18893502033)

    val res2Test = part2(testRanges)
    check(res2Test == 4174379265L) {
        "part 2 test failed with $res2Test"
    }

    val res2 = part2(ranges)
    println("Part 2: $res2")
    check(res2 == 26202168557) {
        "part 2 failed with $res2"
    }
}