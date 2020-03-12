package zhewuzhou.me.leetcode80

fun combine(n: Int, k: Int): List<List<Int>> {
    if (n < k || n == 0) return listOf()
    val res = mutableListOf<List<Int>>()
    doSearch(res, mutableListOf(), (1..n).toList(), k, 0)
    return res
}

private fun doSearch(res: MutableList<List<Int>>, comb: MutableList<Int>, source: List<Int>, k: Int, start: Int) {
    when (comb.size == k) {
        true -> res.add(arrayOf(*comb.toTypedArray()).toList())
        false -> {
            for (i in start..source.lastIndex) {
                comb.add(source[i])
                doSearch(res, comb, source, k, i + 1)
                comb.removeAt(comb.lastIndex)
            }
        }
    }
}
