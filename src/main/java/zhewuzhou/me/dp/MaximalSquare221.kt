package zhewuzhou.me.dp

fun maximalSquare(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
    val width = matrix[0].size
    val heights = IntArray(width)
    val lefts = IntArray(width)
    val rights = IntArray(width) {
        width
    }
    var maxSquare = 0
    for (i in matrix.indices) {
        var left = 0
        var right = width
        for (j in 0 until width) {
            if (matrix[i][j] == '0') heights[j] = 0 else heights[j] += 1
        }
        for (j in 0 until width) {
            when (matrix[i][j] == '1') {
                true -> lefts[j] = Math.max(lefts[j], left)
                false -> {
                    lefts[j] = 0
                    left = j + 1
                }
            }
        }
        for (j in (width - 1) downTo 0) {
            when (matrix[i][j] == '1') {
                true -> rights[j] = Math.min(rights[j], right)
                false -> {
                    rights[j] = width
                    right = j
                }
            }
        }
        for (j in 0 until width) {
            val edge = Math.min(heights[j], (rights[j] - lefts[j]))
            maxSquare = Math.max(edge * edge, maxSquare)
        }
    }
    return maxSquare
}
