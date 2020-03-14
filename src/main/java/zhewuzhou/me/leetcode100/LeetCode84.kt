package zhewuzhou.me.leetcode100

import java.util.*

fun largestRectangleAreaDivide(heights: IntArray): Int {
    if (heights.isEmpty()) return 0
    if (heights.size == 1) return heights[0]
    if (heights.size == 2) return maxWidth2(heights, 0, 1)
    return largestRectangleArea(heights, 0, heights.lastIndex)
}

fun largestRectangleArea(heights: IntArray): Int {
    if (heights.isEmpty()) return 0
    val stack: Stack<Int> = Stack()
    val len = heights.size
    var maxArea = Int.MIN_VALUE
    for (i in 0 until len) {
        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
            val partialMaxArea: Int = heights[stack.pop()] * (i - if (stack.isEmpty()) 0 else stack.peek() + 1)
            maxArea = Math.max(maxArea, partialMaxArea)
        }
        stack.push(i)
    }
    while (!stack.isEmpty()) {
        val partialMaxArea: Int = heights[stack.pop()] * (len - if (stack.isEmpty()) 0 else stack.peek() + 1)
        maxArea = Math.max(maxArea, partialMaxArea)
    }
    return maxArea
}

fun largestRectangleArea(heights: IntArray, start: Int, end: Int): Int {
    if (end == start) return heights[end]
    if (end - 1 == start) return maxWidth2(heights, start, end)
    val min = minIndexes(heights, start, end)
    var largest = min.first * (end - start + 1)
    val ids = min.second
    if (ids[0] != start) {
        largest = Math.max(largest, largestRectangleArea(heights, start, ids[0] - 1))
    }
    for (i in 0 until ids.lastIndex) {
        if (ids[i] + 1 != ids[i + 1]) {
            largest = Math.max(largest, largestRectangleArea(heights, ids[i] + 1, ids[i + 1] - 1))
        }
    }
    if (ids[ids.lastIndex] != end) {
        largest = Math.max(largest, largestRectangleArea(heights, ids[ids.lastIndex] + 1, end))
    }
    return largest
}

private fun maxWidth2(heights: IntArray, start: Int, end: Int): Int =
    Math.max(
        Math.min(heights[start], heights[end]) * 2,
        Math.max(heights[start], heights[end])
    )

fun minIndexes(nums: IntArray, start: Int, end: Int): Pair<Int, List<Int>> {
    val res = mutableListOf<Int>()
    var min = nums[start]
    for (i in start..end) {
        when (min.compareTo(nums[i])) {
            0 -> res.add(i)
            1 -> {
                min = nums[i]
                res.clear()
                res.add(i)
            }
        }
    }
    return Pair(min, res)
}
