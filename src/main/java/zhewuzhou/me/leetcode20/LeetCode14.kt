package zhewuzhou.me.leetcode20

fun longestCommonPrefix(strs: Array<String>): String {
    var index = 0
    var keepFind = true
    while (keepFind) {
        val lc = strs.map { it[index] }
        if (lc.minBy { it } == lc.maxBy { it }) {
            index++
        } else {
            keepFind = false
        }
    }
    return strs[0].substring(0 until index)
}


fun longestCommonPrefix1(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var first = strs[0]
    var last = strs[0]
    for (str in strs) {
        if (str < first) first = str
        if (str > last) last = str
    }
    var i = 0
    val len = Math.min(first.length, last.length)
    while (i < len && first[i] == last[i]) i++
    return first.substring(0, i)
}

