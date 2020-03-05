package zhewuzhou.me.leetcode60

fun jump(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val steps = IntArray(nums.size)
    for (i in (nums.size - 2) downTo 0) {
        when (nums[i] >= nums.lastIndex - i) {
            true -> steps[i] = 1
            false -> {
                var minSteps = nums.size + 1
                for (j in (i + 1)..(i + nums[i])) {
                    minSteps = Math.min((1 + steps[j]), minSteps)
                }
                steps[i] = minSteps
            }
        }
    }
    return steps[0]
}
