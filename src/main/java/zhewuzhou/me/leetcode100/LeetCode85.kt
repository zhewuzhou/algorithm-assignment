package zhewuzhou.me.leetcode100

fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
    val col = matrix[0].size
    val left = IntArray(col)
    val height = IntArray(col)
    val right = IntArray(col) {
        col
    }
    var maxArea = 0
    for (i in matrix.indices) {
        var curLeft = 0
        var curRight = col
        for (j in matrix[0].indices) {
            height[j] = if (matrix[i][j] == '0') 0 else (height[j] + 1)
        }
        for (j in matrix[0].indices) {
            if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft)
            else {
                left[j] = 0
                curLeft = j + 1
            }
        }
        for (j in matrix[0].lastIndex downTo 0) {
            if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight)
            else {
                right[j] = col
                curRight = j
            }
        }
        for (j in matrix[0].indices)
            maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j])
    }
    return maxArea
}
