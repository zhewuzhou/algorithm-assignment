package zhewuzhou.me.leetcode60

fun isMatchRecursive(s: String, p: String): Boolean =
    match(s, p, 0, 0)

private fun match(s: String, p: String, si: Int, pi: Int): Boolean {
    if (pi == p.length) return si == s.length
    return when (p[pi]) {
        '*' -> {
            (si < s.length && match(s, p, si + 1, pi))
                || match(s, p, si, pi + 1)
        }
        else -> {
            si < s.length
                && charMatch(s[si], p[pi])
                && match(s, p, si + 1, pi + 1)
        }
    }
}

fun isMatch(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
    dp[0][0] = true
    for (pi in p.indices) {
        if (p[pi] == '*') {
            dp[0][pi + 1] = true
        } else {
            break
        }
    }
    for (pi in p.indices) {
        for (si in s.indices) {
            when (p[pi] == '*') {
                true -> {
                    dp[si + 1][pi + 1] = dp[si + 1][pi] || dp[si][pi + 1]
                }
                false -> {
                    if (charMatch(s[si], p[pi])) {
                        dp[si + 1][pi + 1] = dp[si][pi]
                    }
                }
            }
        }
    }
    return dp[s.length][p.length]
}

private fun charMatch(s: Char, p: Char): Boolean =
    when (p == '?') {
        true -> true
        false -> s == p
    }
