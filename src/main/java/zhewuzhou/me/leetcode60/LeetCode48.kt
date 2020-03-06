package zhewuzhou.me.leetcode60

fun rotate(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in i until matrix[0].size) {
            var temp = 0
            temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    for (i in matrix.indices) {
        for (j in 0 until matrix.size / 2) {
            var temp = 0
            temp = matrix[i][j]
            matrix[i][j] = matrix[i][matrix.size - 1 - j]
            matrix[i][matrix.size - 1 - j] = temp
        }
    }
}
