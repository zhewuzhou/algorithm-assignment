package zhewuzhou.me.leetcode180

fun convertToTitle(n: Int): String {
    val result = mutableListOf<Char>()
    var num = n
    while (num > 26) {
        result.add(calculateChar(num))
        num /= 26
        if (result.last() == 'Z') {
            num -= 1
        }
    }
    result.add(calculateChar(num))
    return result.reversed().joinToString("")
}

private fun calculateChar(n: Int) =
    if (n % 26 == 0) 'Z' else '@' + n % 26

fun titleToNumber(s: String): Int {
    if (s.isEmpty() || !s.all { it in 'A'..'Z' }) return 0
    var result = 0
    var multiple = 1
    for (i in s.lastIndex downTo 0) {
        result += (s[i] - '@') * multiple
        multiple *= 26
    }
    return result
}

