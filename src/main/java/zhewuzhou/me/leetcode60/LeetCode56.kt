package zhewuzhou.me.leetcode60

import java.util.*
import kotlin.Comparator


fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf()
    intervals.sortWith(Comparator { lhs, rhs ->
        when (lhs[1] == rhs[1]) {
            true -> lhs[0].compareTo(rhs[0])
            false -> lhs[1].compareTo(rhs[1])
        }
    })
    val res = Stack<IntArray>()
    res.push(intervals[0])
    var i = 1
    while (i <= intervals.lastIndex) {
        when (res.peek()[1] < intervals[i][0]) {
            true -> res.push(intervals[i])
            else -> {
                var low = Math.min(res.pop()!![0], intervals[i][0])
                while (res.isNotEmpty() && res.peek()[1] >= low) {
                    low = Math.min(res.pop()!![0], low)
                }
                res.push(arrayOf(low, intervals[i][1]).toIntArray())
            }
        }
        i += 1
    }
    return res.toTypedArray()
}
