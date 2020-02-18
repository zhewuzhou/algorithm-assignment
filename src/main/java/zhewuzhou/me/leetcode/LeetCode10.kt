package zhewuzhou.me.leetcode

fun isMatch(s: String, p: String): Boolean {
    val cache = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun matchPosition(src: String, sp: Int, pattern: String, pp: Int): Boolean {
        if (sp >= src.length - 1) {        //src run out
            return pp >= pattern.length - 1
        }
        if (pp >= pattern.length - 1) { //pattern run out
            return false
        }
        return if (pattern[pp + 1] == '*') {
            when (pattern[pp] == '.' || src[sp] == pattern[pp]) {
                (true) -> (matchPosition(src, sp, pattern, pp + 2)
                    || matchPosition(src, sp + 1, pattern, pp)
                    || matchPosition(src, sp + 1, pattern, pp + 2))
                (false) -> matchPosition(src, sp, pattern, pp + 2)
            }

        } else {
            when (pattern[pp] == '.' || pattern[pp] == src[sp]) {
                (true) -> matchPosition(src, sp + 1, pattern, pp + 1)
                (false) -> false
            }
        }
    }
    return matchPosition(s, 0, p, 0)
}


