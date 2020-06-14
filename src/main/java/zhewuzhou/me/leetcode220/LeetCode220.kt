package zhewuzhou.me.leetcode220

import java.util.*


fun containsNearbyAlmostDuplicateSlow(nums: IntArray, k: Int, t: Int): Boolean {
    if (nums.isEmpty()
        || k < 1
        || t < 0
        || nums.size == 1) return false
    for (i in 0 until nums.lastIndex) {
        for (j in (i + 1)..Math.min(i + k, nums.lastIndex)) {
            if (Math.abs(nums[i] - nums[j]) <= t) {
                return true
            }
        }
    }
    return false
}

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    if (nums.isEmpty()
        || k < 1
        || t < 0
        || nums.size == 1) return false
    val window = TreeSet<Long>()
    for (i in nums.indices) {
        val e = nums[i].toLong()
        val floor = window.floor(e + t)
        val ceiling = window.ceiling(e - t)
        if (floor != null && floor >= e
            || (ceiling != null && ceiling <= e)) {
            return true
        }
        window.add(e)
        if (i >= k) {
            window.remove(nums[i - k].toLong())
        }
    }
    return false
}
