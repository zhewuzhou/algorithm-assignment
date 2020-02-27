package zhewuzhou.me.leetcode40

fun nextPermutation(nums: IntArray): Unit {
    if (nums.isEmpty() || nums.size == 1) return
    val zipWithNext = nums.toList().zipWithNext()
    val descendingOrder = zipWithNext.all { it.first >= it.second }
    if (descendingOrder) {
        nums.reverse()
        return
    }
    var i = nums.size - 2
    var j = nums.size - 1
    while (nums[i] >= nums[i + 1]) i -= 1
    while (nums[j] <= nums[i]) j -= 1
    swap(nums, i, j)
    reverse(nums, i + 1)
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun reverse(nums: IntArray, start: Int) {
    var e = nums.size - 1
    var s = start
    while (s < e) {
        swap(nums, s, e)
        s += 1
        e -= 1
    }
}
