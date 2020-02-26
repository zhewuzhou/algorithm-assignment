package zhewuzhou.me.leetcode40

fun removeElement(nums: IntArray, v: Int): Int {
    var left = 0
    var ni = 0
    while (ni < nums.size) {
        if (nums[ni] != v) {
            nums[left] = nums[ni]
            left += 1
        }
        ni += 1
    }
    return left
}
