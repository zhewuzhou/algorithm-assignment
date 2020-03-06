package zhewuzhou.me.leetcode60

fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()
    doSolve(result, Array(n) { IntArray(n) }, 0, n)
    return result
}

private fun doSolve(result: MutableList<List<String>>, comb: Array<IntArray>, row: Int, n: Int) {
    when (row == n) {
        true -> result.add(mapToGrid(comb))
        false -> {
            for (i in comb.indices) {
                if (check(comb, row, i)) {
                    comb[row][i] = 1
                    doSolve(result, comb, row + 1, n)
                    comb[row][i] = 0
                }
            }
        }
    }
}

private fun mapToGrid(comb: Array<IntArray>) =
    comb.map { row ->
        row
            .map {
                when (it == 0) {
                    true -> '.'
                    false -> 'Q'
                }
            }
            .joinToString("")
    }

private fun check(grid: Array<IntArray>, row: Int, col: Int): Boolean =
    grid[row].all { it == 0 } &&
        grid.map { it[col] }.all { it == 0 } &&
        crossCheck(grid, row, col)

private fun crossCheck(comb: Array<IntArray>, row: Int, col: Int): Boolean {
    var r = row - 1
    while (r >= 0) {
        val diff = row - r
        val right = col + diff
        val left = col - diff
        if (right <= comb.lastIndex && comb[r][right] == 1) {
            return false
        }
        if (left >= 0 && comb[r][left] == 1) {
            return false
        }
        r -= 1
    }
    return true
}


