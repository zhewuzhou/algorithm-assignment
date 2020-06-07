package zhewuzhou.me.leetcode220

fun isHappy(n: Int): Boolean {
    if (n <= 0) return false
    var result = calculateSquares(n)
    val history = mutableSetOf(result)
    while (result != 1) {
        val s = calculateSquares(result)
        if (history.contains(s)) {
            return false
        }
        history.add(s)
        result = s
    }
    return true
}

private fun calculateSquares(n: Int): Int {
    var sumOfSquares = 0
    var div = n
    while (div >= 10) {
        val d = div % 10
        sumOfSquares += d * d
        div /= 10
    }
    sumOfSquares += div * div
    return sumOfSquares
}

