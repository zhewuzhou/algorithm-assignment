package zhewuzhou.me.leetcode120

fun numDistinct(s: String, t: String): Int {
    if (s.isEmpty() && t.isEmpty()) return 1
    if (t.length > s.length || (s.isEmpty() && t.isNotEmpty())) return 0
    val src = s.toCharArray()
        .mapIndexed { index, c -> Pair(c, index) }
    val res = mutableListOf<List<Int>>()
    doDistinct(res, src, t, 0, mutableListOf())
    return res.size
}

private fun doDistinct(res: MutableList<List<Int>>, src: List<Pair<Char, Int>>, t: String, si: Int, comb: MutableList<Int>) {
    if (comb.size == t.length) {
        res.add(listOf(*comb.toTypedArray()))
        return
    } else if (si == src.size && comb.size != t.length) {
        return
    } else {
        for (p in getPos(src, t[comb.size], si, t.length - comb.size)) {
            comb.add(p)
            doDistinct(res, src, t, p + 1, comb)
            comb.removeAt(comb.lastIndex)
        }
    }
}

private fun getPos(src: List<Pair<Char, Int>>, t: Char, si: Int, tRemain: Int): List<Int> =
    src.filter { it.second >= si && it.first == t && src.size - it.second >= tRemain }
        .map { it.second }

