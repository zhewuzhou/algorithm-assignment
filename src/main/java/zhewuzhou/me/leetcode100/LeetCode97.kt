package zhewuzhou.me.leetcode100

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length || !containsSameChar(s1, s2, s3)) return false
    return doIsInterleave(s1, s2, s3, 0, 0)
}

private fun containsSameChar(s1: String, s2: String, s3: String): Boolean =
    (s1 + s2).toCharArray().sorted().joinToString() == s3.toCharArray().sorted().joinToString()

fun doIsInterleave(s1: String, s2: String, target: String, pos1: Int, pos2: Int): Boolean {
    if (pos1 == s1.length && pos2 == s2.length) {
        return true
    }
    val ti = pos1 + pos2
    if (pos1 < s1.length && pos2 < s2.length && target[ti] == s1[pos1] && target[ti] == s2[pos2]) {
        return doIsInterleave(s1, s2, target, pos1 + 1, pos2) ||
            doIsInterleave(s1, s2, target, pos1, pos2 + 1)
    } else if (pos1 < s1.length && target[ti] == s1[pos1]) {
        return doIsInterleave(s1, s2, target, pos1 + 1, pos2)
    } else if (pos2 < s2.length && target[ti] == s2[pos2]) {
        return doIsInterleave(s1, s2, target, pos1, pos2 + 1)
    }
    return false
}
