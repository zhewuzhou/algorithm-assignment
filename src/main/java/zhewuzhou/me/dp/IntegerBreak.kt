package zhewuzhou.me.dp

fun integerBreakSlow(n: Int): Int {
    if (n < 2 || n > 58) return 0
    val matrix = IntArray(n + 1) {
        1
    }
    for (i in 3..n) {
        for (j in 1..i / 2) {
            matrix[i] = Math.max(matrix[i], Math.max(matrix[j], j) * Math.max(matrix[i - j], i - j))
        }
    }
    return matrix[n]
}

fun integerBreak(n: Int): Int {
    if (n <= 1 || n > 58) return 0
    if (n == 2) return 1
    if (n == 3) return 2
    var result = 1
    var threeExpo = n / 3
    var twoExpo = 1
    when (n % 3) {
        1 -> {
            threeExpo -= 1
            twoExpo = 2
        }
        0 -> twoExpo = 0
    }
    repeat(threeExpo) {
        result *= 3
    }
    repeat(twoExpo) {
        result *= 2
    }
    return result
}
