package zhewuzhou.me.leetcode20

fun longestPalindromeBruteForce(s: String): String =
        (s.indices).map { s.longestByIndex(it) }.maxBy { it.length } ?: ""


fun String.longestByIndex(index: Int): String =
        (index until length)
                .map { this.substring(index, it + 1) }
                .filter { it.isPalindrome() }
                .maxBy { it.length } ?: ""


fun String.isPalindrome(): Boolean =
        if (length < 2) true
        else (0 until (length / 2)).all { this[it] == this[this.length - it - 1] }
