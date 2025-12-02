package dev.juanvega

fun main() {
    val dayId = "Day01"
    val DEBUG = false
    val debug = consoleDebug(DEBUG)
    val lines = readInput(dayId)

    val adjustment: (Int) -> Int = { pos ->
        val res = ((pos % 100) + 100) % 100
        debug("Adjusting $pos to $res")
        res
    }
    infix fun Int.moveLeft(steps: Int) = adjustment(this - steps)
    infix fun Int.moveRight(steps: Int) = adjustment(this + steps)


    fun part1() {
        var pos = 50
        var zeros = 0

        lines.forEach {
            debug("The dial is $pos")
            val isLeftRotation = "L" in it
            val steps = it.slice(1 until it.length).toInt()

            pos = if (isLeftRotation) {
                pos moveLeft steps
            } else {
                pos moveRight steps
            }
            zeros += if (pos == 0) 1 else 0
        }
        println("[part 1] The password is $zeros")

    }

    fun part2() {
        var pos = 50
        var zeros = 0

        lines.forEach {
            debug("The dial is $pos")
            val steps = it.slice(1 until it.length).toInt()
            val isLeftRotation = "L" in it
            val stepsToZero = when  {
                pos == 0 -> 100
                isLeftRotation -> pos
                else -> 100 - pos
            }
            if (steps >= stepsToZero) {
                zeros++
                zeros += (steps - stepsToZero) / 100
            }
            pos = if (isLeftRotation) {
                pos moveLeft steps
            } else {
                pos moveRight steps
            }
        }
        println("[part 2] The password is $zeros")

    }

    part1()
    part2() // 6700
}