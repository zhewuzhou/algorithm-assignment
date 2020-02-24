package zhewuzhou.me.leetcode20

import java.util.*


class Digit(val value: Int, val index: Int) :
        Comparable<Digit> {

    override fun compareTo(other: Digit): Int {
        return COMPARATOR.compare(this, other)
    }

    companion object {
        private val COMPARATOR =
                Comparator.comparingInt<Digit> { -it.value }
                        .thenComparingInt { -it.index }
    }
}

fun String.swap(m: Int, n: Int): String {
    assert(m in 0 until length)
    assert(n in 0 until length)
    val value = this
    return mapIndexed { index, char ->
        when (index) {
            m -> value[n]
            n -> value[m]
            else -> char
        }
    }.joinToString(separator = "")
}

fun oneChangeForMax(num: Int): Int {
    val numInString = num.toString()
    val digits = numInString
            .mapIndexed { index, digit -> Digit(digit.toInt(), index) }
    return trySwap(numInString, 1, num, digits)
}

private fun trySwap(numInString: String, from: Int, original: Int, digits: List<Digit>): Int {
    if (from == numInString.length) {
        return original
    }
    val max = PriorityQueue(digits.filter { it.index >= from }).poll()
    if (max.value > numInString[from - 1].toInt()) {
        return numInString.swap(from - 1, max.index).toInt()
    }
    return trySwap(original.toString(), from + 1, original, digits)
}
