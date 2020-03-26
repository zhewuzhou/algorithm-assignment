package zhewuzhou.me.leetcode120

fun generateX(numRows: Int): List<List<Int>> {
    return when (numRows) {
        0 -> listOf()
        1 -> listOf(listOf(1))
        2 -> listOf(listOf(1), listOf(1, 1))
        else -> {
            val res = Array<List<Int>>(numRows) { listOf() }
            res[0] = listOf(1)
            res[1] = listOf(1, 1)
            for (n in 3..numRows) {
                val row = IntArray(n)
                row[0] = 1
                for (i in 1..(n - 2)) {
                    row[i] = res[n - 2][i - 1] + res[n - 2][i]
                }
                row[n - 1] = 1
                res[n - 1] = row.toList()
            }
            res.toList()
        }
    }
}

fun generate(numRows: Int): List<Int> {
    return when (numRows) {
        0 -> listOf(1)
        1 -> listOf(1, 1)
        else -> {
            var pre = IntArray(2) {
                1
            }
            for (n in 3..(numRows + 1)) {
                val row = IntArray(n)
                row[0] = 1
                for (i in 1..(n - 2)) {
                    row[i] = pre[i - 1] + pre[i]
                }
                row[n - 1] = 1
                pre = row
            }
            pre.toList()
        }
    }
}
