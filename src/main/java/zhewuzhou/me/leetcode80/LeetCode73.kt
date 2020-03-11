package zhewuzhou.me.leetcode80

fun setZeroes(matrix: Array<IntArray>) {
    var fr = false
    var fc = false
    val row = matrix.size
    val col = matrix[0].size
    for (i in matrix.indices) {
        for (j in 0 until col) {
            if (matrix[i][j] == 0) {
                if (i == 0) fr = true
                if (j == 0) fc = true
                matrix[0][j] = 0
                matrix[i][0] = 0
            }
        }
    }
    for (i in 1 until row) {
        for (j in 1 until col) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }
    if (fr) {
        for (j in 0 until col) {
            matrix[0][j] = 0
        }
    }
    if (fc) {
        for (i in matrix.indices) {
            matrix[i][0] = 0
        }
    }
}
