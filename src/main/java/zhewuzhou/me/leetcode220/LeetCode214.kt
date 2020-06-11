package zhewuzhou.me.leetcode220

data class StringMatch(val pat: String) {
    private val size = 256
    val dfa: Array<IntArray> = Array(size) { IntArray(pat.length) }
    val table = IntArray(pat.length)

    init {
        dfa[pat[0].toInt()][0] = 1
        var status = 0
        for (n in 1..pat.lastIndex) {
            for (c in 0 until size) {
                dfa[c][n] = dfa[c][status]
            }
            dfa[pat[n].toInt()][n] = n + 1
            status = dfa[pat[n].toInt()][status]
        }

        var start = 0
        var end = 1
        while (end < pat.length) {
            if (pat[start] == pat[end]) {
                start += 1
                table[end] = start
                end += 1
            } else {
                if (start > 0) {
                    start = table[start - 1]
                } else {
                    start = 0
                    end += 1
                }
            }
        }
    }

    fun search(txt: String): Pair<Int, Int> {
        val pl = pat.length
        val tl = txt.length
        var index = 0
        var status = 0
        while (index < tl && status < pl) {
            status = dfa[txt[index].toInt()][status]
            index += 1
        }
        return if (status == pl) Pair(index - pl, status) else Pair(tl, status)
    }

    fun searchWithTable(txt: String): Int {
        val tl = txt.length
        val pl = pat.length
        var index = 0
        var status = 0
        while (index < tl && status < pl) {
            if (txt[index] == pat[status]) {
                index += 1
                status += 1
            } else {
                if (status != 0) {
                    status = table[status - 1]
                } else {
                    index += 1
                }
            }
        }
        return if (status == pl) index - pl else tl
    }
}

fun shortestPalindromeV1(s: String): String {
    if (s.isEmpty() || s.length == 1) return s
    val kmp = StringMatch("$s|${s.reversed()}")
    val maxLength = kmp.table[s.length * 2]
    return s.substring(maxLength, s.length).reversed() + s
}

fun shortestPalindrome(txt: String): String {
    val tl = txt.length
    if (txt.isEmpty() || tl == 1) return txt
    val reversed = txt.reversed()
    val r = StringMatch(txt).search(reversed)
    return if (r.first < tl) txt else reversed.substring(0, tl - r.second) + txt
}


