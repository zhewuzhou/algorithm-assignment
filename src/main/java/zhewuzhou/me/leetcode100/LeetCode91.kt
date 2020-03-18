package zhewuzhou.me.leetcode100

fun numDecodings(s: String): Int {
    if (s.isEmpty() || s[0] == '0') return 0
    val res = IntArray(s.length)
    res[0] = 1
    for (i in 1..s.lastIndex) {
        val twoDigits = s.substring(i - 1, i + 1).toInt()
        if (s[i] != '0') res[i] = res[i - 1]
        if (twoDigits in 10..26) {
            if (i == 1) {
                res[i] += 1
            } else {
                res[i] += res[i - 2]
            }
        }
        if (res[i] == 0) return 0
    }
    return res.last()
}
