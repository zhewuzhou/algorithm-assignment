package zhewuzhou.me.leetcode200


class UF(n: Int) {
    private val parent: IntArray = IntArray(n)
    private val rank: ByteArray = ByteArray(n)
    private var count: Int = n

    fun count(): Int {
        return count
    }

    private fun find(num: Int): Int {
        var p = num
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]
            p = parent[p]
        }
        return p
    }

    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)
        if (rootP == rootQ) return

        when {
            rank[rootP] < rank[rootQ] -> parent[rootP] = rootQ
            rank[rootP] > rank[rootQ] -> parent[rootQ] = rootP
            else -> {
                parent[rootQ] = rootP
                rank[rootP]++
            }
        }
        count--
    }

    init {
        for (i in 0 until n) {
            parent[i] = i
            rank[i] = 0
        }
    }
}

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val uf = UF(grid.size * grid[0].size)
    val columnSize = grid[0].size
    var zeros = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '1') {
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(i * columnSize + j, (i - 1) * columnSize + j)
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(i * columnSize + j, i * columnSize + j - 1)
                }
            } else {
                zeros += 1
            }
        }
    }
    return uf.count() - zeros
}
