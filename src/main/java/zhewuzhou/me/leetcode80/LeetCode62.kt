package zhewuzhou.me.leetcode80

fun uniquePaths(m: Int, n: Int): Int {
    val matrix = Array<IntArray>(m) {
        IntArray(n)
    }
    for (i in 1 until n) {
        matrix[0][i] = 1
    }
    for (i in 1 until m) {
        matrix[i][0] = 1
    }
    for (i in 1 until m) {
        for (j in 1 until n) {
            matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j]
        }
    }
    return matrix[m - 1][n - 1]
}
