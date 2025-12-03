package dev.juanvega

import kotlin.io.path.Path
import kotlin.io.path.readLines


/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String, isTest: Boolean = false) = Path("test_files/$name${ if (isTest) "_test" else ""}.txt").readLines().filter { it.isNotEmpty() }

fun consoleDebug(enabled: Boolean): (String) -> Unit = { line -> if (enabled) println(line) else Unit }

fun Long.isEven(): Boolean = this % 2 == 0L
fun Int.isEven(): Boolean = this % 2 == 0