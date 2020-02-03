package zhewuzhou.me.leetcode

import java.util.*

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
    val digitsPair = numInString
            .substring(1
            ).mapIndexed { index, digit -> Pair(digit, numInString.length - index) }
    val queue: PriorityQueue<Pair<Char, Int>> = PriorityQueue(numInString.length - 1, Collections.reverseOrder());
    digitsPair.forEach { queue.offer(it) }
    val largestPossible = queue.poll()
    if (largestPossible.first > numInString[0]) {
        return numInString.swap(0, largestPossible.second).toInt()
    }
    return 0
}