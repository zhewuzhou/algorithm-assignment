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

fun maxProfit(prices: IntArray): Int {
    if (prices.size < 2) return 0
    var maxProfit = 0
    var minPrice = prices[0]
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice)
        } else {
            minPrice = Math.min(minPrice, prices[i])
        }
    }
    return maxProfit
}
