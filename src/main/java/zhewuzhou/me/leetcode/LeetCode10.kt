package zhewuzhou.me.leetcode

fun isMatch(s: String, p: String): Boolean =
    match(s, 0, p, 0)

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

private fun charMatch(s: Char, p: Char): Boolean =
    when (p == '.') {
        (true) -> true
        (false) -> s == p
    }
