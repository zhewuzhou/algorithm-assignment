package zhewuzhou.me.leetcode80

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val row = grid.size
    val col = grid[0].size
    val matrix = Array<IntArray>(row) {
        IntArray(col) {
            -1
        }
    }
    matrix[0][0] = grid[0][0]
    for (i in 1 until col) {
        matrix[0][i] = matrix[0][i - 1] + grid[0][i]
    }
    for (i in 1 until row) {
        matrix[i][0] = matrix[i - 1][0] + grid[i][0]
    }
    for (i in 1 until row) {
        for (j in 1 until col) {
            matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + grid[i][j]
        }
    }
    return matrix[row - 1][col - 1]
}
