package zhewuzhou.me.leetcode260

fun singleNumber(nums: IntArray): IntArray {
    if (nums.isEmpty() || nums.size < 2) return intArrayOf()
    var mask = nums.reduce { acc, it -> acc.xor(it) }
    mask = mask.and(-mask)
    var single1 = 0
    var single2 = 0
    for (n in nums) {
        if (n.and(mask) == 0) {
            single1 = single1.xor(n)
        } else {
            single2 = single2.xor(n)
        }
    }
    return intArrayOf(single1, single2)
}

