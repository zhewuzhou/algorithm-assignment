package zhewuzhou.me.leetcode140

fun longestConsecutive(nums: IntArray): Int {
    val container = mutableMapOf<Int, Int>()
    var max = 1;
    for (n in nums) {
        if (!container.containsKey(n)) {
            val left = container.getOrDefault(n - 1, 0)
            val right = container.getOrDefault(n + 1, 0)
            val total = left + right + 1
            container[n] = total
            if (total > max) {
                max = total
            }
            if (left > 0) container[n - left] = total
            if (right > 0) container[n + right] = total
        }
    }
    return max
}
