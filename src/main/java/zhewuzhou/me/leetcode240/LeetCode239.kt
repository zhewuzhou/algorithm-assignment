package zhewuzhou.me.leetcode240

import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return intArrayOf()
    val result = IntArray(nums.size - k + 1)
    val win = LinkedList<Int>()
    for (i in nums.indices) {
        while (win.size > 0 && win.peekFirst() <= i - k) {
            win.pollFirst()
        }
        while (win.size > 0 && nums[win.peekLast()] < nums[i]) {
            win.pollLast()
        }
        win.offerLast(i)
        if (i >= k - 1) {
            result[i - k + 1] = nums[win.peekFirst()]
        }
    }
    return result
}
