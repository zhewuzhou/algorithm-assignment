package zhewuzhou.me.leetcode220

fun minSubArrayLenX(target: Int, nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var curSum = 0
    var lower = 0
    var start = -1
    while (curSum < target) {
        start += 1
        curSum += nums[start]
        if (start == nums.lastIndex && curSum < target) {
            return 0
        }
    }

    var result = start + 1
    for (i in (start + 1)..nums.lastIndex) {
        if (nums[i] > target) return 1
        curSum += nums[i]
        while (curSum >= target) {
            curSum -= nums[lower]
            lower += 1
        }
        if (lower > 0) {
            lower -= 1
            curSum += nums[lower]
        }
        result = Math.min(result, i - lower + 1)
    }
    return result
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE
    var curSum = 0
    var from = 0
    for (i in nums.indices) {
        curSum += nums[i]
        while (curSum >= target) {
            result = Math.min(result, i - from + 1)
            curSum -= nums[from]
            from += 1
        }
    }
    return if (result == Int.MAX_VALUE) 0 else result
}
