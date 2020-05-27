package zhewuzhou.me.dp

import java.util.*

fun lengthOfLISDP(nums: IntArray): Int {
    return when (nums.size) {
        0 -> 0
        1 -> 1
        else -> calculateLIS(nums)
    }
}

//Patience Sort, the card game
fun lengthOfLIS(nums: IntArray): Int {
    val pilesTop = IntArray(nums.size)
    var numOfPiles = 0
    for (n in nums) {
        var result = Arrays.binarySearch(pilesTop, 0, numOfPiles, n)
        result = if (result < 0) Math.abs(result + 1) else result
        pilesTop[result] = n
        numOfPiles = if (result == numOfPiles) numOfPiles + 1 else numOfPiles
    }
    return numOfPiles
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
