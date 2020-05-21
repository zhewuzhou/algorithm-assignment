package zhewuzhou.me.dp

fun coinChange(coins: IntArray, amount: Int): Int {
    val matrix = IntArray(amount + 1) {
        Int.MAX_VALUE
    }
    matrix[0] = 0
    for (a in 1..amount) {
        for (c in coins) {
            if (a - c >= 0 && matrix[a - c] != Int.MAX_VALUE) {
                matrix[a] = Math.min(matrix[a - c] + 1, matrix[a])
            }
        }
    }
    return if (matrix[amount] == Int.MAX_VALUE) -1 else matrix[amount]
}
