package zhewuzhou.me.leetcode20

fun lengthOfLongestSubstring(s: String): Int {
    val all = s.mapIndexed { index, it ->
        val sb = StringBuilder()
        sb.append(it)
        var currentIndex = index + 1
        while (currentIndex < s.length && !sb.contains(s[currentIndex])) {
            sb.append(s[currentIndex])
            currentIndex += 1
        }
        sb.toString()
    }
    return all.maxBy { it.length }?.length ?: 0
}
