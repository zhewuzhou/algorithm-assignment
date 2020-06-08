package zhewuzhou.me.leetcode220

fun isIsomorphicSlow(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    if (s.isEmpty()) return true
    val sChars = s.toCharArray()
    val sDistinct = sChars.distinct()
    val tDistinct = t.toCharArray().distinct()
    if (sDistinct.size != tDistinct.size) return false
    for (i in sDistinct.indices) {
        if (sDistinct[i] != tDistinct[i]) {
            for (j in sChars.indices) {
                if (sChars[j] == sDistinct[i]) {
                    sChars[j] = tDistinct[i]
                }
            }
        }
    }

    return sChars.joinToString("") == t
}

fun isIsomorphic(s1: String, s2: String): Boolean {
    val m = IntArray(512)
    for (i in s1.indices) {
        if (m[s1[i].toInt()] != m[s2[i].toInt() + 256]) return false
        m[s2[i].toInt() + 256] = i + 1
        m[s1[i].toInt()] = m[s2[i].toInt() + 256]
    }
    return true
}

