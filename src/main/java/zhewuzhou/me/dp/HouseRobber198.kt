package zhewuzhou.me.dp

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val metrics = IntArray(nums.size) {
        0
    }
    metrics[0] = nums[0]
    var max = metrics[0]
    for (i in 1..metrics.lastIndex) {
        var first = 0
        var second = 0
        if (i - 3 >= 0) {
            first = metrics[i - 3]
        }
        if (i - 2 >= 0) {
            second = metrics[i - 2]
        }
        metrics[i] = nums[i] + Math.max(first, second)
        max = Math.max(max, metrics[i])
    }
    return max
}

fun robCircleHouses(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    return Math.max(rob(nums.slice(1..nums.lastIndex).toIntArray()),
        rob(nums.slice(0 until nums.lastIndex).toIntArray()))
}
