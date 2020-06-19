package zhewuzhou.me.leetcode240

import java.util.*

fun maxSlidingWindowQ(nums: IntArray, k: Int): IntArray {
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

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return intArrayOf()
    val result = IntArray(nums.size - k + 1)
    val window = TreeMap<Int, Int>()
    for (i in nums.indices) {
        if (window.containsKey(nums[i])) {
            window[nums[i]] = window[nums[i]]!! + 1
        } else {
            window[nums[i]] = 1
        }
        if (i >= k) {
            if (window[nums[i - k]]!! > 1) {
                window[nums[i - k]] = window[nums[i - k]]!! - 1
            } else {
                window.remove(nums[i - k])
            }
        }
        if (i >= k - 1) {
            result[i - k + 1] = window.lastKey()
        }
    }
    return result
}
