package zhewuzhou.me.leetcode100


fun isScramble(s1: String, s2: String): Boolean {
    if (s1 == s2) return true
    val letters = IntArray(26)
    for (i in s1.indices) {
        letters[s1[i] - 'a']++
        letters[s2[i] - 'a']--
    }
    for (i in 0..25) if (letters[i] != 0) return false
    for (i in 1 until s1.length) {
        if (isScramble(s1.substring(0, i), s2.substring(0, i))
            && isScramble(s1.substring(i), s2.substring(i))) return true
        if (isScramble(s1.substring(0, i), s2.substring(s2.length - i))
            && isScramble(s1.substring(i), s2.substring(0, s2.length - i))) return true
    }
    return false
}
