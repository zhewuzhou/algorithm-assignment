package zhewuzhou.me.leetcode20

fun maxArea1(heights: IntArray): Int {
    check(heights.size >= 2)
    return heights.indices
        .flatMap { index ->
            (index + 1 until heights.size)
                .map { (it - index) * Math.min(heights[it], heights[index]) }
        }.maxBy { it } ?: 0
}

fun maxArea(heights: IntArray): Int {
    check(heights.size >= 2)
    var container = 0
    var head = 0
    var tail = heights.size - 1
    while (head < tail) {
        container = Math.max(container, (tail - head) * Math.min(heights[head], heights[tail]))
        when (heights[head].compareTo(heights[tail])) {
            1 -> tail -= 1
            -1 -> head += 1
            0 -> {
                tail -= 1
                head += 1
            }
        }
    }
    return container
}
