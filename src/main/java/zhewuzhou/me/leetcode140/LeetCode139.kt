package zhewuzhou.me.leetcode140

fun wordBreakCur(s: String, wordDict: List<String>): Boolean {
    if (s.isEmpty() || wordDict.isEmpty() || wordDict.all { it.isEmpty() }) return s.isEmpty()
    val maxSize = wordDict.maxBy { it.length }!!.length
    return doWordBreak(s, 0, wordDict, maxSize)
}

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

private fun doWordBreak(s: String, start: Int, wordDict: List<String>, max: Int): Boolean {
    if (start == s.length) return true
    val res = getNext(start, s, max, wordDict)
    if (res.isEmpty()) return false
    for (p in res) {
        if (doWordBreak(s, start + p.length, wordDict, max)) {
            return true
        }
    }
    return false
}

private fun getNext(start: Int, s: String, max: Int, wordDict: List<String>): List<String> {
    val res = mutableListOf<String>()
    for (i in (start + 1)..Math.min(s.length, start + max + 1)) {
        val sub = s.substring(start, i)
        if (wordDict.contains(sub)) {
            res.add(sub)
        }
    }
    return res.reversed()
}
