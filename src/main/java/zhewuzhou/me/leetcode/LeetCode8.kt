package zhewuzhou.me.leetcode

fun myAtoi(str: String): Int {
    return 0
}

fun extractInt(input: String): String =
    Regex("^\\s*(-*[0-9]+)").find(input)?.groupValues?.get(1) ?: ""

