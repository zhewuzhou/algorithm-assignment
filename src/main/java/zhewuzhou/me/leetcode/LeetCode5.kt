package zhewuzhou.me.leetcode

fun longestPalindrome(s: String): String {
    return ""
}

fun String.isPalindrome(): Boolean =
        if (length < 2) false
        else (0 until (length / 2 - 1)).all { this[it] == this[this.length - it - 1] }