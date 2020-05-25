package zhewuzhou.me.dp

fun integerBreak(n: Int): Int {
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
