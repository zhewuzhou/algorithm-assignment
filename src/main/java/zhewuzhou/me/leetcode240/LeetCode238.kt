package zhewuzhou.me.leetcode240

fun productExceptSelfR(nums: IntArray): IntArray {
    return doProduct(nums, 1)
}

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val res = IntArray(n)
    res[0] = 1
    for (i in 1 until n) {
        res[i] = res[i - 1] * nums[i - 1]
    }
    var right = 1
    for (i in n - 1 downTo 0) {
        res[i] *= right
        right *= nums[i]
    }
    return res
}

private fun doProduct(nums: IntArray, factor: Int): IntArray {
    when (nums.size) {
        2 -> return intArrayOf(nums[1] * factor, nums[0] * factor)
        3 -> return intArrayOf(nums[1] * nums[2] * factor, nums[0] * nums[2] * factor, nums[0] * nums[1] * factor)
    }
    val mid = nums.size / 2 - 1
    return doProduct(nums.copyOfRange(0, mid + 1), factor * product(nums, mid + 1, nums.lastIndex)) +
        doProduct(nums.copyOfRange(mid + 1, nums.size), factor * product(nums, 0, mid))
}

private fun product(nums: IntArray, s: Int, e: Int): Int {
    var result = 1
    for (i in s..e) {
        result *= nums[i]
    }
    return result
}
