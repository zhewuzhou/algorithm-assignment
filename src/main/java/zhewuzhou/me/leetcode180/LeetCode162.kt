package zhewuzhou.me.leetcode180

fun findPeakElement(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    for (i in nums.indices) {
        if (i == 0) {
            if (nums.size == 1 || nums[0] > nums[1])
                return 0
        } else if (i == nums.lastIndex) {
            if (nums[i] > nums[i - 1])
                return i
        } else {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i
            }
        }
    }
    return -1
}

fun findPeakElementFast(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var low = 0
    var high = nums.lastIndex
    while (low < high) {
        val mid = (low + high) ushr 1
        if (nums[mid] > nums[mid + 1]) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}
