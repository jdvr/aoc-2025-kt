package dev.juanvega

fun main() {
    val dayId = "Day01"
    val DEBUG = false
    val debug = consoleDebug(DEBUG)
    fun part1() {
        val lines = readInput(dayId)

        val right: (Int, Int) -> Int = { pos, steps ->
            debug("Rotating to right $pos by $steps")
            pos + steps
        }
        val left: (Int, Int) -> Int = { pos, steps ->
            debug("Rotating to left $pos by $steps")
            pos - steps
        }

        val adjustment: (Int) -> Int = { pos ->
            val res = ((pos % 100) + 100) % 100
            debug("Adjusting $pos to $res")
            res
        }

        var pos = 50
        var zeros = 0
        lines.forEach {
            debug("The dial is $pos")
            val rotation = if ("L" in it) {
                left
            } else {
                right
            }
            val steps = it.slice(1 until it.length).toInt()

            val current = adjustment(rotation(pos, steps))
            pos = current
            zeros += if (current == 0) 1 else 0
        }
        println("The password is $zeros")

    }

    part1()
}