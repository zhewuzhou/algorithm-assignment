package zhewuzhou.me.leetcode60

fun trap(height: IntArray): Int {
    val rightMax = mutableMapOf<Int, Int>()
    val leftMax = mutableMapOf<Int, Int>()
    var water = 0
    for (i in 1 until height.lastIndex) {
        leftMax[i] = Math.max(height[i - 1], (leftMax[i - 1] ?: 0))
        val rightIndex = height.lastIndex - i
        rightMax[rightIndex] = Math.max(height[rightIndex + 1], (rightMax[rightIndex + 1] ?: 0))
    }
    for (i in 1 until height.lastIndex) {
        water += Math.max(Math.min(rightMax[i]!!, leftMax[i]!!) - height[i], 0)
    }
    return water
}
