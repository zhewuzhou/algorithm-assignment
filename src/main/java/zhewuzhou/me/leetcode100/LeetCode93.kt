package zhewuzhou.me.leetcode100

fun restoreIpAddresses(s: String): List<String> {
    if (s.isEmpty() || s.length < 4 || s.length > 12) return listOf()
    val res = mutableListOf<String>()
    restore(res, s, mutableListOf(), 0)
    return res
}

private fun restore(res: MutableList<String>, source: String, comb: MutableList<String>, start: Int) {
    if (comb.size == 4 && start == source.length) {
        res.add(comb.joinToString("."))
    }
    for (s in steps(start, source)) {
        if (s.toInt() in 0..255) {
            comb.add(s)
            restore(res, source, comb, start + s.length)
            comb.removeAt(comb.lastIndex)
        }
    }

}

private fun steps(start: Int, source: String): List<String> =
    (1..3)
        .mapNotNull { if (start + it <= source.length) source.substring(start, start + it) else null }
        .filter { (it[0] != '0' && it.length > 1) || it.length == 1 }


