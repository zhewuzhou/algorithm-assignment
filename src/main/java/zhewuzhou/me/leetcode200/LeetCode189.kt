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

fun reverseBits(n: Int): Int {
    var num = n
    if (num == 0) return 0
    var result = 0
    for (i in 0..31) {
        result = result shl 1
        if (num and 1 == 1) result++
        num = num shr 1
    }
    return result
}
