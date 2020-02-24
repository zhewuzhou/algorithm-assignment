package zhewuzhou.me.leetcode20

fun addTwoNumbers(l1: List<Int>?, l2: List<Int>?): List<Int> {
    val l1Int = listToInt(l1) ?: 0
    val l2Int = listToInt(l2) ?: 0
    val sum = l1Int + l2Int
    return sum.toString().reversed().map { it.toString().toInt() }
}

fun Int.pow(exp: Int): Int {
    val value = this
    var result = 1
    repeat(exp) {
        result = result.times(value)
    }
    return result
}

private fun listToInt(list: List<Int>?) =
        list?.reduceIndexed { index, acc, it -> acc + it * (10.pow(index)) }
