package zhewuzhou.me.dp

fun nthUglyNumber(n: Int): Int {
    if (n < 1) return 0
    val result = mutableListOf<Int>(1)
    var factor2 = 0
    var factor3 = 0
    var factor5 = 0
    while (result.size < n) {
        val next2 = result[factor2] * 2
        val next3 = result[factor3] * 3
        val next5 = result[factor5] * 5
        val next = Math.min(next2, Math.min(next3, next5))
        result.add(next)
        if (next == next2) factor2 += 1
        if (next == next3) factor3 += 1
        if (next == next5) factor5 += 1
    }
    return result[n - 1]
}
