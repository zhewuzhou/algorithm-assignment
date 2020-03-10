package zhewuzhou.me.leetcode80

fun uniquePaths(m: Int, n: Int): Int {
    if (m == 1 && n == 1) return 1
    val matrix = Array<IntArray>(m) {
        IntArray(n)
    }
    for (i in 1 until n) {
        matrix[0][i] = 1
    }
    for (i in 1 until m) {
        matrix[i][0] = 1
    }
    for (i in 1 until m) {
        for (j in 1 until n) {
            matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j]
        }
    }
    return matrix[m - 1][n - 1]
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val row = obstacleGrid.size
    val col = obstacleGrid[0].size
    if (row == 1 && col == 1 && obstacleGrid[0][0] == 0) return 1
    if (row >= 1 && col >= 1 && obstacleGrid[0][0] == 1) return 0
    val matrix = Array<IntArray>(row) {
        IntArray(col)
    }
    for (i in 1 until col) {
        if (obstacleGrid[0][i] == 0) matrix[0][i] = 1 else break
    }
    for (i in 1 until row) {
        if (obstacleGrid[i][0] == 0) matrix[i][0] = 1 else break
    }

    for (i in 1 until row) {
        for (j in 1 until col) {
            if (obstacleGrid[i][j] == 1)
                matrix[i][j] = 0
            else
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j]
        }
    }
    return matrix[row - 1][col - 1]
}
