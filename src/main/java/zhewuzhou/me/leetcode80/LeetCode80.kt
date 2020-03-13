package zhewuzhou.me.leetcode80

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    for (n in nums)
        if (i < 2 || n > nums[i - 2]) {
            nums[i] = n
            i += 1
        }
    return i
}

fun sortColors(nums: IntArray) {
    var second = nums.lastIndex
    var zero = 0
    for (i in 0..second) {
        while (nums[i] == 2 && i < second) {
            swap(nums, i, second)
            second -= 1
        }
        while (nums[i] == 0 && i > zero) {
            swap(nums, i, zero)
            zero += 1
        }
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}
