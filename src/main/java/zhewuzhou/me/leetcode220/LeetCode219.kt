package zhewuzhou.me.leetcode220

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    if (k < 1 || nums.isEmpty()) return false
    val window = mutableSetOf<Int>()
    val full = k + 1
    if (nums.size <= full) {
        return nums.toSet().size != nums.size
    }

    var hi = 0
    while (hi < nums.size) {
        window.add(nums[hi])
        if (hi >= k) {
            if (window.size < full) {
                return true
            }
            window.remove(nums[hi - k])
        }
        hi += 1
    }
    return false
}
