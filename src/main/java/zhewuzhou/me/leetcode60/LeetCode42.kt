package zhewuzhou.me.leetcode60

import java.util.*


fun trapDP(height: IntArray): Int {
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

fun trap(height: IntArray): Int {
    val stack: Stack<Int> = Stack()
    var totalWater = 0
    for (right in height.indices) { // Maintain heights in stack are decreasing
        while (!stack.isEmpty() && height[stack.peek()] < height[right]) {
            val bottom = stack.pop()
            if (stack.isEmpty()) {
                break
            }
            val left = stack.peek()
            val water: Int = (Math.min(height[right], height[left]) - height[bottom]) * (right - left - 1)
            totalWater += water
        }
        stack.push(right)
    }
    return totalWater
}
