package zhewuzhou.me.dp

fun maximumSwap(num: Int): Int {
    if (num < 10) return num
    val digits = splitToDigits(num)
    for (i in digits.lastIndex downTo 1) {
        val max = maxFromPos(digits, i - 1)
        if (max.first > digits[i]) {
            val cur = digits[i]
            digits[i] = max.first
            digits[max.second] = cur
            return toInt(digits)
        }
    }
    return num
}

private fun toInt(list: List<Int>): Int {
    var result = 0
    list.forEachIndexed { index, d ->
        var factor = 1
        repeat(index) {
            factor *= 10
        }
        result += factor * d
    }
    return result
}

fun splitToDigits(num: Int): MutableList<Int> {
    var n = num
    val result = mutableListOf<Int>()
    while (n >= 10) {
        result.add(n % 10)
        n /= 10
    }
    result.add(n)
    return result
}

private fun maxFromPos(list: List<Int>, start: Int): Pair<Int, Int> {
    var max = Pair(0, 0)
    for (i in start downTo 0) {
        if (list[i] >= max.first) {
            max = Pair(list[i], i)
        }
    }
    return max
}
