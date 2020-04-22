package zhewuzhou.me.leetcode180

import java.util.*

fun findMin(nums: IntArray): Int {
    if(nums.isEmpty()) return Int.MIN_VALUE
    return PriorityQueue(nums.toList()).peek()
}
