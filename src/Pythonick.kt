@file:Suppress("unused", "UNUSED_PARAMETER", "SpellCheckingInspection")

import kotlin.math.absoluteValue

/**
 * Experiment to create a Python-like stdlib for Kotlin
 */

// Types

const val True = true
const val False = false

val None = null

//https://docs.python.org/3/library/functions.html

fun abs(x: Int) = x.absoluteValue

fun <E> all(iterable: List<E>) = iterable.all { isTruthy(it) }

fun <E> any(iterable: List<E>) = iterable.any { isTruthy(it) }

fun ascii(obj: Any) = repr(obj)

fun bin(x: Int): String {
    val bin = x.toString(2)
    return if (x < 0) "-0b${bin.drop(1)}" else "0b$bin"
}

fun bool(x: Any = false) = isTruthy(java.lang.Boolean.parseBoolean(x.toString()))

//fun bytearray()

fun chr(i: Int) = i.toChar()

fun divmod(a: Int, b: Int) = a / b to a % b

fun <E> enumerate(iterable: List<E>, start: Int = 0) = iterable.mapIndexed { i, e -> i + start to e }

val t = filter({ e -> e == 1 }, listOf(1, 2, 3))
fun <E> filter((E) -> Boolean, iterable: List<E>) = iterable.filter(this)

fun format(value: Any, formatSpec: String = "") = String.format(formatSpec, value)

fun hash(obj: Any) = obj.hashCode()

fun hex(x: Int): String {
    val hex = x.toString(16)
    return if (x < 0) "-0b${hex.drop(1)}" else "0b$hex"
}

fun id(obj: Any) = obj.hashCode()

fun input(prompt: String? = null): String? {
    if (prompt != null) print(prompt)
    return readLine()
}

inline fun <reified T> isinstance(obj: Any, classinfo: Class<T>) = obj is T

fun ord(c: Char) = c.toInt()

fun repr(obj: Any) = obj.toString()

private fun <T> isTruthy(value: T?): Boolean {
    when (value) {
        null -> return false
        is Int -> if (value == 0) return false
        is String -> if (value == "") return false
    }
    return true
}

fun main() {
    println(enumerate(listOf("spring", "summer"), 2))
}