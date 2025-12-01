package dev.juanvega

import kotlin.io.path.Path
import kotlin.io.path.readLines


/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String, skipEmpty: Boolean = true) = Path("test_files/$name.txt").readLines().filter { it.isNotEmpty() }

fun consoleDebug(enabled: Boolean): (String) -> Unit = { line -> if (enabled) println(line) else Unit }