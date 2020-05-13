package zhewuzhou.me.dp

/*
1. Balloons 0, 1, ..., n - 1
2. What is the max value if we burst all of them [0, n - 1]?
3. Let's first consider bursting [start, end]
4. Imagine we burst index i at the end
5. [start, ... i - 1, (i), i + 1 ... end]
6. Before the end, we already bursted [start, i - 1] and [i + 1, end]
7. Before the end, boundaries start - 1, i, end + 1 are always there
8. This helps us calculate coins without worrying about details inside [start, i - 1] and [i + 1, end]
9. So the range can be divided into | start - 1, maxCoin(start, i - 1), i, maxCoins(i + 1, end), end + 1
 */
fun maxCoinsNaive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    return when (nums.size) {
        1 -> nums[0]
        else -> {
            var maxResult = 0
            for (i in nums.indices) {
                var result = 0
                val l = nums.lastIndex
                result = when (i) {
                    0 -> {
                        nums[0] * nums[1] + maxCoins(nums.sliceArray(1..l))
                    }
                    l -> {
                        nums.last() * nums[l - 1] + maxCoins(nums.sliceArray(0 until l))
                    }
                    else -> {
                        nums[i] * nums[i + 1] * nums[i - 1] + maxCoins(removeAtI(nums, i))
                    }
                }
                maxResult = Math.max(maxResult, result)
            }
            maxResult
        }
    }
}

fun maxCoins(balloons: IntArray): Int {
    if (balloons.isEmpty()) return 0
    val nums = IntArray(balloons.size + 2) {
        1
    }
    for (i in 1 until nums.lastIndex) {
        nums[i] = balloons[i - 1]
    }
    val caches = Array(nums.size) { IntArray(nums.size) }
    return burst(caches, nums, 0, nums.lastIndex)
}

fun burst(caches: Array<IntArray>, nums: IntArray, left: Int, right: Int): Int {
    if (left + 1 == right) return 0
    if (caches[left][right] > 0) return caches[left][right]
    var ans = 0
    for (i in left + 1 until right) {
        ans = Math.max(ans,
            nums[left] * nums[i] * nums[right] + burst(caches, nums, left, i) + burst(caches, nums, i, right))
    }
    caches[left][right] = ans
    return ans
}

private fun removeAtI(nums: IntArray, i: Int): IntArray {
    val toList = nums.toMutableList()
    toList.removeAt(i)
    return toList.toIntArray()
}
