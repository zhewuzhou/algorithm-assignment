package zhewuzhou.me.leetcode

fun intToRoman(num: Int): String {
    val lm = listOf("", "M", "MM", "MMM")
    val lc = listOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val lx = listOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val li = listOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    return lm[num / 1000] + lc[num % 1000 / 100] + lx[num % 100 / 10] + li[num % 10]
}
