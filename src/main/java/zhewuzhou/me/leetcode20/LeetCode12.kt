package zhewuzhou.me.leetcode20

fun intToRoman(num: Int): String {
    val lm = listOf("", "M", "MM", "MMM")
    val lc = listOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val lx = listOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val li = listOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    return lm[num / 1000] + lc[num % 1000 / 100] + lx[num % 100 / 10] + li[num % 10]
}

/*
 1. What if string is not valid
 */

fun romanToInt(s: String): Int {
    val rules = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000)

    val specialRules = mapOf(
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900)

    var i = 0
    var result = 0
    var pre = 0
    while (i < s.length) {
        if (i != s.length - 1 && specialRules.containsKey(s.substring(i..i + 1))) {
            val cur = specialRules.getValue(s.substring(i..i + 1))
            if (pre != 0 && cur > pre) {
                throw IllegalArgumentException()
            }
            result += cur
            pre = cur
            i += 2
        } else if (rules.containsKey(s.substring(i..i))) {
            val cur = rules.getValue(s.substring(i..i))
            if (pre != 0 && cur > pre) {
                throw IllegalArgumentException()
            }
            result += cur
            pre = cur
            i += 1
        } else {
            throw IllegalArgumentException()
        }
    }
    return result
}

