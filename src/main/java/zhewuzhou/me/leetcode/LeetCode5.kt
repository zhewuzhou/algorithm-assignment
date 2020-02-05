package zhewuzhou.me.leetcode

fun longestPalindrome(s: String): String =
        (s.indices).flatMap { s.allSubStrings(it) }.filter { it.isPalindrome() }.maxBy { it.length } ?: ""


fun String.allSubStrings(index: Int): List<String> =
        (index + 1 until length).map { this.substring(index, it + 1) }


fun String.isPalindrome(): Boolean =
        if (length < 2) false
        else (0 until (length / 2 - 1)).all { this[it] == this[this.length - it - 1] }