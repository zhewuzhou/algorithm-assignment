package zhewuzhou.me.dp

fun lengthOfLIS(nums: IntArray): Int {
    return when (nums.size) {
        0 -> 0
        1 -> 1
        else -> calculateLIS(nums)
    }
}

private fun calculateLIS(nums: IntArray): Int {
    val metrics = IntArray(nums.size) {
        1
    }
    var result = 1
    for (i in 1..nums.lastIndex) {
        var maxLis = 1
        for (j in 0 until i) {
            var curMax = 1
            if (nums[j] < nums[i]) {
                curMax = metrics[j] + 1
            }
            maxLis = Math.max(maxLis, curMax)
        }
        metrics[i] = maxLis
        result = Math.max(metrics[i], result)
    }
    return result
}
