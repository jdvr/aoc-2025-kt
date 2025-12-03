package dev.juanvega

import kotlin.math.max

fun main() {
    val dayId = "Day03"
    val DEBUG = true
    val debug = consoleDebug(DEBUG)

    fun part1(banks: List<String>): Long =
        banks.sumOf { bank ->
            val bankSize = bank.length
            val digits = bank.map { it.digitToInt().toLong() }
            var maxJoltage = 0L
            (0 until bankSize - 1).forEach { idx ->
                val first = digits[idx]
                val rest = digits.subList(idx + 1, bankSize)
                val second = rest.max()
                val joltage = first * 10 + second
                maxJoltage = max(joltage, maxJoltage)
            }
            maxJoltage
        }

    fun part2(banks: List<String>): Long = -2

    val testPart1 = part1(readInput(dayId, isTest = true))
    check(testPart1 == 357L) {
        "Test Part 1 failed with $testPart1"
    }

    val part1 = part1(readInput(dayId))
    println("Part 1: $part1")
    check(part1 == 16946L) {
        "Part 1 failed with $part1"
    }

    val testPart2 = part2(readInput(dayId, isTest = true))
    check(testPart2 == 3121910778619L) {
        "Test Part 2 failed with $testPart2"
    }

    val part2 = part2(readInput(dayId))
    println("Part 2: $part2")
    check(part2 == 16946L) {
        "Part 2 failed with $part2"
    }


}