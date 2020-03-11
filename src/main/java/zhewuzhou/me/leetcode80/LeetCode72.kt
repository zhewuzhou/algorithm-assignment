package zhewuzhou.me.leetcode80

fun minDistance(from: String, to: String): Int {
    val row = from.length + 1
    val col = to.length + 1
    val dp = Array<IntArray>(row) {
        IntArray(col)
    }
    for (i in 0 until col) {
        dp[0][i] = i //insert times
    }
    for (i in 0 until row) {
        dp[i][0] = i //delete times
    }
    for (i in 1 until row) {
        for (j in 1 until col) {
            when (from[i - 1] == to[j - 1]) {
                true -> dp[i][j] = dp[i - 1][j - 1]
                false -> {
                    val replace = dp[i - 1][j - 1] + 1
                    val delete = dp[i - 1][j] + 1
                    val add = dp[i][j - 1] + 1
                    dp[i][j] = Math.min(Math.min(replace, delete), add)
                }
            }
        }
    }
    return dp[row - 1][col - 1]
}
