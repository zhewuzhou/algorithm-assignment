package zhewuzhou.me.leetcode180

fun maximumGap(nums: IntArray): Int =
    nums.toList()
        .sorted()
        .zipWithNext()
        .map { it.second - it.first }
        .max() ?: 0


