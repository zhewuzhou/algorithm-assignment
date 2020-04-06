package zhewuzhou.me.leetcode140

class UF(var count: Int) {
    private var size: IntArray = IntArray(0)
    private var parent: IntArray = IntArray(0)

    init {
        size = IntArray(count) { 1 }
        parent = IntArray(count)
        parent.forEachIndexed { index, _ -> parent[index] = index }
    }

    private fun validate(p: Int) {
        val n = parent.size
        require(p in 0 until n) { "index " + p + " is not between 0 and " + (n - 1) }
    }

    fun find(p: Int): Int {
        var e = p
        validate(e)
        while (e != parent[e]) e = parent[e]
        return e
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)
        if (rootP == rootQ) return

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ
            size[rootQ] += size[rootP]
        } else {
            parent[rootQ] = rootP
            size[rootP] += size[rootQ]
        }
        count -= 1
    }
}

fun solve(board: Array<CharArray>): Unit {
    if (board.isEmpty() || board[0].isEmpty()) return
    val columnSize = board[0].size
    val rowSize = board.size
    val uf = UF(columnSize * rowSize)
    val boundary = mutableListOf<Int>()
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'O') {
                if (j >= 1 && board[i][j - 1] == 'O') uf.union(indexInArray(i, j, columnSize), indexInArray(i, j - 1, columnSize))
                if (i >= 1 && board[i - 1][j] == 'O') uf.union(indexInArray(i, j, columnSize), indexInArray(i - 1, j, columnSize))
                if (i == 0 || i == rowSize - 1 || j == 0 || j == columnSize - 1) {
                    boundary.add(indexInArray(i, j, columnSize))
                }
            }
        }
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'O') {
                if (boundary.any { uf.connected(it, indexInArray(i, j, columnSize)) }) {
                    continue
                } else {
                    board[i][j] = 'X'
                }
            }
        }
    }
    println("Not works")
}

private fun indexInArray(i: Int, j: Int, columnSize: Int) = i * columnSize + j
