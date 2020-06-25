package zhewuzhou.me.leetcode280

fun missingNumber(nums: IntArray): Int {
    for (i in nums.indices) {
        while (nums[i] <= nums.lastIndex && nums[i] != i) {
            swap(nums, i, nums[i])
        }
    }
    for (i in nums.indices) {
        if (i != nums[i]) {
            return i
        }
    }
    return -1
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
}
