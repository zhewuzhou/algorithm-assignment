package zhewuzhou.me.leetcode80

fun exist(board: Array<CharArray>, word: String): Boolean {
    if (board.isEmpty() ||
        board[0].isEmpty() ||
        word.isEmpty() ||
        board.size * board[0].size < word.length)
        return false
    return doSearch(mutableListOf(), board, word)
}


private fun doSearch(res: MutableList<Pair<Int, Int>>, board: Array<CharArray>, word: String): Boolean {
    when (res.size == word.length) {
        true -> return true
        false -> {
            val next = calculateNext(res, board, word)
            if (next.isEmpty()) {
                return false
            } else {
                for (pos in next) {
                    res.add(pos)
                    if (doSearch(res, board, word)) {
                        return true
                    }
                    res.removeAt(res.lastIndex)
                }
                return false
            }
        }
    }
}

private fun calculateNext(res: MutableList<Pair<Int, Int>>, board: Array<CharArray>, word: String): List<Pair<Int, Int>> {
    if (res.isEmpty()) return startPos(board, word)
    val row = board.size
    val col = board[0].size
    val next = mutableListOf<Pair<Int, Int>>()
    val cur = res[res.lastIndex]
    next.add(Pair(cur.first - 1, cur.second))
    next.add(Pair(cur.first + 1, cur.second))
    next.add(Pair(cur.first, cur.second - 1))
    next.add(Pair(cur.first, cur.second + 1))
    return next.filter {
        (it.first in 0 until row) &&
            (it.second in 0 until col) &&
            !res.contains(it) &&
            board[it.first][it.second] == word[res.size]
    }
}

private fun startPos(board: Array<CharArray>, word: String): List<Pair<Int, Int>> {
    val row = board.size
    val col = board[0].size
    val res = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (board[i][j] == word[0]) {
                res.add(Pair(i, j))
            }
        }
    }
    return res
}
