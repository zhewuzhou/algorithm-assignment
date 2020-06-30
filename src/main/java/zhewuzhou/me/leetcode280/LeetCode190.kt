package zhewuzhou.me.leetcode280

fun wordPattern(pattern: String, str: String): Boolean {
    val words = str.split(" ")
    if (pattern.isEmpty()) return str.isEmpty()
    if (words.size != pattern.length) return false
    val caches = mutableMapOf<Char, String>()
    val knownWords = mutableSetOf<String>()
    for (i in pattern.indices) {
        if (caches.containsKey(pattern[i])) {
            if (caches[pattern[i]] != words[i]) {
                return false
            }
        } else {
            if (knownWords.contains(words[i])) return false
            caches[pattern[i]] = words[i]
            knownWords.add(words[i])
        }
    }
    return true
}
