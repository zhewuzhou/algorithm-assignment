package zhewuzhou.me.leetcode20

fun isMatchRecursive(s: String, p: String): Boolean =
    //match(s, 0, p, 0)
    isMatch(s, p)

/*
if sp==src.length && pp==pattern.length then true
 */
private fun match(s: String, si: Int, p: String, pi: Int): Boolean {
    if (pi == p.length) return si == s.length
    return if (pi < p.length - 1 && p[pi + 1] == '*') {
        (match(s, si, p, pi + 2) ||
            (si < s.length
                && charMatch(s[si], p[pi])
                && match(s, si + 1, p, pi)))
    } else {
        (si < s.length
            && charMatch(s[si], p[pi])
            && match(s, si + 1, p, pi + 1))
    }
}

fun isMatch(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
    dp[0][0] = true
    for (pi in p.indices) {
        if (p[pi] == '*' && dp[0][pi - 1]) {
            dp[0][pi + 1] = true
        }
    }
    for (si in s.indices) {
        for (pi in p.indices) {
            if (charMatch(s[si], p[pi])) {
                dp[si + 1][pi + 1] = dp[si][pi]
            } else if (p[pi] == '*') {
                if (charMatch(s[si], p[pi - 1])) {
                    dp[si + 1][pi + 1] = dp[si + 1][pi] || dp[si][pi + 1] || dp[si + 1][pi - 1]
                } else {
                    dp[si + 1][pi + 1] = dp[si + 1][pi - 1]
                }
            }
        }
    }
    return dp[s.length][p.length]
}

private fun charMatch(s: Char, p: Char): Boolean =
    when (p == '.') {
        (true) -> true
        (false) -> s == p
    }
