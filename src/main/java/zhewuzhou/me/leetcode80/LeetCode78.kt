package zhewuzhou.me.leetcode80

fun subsets(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty()) return listOf()
    val res = mutableListOf(nums.toList())
    doSearch(res, mutableListOf(), nums.toList(), 0)
    return res
}

private fun doSearch(res: MutableList<List<Int>>, comb: MutableList<Int>, source: List<Int>, start: Int) {
    when (comb.size == source.size) {
        true -> return
        false -> {
            res.add(arrayOf(*comb.toTypedArray()).toList())
            for (i in start..source.lastIndex) {
                comb.add(source[i])
                doSearch(res, comb, source, i + 1)
                comb.removeAt(comb.lastIndex)
            }
        }
    }
}
