package zhewuzhou.me.leetcode

import java.util.*


class Digit(val value: Int, val index: Int) :
        Comparable<Digit> {

    override fun compareTo(other: Digit): Int {
        return COMPARATOR.compare(this, other)
    }

    companion object {
        private val COMPARATOR =
                Comparator.comparingInt<Digit> { it.value }
                        .thenComparingInt { it.index }
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
    val nthFromLeft = 1
    val digitsPair = numInString
            .substring(nthFromLeft
            ).mapIndexed { index, digit -> Digit(digit.toInt(), index + nthFromLeft) }
    val queue: PriorityQueue<Digit> = PriorityQueue(numInString.length - nthFromLeft, Collections.reverseOrder());
    digitsPair.forEach { queue.offer(it) }
    val largestPossible = queue.poll()
    if (largestPossible.value > numInString[nthFromLeft - 1].toInt()) {
        return numInString.swap(nthFromLeft - 1, largestPossible.index).toInt()
    }
    return 0
}