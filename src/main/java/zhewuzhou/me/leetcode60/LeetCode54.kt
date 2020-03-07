package zhewuzhou.me.leetcode60

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty()) return listOf()
    val col = matrix[0].lastIndex
    val row = matrix.lastIndex
    val result = mutableListOf<Int>()
    var round = 0
    while ((col - 2 * round) >= 0 && (row - 2 * round) >= 0) {
        spiralOrderRound(matrix, result, round, row, col)
        round += 1
    }
    return result
}

fun spiralOrderRound(matrix: Array<IntArray>, res: MutableList<Int>, round: Int, row: Int, col: Int) {
    when {
        row - 2 * round == 0 -> {
            for (i in round..(col - round)) {
                res.add(matrix[round][i])
            }
        }
        col - 2 * round == 0 -> {
            for (i in ((round)..(row - round))) {
                res.add(matrix[i][col - round])
            }
        }
        else -> {
            //top
            for (i in round..(col - round)) {
                res.add(matrix[round][i])
            }
            //right
            for (i in ((round + 1)..(row - round))) {
                res.add(matrix[i][col - round])
            }
            //bottom
            for (i in (col - round - 1) downTo round) {
                res.add(matrix[row - round][i])
            }
            //left
            for (i in (row - round - 1) downTo round + 1) {
                res.add(matrix[i][round])
            }
        }
    }
}
