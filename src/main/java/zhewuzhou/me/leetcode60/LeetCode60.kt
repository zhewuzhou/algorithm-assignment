package zhewuzhou.me.leetcode60

fun getPermutation(n: Int, k: Int): String {
    val res = mutableListOf<List<Int>>()
    val source = (1..n).toList()
    doSearch(res, mutableListOf(), source, k, false)
    return res[res.lastIndex].joinToString("") { it.toString() }
}

private fun doSearch(res: MutableList<List<Int>>, comb: MutableList<Int>, source: List<Int>, target: Int, found: Boolean) {
    var f = found
    if (res.size == target) {
        f = true
    }
    when (comb.size == source.size) {
        true -> {
            res.add(listOf(*comb.toTypedArray()))
        }
        false -> {
            if (!f) {
                for (i in source.indices) {
                    if (!comb.contains(source[i])) {
                        comb.add(source[i])
                        doSearch(res, comb, source, target, f)
                        comb.removeAt(comb.lastIndex)
                    }
                }
            }
        }
    }
}
