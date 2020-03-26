package zhewuzhou.me.leetcode120

fun minimumTotal(triangle: List<List<Int>>): Int {
    if (triangle.isEmpty() || triangle.any { it.isEmpty() }) return 0
    val height = triangle.size
    val maxWidth = triangle.last().size
    val matrix = Array(height) {
        IntArray(maxWidth)
    }
    for (i in triangle[0].indices) {
        matrix[0][i] = triangle[0][i]
    }
    for (i in 1 until height) {
        for (j in triangle[i].indices) {
            matrix[i][j] = when (j) {
                0 -> matrix[i - 1][j] + triangle[i][j]
                triangle[i].lastIndex -> matrix[i - 1][j - 1] + triangle[i][j]
                else -> {
                    Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]) + triangle[i][j]
                }
            }
        }
    }
    return matrix[matrix.lastIndex].min()!!
}
