package zhewuzhou.me.leetcode180

fun majorityElementN2(nums: IntArray) =
    nums.filter { n ->
        nums.count { it == n } > nums.size / 2
    }[0]

fun majorityElement(nums: IntArray): Int {
    var count = 0
    var major = nums[0]
    for (n in nums) {
        if (count == 0) {
            major = n
        }
        count += if (major == n) 1 else -1
    }
    return major
}

fun majorityElementFast(nums: IntArray): Int {
    val result = mutableMapOf<Int, Int>()
    for (n in nums) {
        result[n] = if (result[n] == null) 1 else result[n]!! + 1
        if (result[n]!! > nums.size / 2) {
            return n
        }
    }
    return 0
}
