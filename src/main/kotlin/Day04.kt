package dev.juanvega

import kotlin.math.max

fun main() {
    val dayId = "Day04"
    val debug = consoleDebug(true)

    fun buildGrid(lines: List<String>): Array<CharArray> =
        lines.map { line ->
            line.toCharArray()
        }.toTypedArray()

    val directions = listOf(
        -1 to -1, -1 to 0, -1 to 1, // Top row
        0 to -1, 0 to 1,  // Middle row
        1 to -1, 1 to 0, 1 to 1   // Bottom row
    )

    fun getEightAdjacent(grid: Array<CharArray>, currentPos: Pair<Int, Int>): Set<Pair<Int, Int>> {
        val (currentRow, currentCol) = currentPos
        val numRows = grid.size
        val numCols = grid[0].size

        return directions.mapNotNull { (shiftRow, shiftCol) ->
            val newRow = currentRow + shiftRow
            val newCol = currentCol + shiftCol
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                newRow to newCol
            } else {
                null
            }
        }.toSet()
    }


    fun part1(lines: List<String>): Long {
        var availableRolls = 0L
        val grid = buildGrid(lines)
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '@') {
                    val nearRolls = getEightAdjacent(grid, (i to j)).filter { pos ->
                        val (neighbourRow, neighbourCol) = pos
                        grid[neighbourRow][neighbourCol] == '@'
                    }
                    debug("Found $nearRolls for $i,$j")
                    availableRolls += if (nearRolls.size < 4) 1 else 0
                }
            }
        }
        return availableRolls
    }


    fun part2(lines: List<String>): Long = -2

    val testPart1 = part1(readInput(dayId, isTest = true))
    check(testPart1 == 13L) {
        "Test Part 1 failed with $testPart1"
    }

    val part1 = part1(readInput(dayId))
    println("Part 1: $part1")
    check(part1 == 1564L) {
        "Part 1 failed with $part1"
    }

//    val testPart2 = part2(readInput(dayId, isTest = true))
//    check(testPart2 == 3121910778619L) {
//        "Test Part 2 failed with $testPart2"
//    }
//
//    val part2 = part2(readInput(dayId))
//    println("Part 2: $part2")
//    check(part2 == 16946L) {
//        "Part 2 failed with $part2"
//    }


}