package zhewuzhou.me.leetcode140

import java.util.*

fun maxProfitQ(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    val queue = PriorityQueue<Int>(prices.size)
    val pl = prices.toList().map { -it }
    var maxProfit = 0
    for (i in 0 until pl.lastIndex) {
        queue.addAll(pl.subList(i + 1, pl.size))
        val newPossibility = Math.abs(queue.peek()) - prices[i]
        if (maxProfit < newPossibility) {
            maxProfit = newPossibility
        }
        queue.clear()
    }
    return maxProfit
}

fun maxProfitOneTransaction(prices: IntArray, start: Int, end: Int): Int {
    if ((end - start) < 1) return 0
    var maxProfit = 0
    var minPrice = prices[start - 1]
    for (i in start until end) {
        if (prices[i] > prices[i - 1]) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice)
        } else {
            minPrice = Math.min(minPrice, prices[i])
        }
    }
    return maxProfit
}

fun maxProfit(prices: IntArray): Int {
    if (prices.size < 2) return 0
    var maxProfit = maxProfitOneTransaction(prices, 1, prices.size)
    for (i in 2..(prices.size - 2)) {
        val possible = maxProfitOneTransaction(prices, 1, i) +
            maxProfitOneTransaction(prices, i + 1, prices.size)
        if (possible > maxProfit) {
            maxProfit = possible
        }
    }
    return maxProfit
}

fun maxProfitRecur(k: Int, prices: IntArray): Int {
    fun dpRecur(k: Int, d: Int): Int {
        if (d < 2) return 0
        if (k == 1) return maxProfitOneTransaction(prices, 1, d)
        val noTradeOnD = dpRecur(k, d - 1)
        var tradeOnD = 0
        for (m in 1 until d) {
            tradeOnD = Math.max(dpRecur(k - 1, m - 1) + (prices[d - 1] - prices[m - 1]), tradeOnD)
        }
        return Math.max(noTradeOnD, tradeOnD)
    }
    return dpRecur(k, prices.size)
}

fun maxProfitSlow(k: Int, prices: IntArray): Int {
    val days = prices.size
    val times = Math.min(k, days / 2)
    if (times < 1 || prices.size < 2) return 0
    val metrics = Array(times + 1) {
        IntArray(days) {
            0
        }
    }
    for (i in 1..times) {
        for (j in 1 until days) {
            var tradeOnD = 0
            for (m in 0 until j) {
                val possible = metrics[i - 1][m] + prices[j] - prices[m]
                tradeOnD = Math.max(tradeOnD, possible)
            }
            metrics[i][j] = Math.max(metrics[i][j - 1], tradeOnD)
        }
    }
    return metrics[times][prices.lastIndex]
}

fun maxProfit(k: Int, prices: IntArray): Int {
    if (prices.size < 2) return 0
    if (k > prices.size / 2) {
        var res = 0
        for (i in 1 until prices.size) {
            res += Math.max(0, prices[i] - prices[i - 1])
        }
        return res
    }
    val dp = Array(k + 1) { IntArray(prices.size) { 0 } }
    for (i in 1..k) {
        var maxDiff = -prices[0]
        for (j in 1 until prices.size) {
            dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j])
            maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j])
        }
    }
    return dp[k][prices.size - 1]
}
