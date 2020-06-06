package zhewuzhou.me.leetcode200

fun rotate(nums: IntArray, k: Int): Unit {
    if (nums.isEmpty()) return
    val mid = k % nums.size
    if (mid == 0) return
    reverse(nums, 0, nums.lastIndex)
    reverse(nums, 0, mid - 1)
    reverse(nums, mid, nums.lastIndex)
}

private fun reverse(nums: IntArray, start: Int, end: Int) {
    var s = start
    var e = end
    while (s < e) {
        val tmp = nums[s]
        nums[s] = nums[e]
        nums[e] = tmp
        s += 1
        e -= 1
    }
}
