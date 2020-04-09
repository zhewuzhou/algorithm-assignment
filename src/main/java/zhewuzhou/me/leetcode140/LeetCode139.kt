package zhewuzhou.me.leetcode140

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    if (wordDict.isEmpty() || wordDict.all { it.isEmpty() }) return s.isEmpty()
    if (s.isEmpty()) return false
    val maxSize = wordDict.maxBy { it.length }!!.length
    val minSize = wordDict.minBy { it.length }!!.length
    val res = BooleanArray(s.length) {
        false
    }
    for (i in (minSize - 1)..s.lastIndex) {
        var j = Math.max(0, i - maxSize + 1)
        while (!res[i] && j <= (i + 1 - minSize)) {
            val sub = s.substring(j, i + 1)
            if (wordDict.contains(sub)) {
                res[i] = if (j - 1 >= 0) res[j - 1] else true
            }
            j += 1
        }
    }
    return res.last()
}

fun wordBreakII(s: String, wordDict: List<String>): List<String> {
    if (wordDict.isEmpty() || wordDict.all { it.isEmpty() }) return listOf()
    if (s.isEmpty() || !wordBreak(s, wordDict)) return listOf()
    val maxSize = wordDict.maxBy { it.length }!!.length
    val minSize = wordDict.minBy { it.length }!!.length
    val res = mutableListOf<String>()
    doWordBreak(res, mutableListOf(), s, 0, wordDict, Pair(maxSize, minSize))
    return res
}

private fun doWordBreak(res: MutableList<String>,
                        comb: MutableList<String>,
                        src: String,
                        start: Int,
                        wordDict: List<String>,
                        range: Pair<Int, Int>) {
    if (start == src.length) {
        res.add(comb.joinToString(" "))
    } else {
        for (s in getNext(start, src, wordDict, range)) {
            comb.add(s)
            doWordBreak(res, comb, src, start + s.length, wordDict, range)
            comb.removeAt(comb.lastIndex)
        }
    }
}

private fun getNext(start: Int, s: String, wordDict: List<String>, range: Pair<Int, Int>): List<String> {
    val res = mutableListOf<String>()
    for (i in (start + range.second)..Math.min(s.length, start + range.first)) {
        val sub = s.substring(start, i)
        if (wordDict.contains(sub)) {
            res.add(sub)
        }
    }
    return res
}
