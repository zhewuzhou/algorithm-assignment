package zhewuzhou.me.dp

/*
Same confusion about the k = Infinity problem.
T[i-1][k-1][0] = T[i-1][k][0] is kind of weird for me
k cannot be infinite since there are at most n/2 transactions for n prices.
Finally I found out that the meaning of k is exactly the same as i(A transaction could happen with each price).
And the 2-D DP recurrence relation is enough for this problem(instead of 3-D):
 */
fun maxProfit(prices: IntArray, fee: Int): Int {
    if (prices.size < 2) return 0
    val states = Array(prices.size) {
        IntArray(2)
    }
    states[0][1] = -prices[0]
    states[0][0] = 0
    for (i in 1..prices.lastIndex) {
        states[i][0] = Math.max(states[i - 1][0], states[i - 1][1] + prices[i] - fee)
        states[i][1] = Math.max(states[i - 1][1], states[i - 1][0] - prices[i])
    }
    return states.last()[0]
}

fun maxProfitCoolDown(prices: IntArray): Int {
    if (prices.size < 2) return 0
    val states = Array(prices.size) {
        IntArray(2)
    }
    states[0][1] = -prices[0]
    states[0][0] = 0
    for (i in 1..prices.lastIndex) {
        states[i][0] = Math.max(states[i - 1][0], states[i - 1][1] + prices[i])
        states[i][1] = when (i < 2) {
            true -> Math.max(states[i - 1][1], -prices[i])
            false -> Math.max(states[i - 1][1], states[i - 2][0] - prices[i])
        }
    }
    return states.last()[0]
}
