package zhewuzhou.me.leetcode140

fun singleNumber(nums: IntArray) =
    nums.reduce { acc, it -> acc.xor(it) }
