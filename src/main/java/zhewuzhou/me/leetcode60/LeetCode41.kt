package zhewuzhou.me.leetcode60

import zhewuzhou.me.leetcode40.swap

fun firstMissingPositive(nums: IntArray): Int {
    if (nums.isEmpty()) return 1
    for (i in nums.indices) {
        while (nums[i] > 0 && nums[i] < nums.size && nums[i] != nums[nums[i] - 1]) {
            swap(nums, i, nums[i] - 1)
        }
    }
    for (i in nums.indices) {
        if (nums[i] != i + 1) {
            return i + 1
        }
    }
    return nums.size + 1
}
