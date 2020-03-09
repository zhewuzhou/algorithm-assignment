package zhewuzhou.me.leetcode60

fun generateMatrix(n: Int): Array<IntArray> {
    val nums = (1..n * n).toList()
    val res = Array<IntArray>(n) {
        IntArray(n)
    }
    var round = 0
    var start = 0
    while ((n - 1) - (2 * round) >= 0) {
        val count = when (n - 2 * round) {
            1 -> 1
            2 -> 4
            else -> 2 * (n - 2 * round) + 2 * (n - 2 * round - 2)
        }
        runRound(res, nums, round, start, count)
        round += 1
        start += count
    }
    return res
}

fun runRound(res: Array<IntArray>, source: List<Int>, round: Int, start: Int, count: Int) {
    val square = res.lastIndex
    //top
    var j = start
    while (j < count + start) {
        //top
        for (i in round..(square - round)) {
            res[round][i] = source[j]
            j += 1
        }
        //right
        for (i in ((round + 1)..(square - round))) {
            res[i][square - round] = source[j]
            j += 1
        }
        //bottom
        for (i in (square - round - 1) downTo round) {
            res[square - round][i] = source[j]
            j += 1
        }
        //left
        for (i in (square - round - 1) downTo round + 1) {
            res[i][round] = source[j]
            j += 1
        }
    }
}
