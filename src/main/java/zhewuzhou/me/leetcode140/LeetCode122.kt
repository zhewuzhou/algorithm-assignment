package zhewuzhou.me.leetcode140

import java.util.*

fun maxProfitM(prices: IntArray): Int {
    if (prices.size < 2) return 0
    val s = Stack<Int>()
    var maxProfit = 0
    for (p in prices) {
        if (s.isEmpty() || p > s.peek()) {
            s.push(p)
        } else {
            if (s.size >= 2) {
                maxProfit += s.peek() - s[0]
            }
            s.clear()
            s.push(p)
        }
    }
    return if (s.isNotEmpty() && s.size > 2) (maxProfit + (s.peek() - s[0])) else maxProfit
}
