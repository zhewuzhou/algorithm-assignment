package zhewuzhou.me.leetcode20

fun threeSumClosest(nums: IntArray, target: Int): Int {
    check(nums.size >= 3)
    nums.sort()
    var ni = 0
    var closest: Int? = null
    while (ni < nums.size - 2) {
        val twoMin = nums[ni + 1] + nums[ni + 2]
        var start = ni + 1
        var end = nums.size - 1
        if (closest != null && closest > target && nums[ni] + twoMin >= closest) {
            return closest
        }
        while (start < end) {
            val cur = nums[start] + nums[end] + nums[ni]
            if (closest == null) {
                closest = cur
            }
            when (cur.compareTo(target)) {
                0 -> return target
                1 -> end -= 1
                -1 -> start += 1
            }
            if (Math.abs(cur - target) < Math.abs(closest - target)) closest = cur
        }
        while (ni < nums.size - 1 && nums[ni] == nums[ni + 1]) {
            ni += 1
        }
        ni += 1
    }
    return closest ?: 0
}
