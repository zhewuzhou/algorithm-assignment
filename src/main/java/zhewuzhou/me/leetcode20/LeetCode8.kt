package zhewuzhou.me.leetcode20

fun myAtoi(str: String): Int {
    val validStr = extractInt(str)
    if (validStr.isEmpty()) {
        return 0
    }
    val flag = if (validStr[0].toString() == "-") -1 else 1
    return toInt(validStr
        .map { it.toString() }
        .filter { it != "-" && it != "+" }
        .map { it.toInt() }, flag)
}

fun toInt(digits: List<Int>, flag: Int): Int {
    var len = 0
    var res = 0
    var pre = 0
    while (len < digits.size) {
        res = res * 10 + digits[len]
        if (res < 0 || (res - digits[len]) / 10 != pre) {
            return if (flag == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }
        pre = res
        len++
    }
    return res * flag
}

fun extractInt(input: String): String =
    Regex("^\\s*([-\\+]?[0-9]+)").find(input)?.groupValues?.get(1) ?: ""

