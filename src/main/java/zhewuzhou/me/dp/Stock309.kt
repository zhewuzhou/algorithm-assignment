package zhewuzhou.me.dp

//Multiple status DP
fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty() || prices.size < 2) return 0
    val s0 = IntArray(prices.size)
    val s1 = IntArray(prices.size)
    val s2 = IntArray(prices.size)
    s0[0] = 0
    s1[0] = -prices[0]
    s2[0] = Int.MIN_VALUE
    for (i in 1..prices.lastIndex) {
        s0[i] = Math.max(s0[i - 1], s2[i - 1])
        s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1])
        s2[i] = s1[i - 1] + prices[i]
    }
    return Math.max(s0.last(), s2.last())
}
