package zhewuzhou.me.leetcode40

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
    return if (dividend > 0 && divisor > 0)
        divideHelper(-dividend, -divisor)
    else if (dividend > 0) -divideHelper(-dividend, divisor)
    else if (divisor > 0) -divideHelper(dividend, -divisor)
    else divideHelper(dividend, divisor)
}

private fun divideHelper(dividend: Int, divisor: Int): Int {
    if (divisor < dividend) return 0
    var cur = 0
    var res = 0
    while (divisor shl cur in dividend..-1 && cur < 31) cur++
    res = dividend - (divisor shl cur - 1)
    return if (res > divisor) 1 shl cur - 1 else (1 shl cur - 1) + divide(res, divisor)
}
