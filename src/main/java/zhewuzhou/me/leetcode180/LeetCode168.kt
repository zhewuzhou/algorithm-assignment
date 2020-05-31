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

