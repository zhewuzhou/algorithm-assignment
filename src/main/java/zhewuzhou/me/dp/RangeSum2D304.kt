package zhewuzhou.me.dp

class NumMatrix(val matrix: Array<IntArray>) {
    private var row = if (matrix.isEmpty()) 0 else matrix.size + 1
    private var col = if (matrix.isEmpty() || matrix[0].isEmpty()) 0 else matrix[0].size + 1
    private val result = Array(row) {
        IntArray(col)
    }

    init {
        for (i in 1..result.lastIndex) {
            for (j in 1..result[0].lastIndex) {
                result[i][j] = result[i - 1][j] + result[i][j - 1] - result[i - 1][j - 1] + matrix[i - 1][j - 1]
            }
        }
    }

    fun sumRegion(lr: Int, lc: Int, rr: Int, rc: Int): Int {
        if (row == 0 || col == 0) return 0
        return result[rr + 1][rc + 1] - result[lr][rc + 1] - result[rr + 1][lc] + result[lr][lc]
    }
}

