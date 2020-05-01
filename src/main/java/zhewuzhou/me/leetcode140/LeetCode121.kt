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

fun maxProfit(k: Int, prices: IntArray): Int {
    val days = prices.size
    val metrics = Array(k + 1) {
        IntArray(days + 1) {
            0
        }
    }
    for (i in 2..days) {
        metrics[1][i] = maxProfitOneTransaction(prices, 1, i)
    }
    for (i in 2..k) {
        for (j in 2..days) {
            val noTradeOnD = metrics[i][j - 1]
            var tradeOnD = 0
            for (m in 1 until j) {
                val possible = metrics[i - 1][m - 1] + prices[j - 1] - prices[m - 1]
                tradeOnD = Math.max(tradeOnD, possible)
            }
            metrics[i][j] = Math.max(noTradeOnD, tradeOnD)
        }
    }
    return metrics[k][prices.size]
}
