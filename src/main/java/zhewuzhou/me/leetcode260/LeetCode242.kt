package zhewuzhou.me.leetcode260

fun isAnagram(s: String, t: String): Boolean {
    val charMap = IntArray(26)
    for (c in s) {
        charMap[c - 'a'] += 1
    }
    for (c in t) {
        if (charMap[c - 'a'] > 0) charMap[c - 'a'] -= 1 else return false
    }
    return charMap.all { it == 0 }
}
