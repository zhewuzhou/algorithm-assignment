package zhewuzhou.me.leetcode180

import java.util.*

fun twoSumSlow(nums: IntArray, target: Int): IntArray {
    return if (nums[0] > 0) {
        var toIndex = Arrays.binarySearch(nums, 0, nums.size, target)
        toIndex = if (toIndex < 0) Math.abs(toIndex + 1) else toIndex
        twoSumInRange(nums, target, toIndex)
    } else {
        twoSumInRange(nums, target, nums.size)
    }
}

private fun twoSumInRange(nums: IntArray, target: Int, toIndex: Int): IntArray {
    for (i in 0 until toIndex) {
        val searchResult = Arrays.binarySearch(nums, i + 1, toIndex, target - nums[i])
        if (searchResult >= 0) {
            return intArrayOf(i + 1, searchResult + 1)
        }
    }
    return intArrayOf()
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.size - 1
    while (numbers[start] + numbers[end] != target) {
        when {
            numbers[start] + numbers[end] > target -> end -= 1
            else -> start += 1
        }
    }
    return intArrayOf(start + 1, end + 1)
}
