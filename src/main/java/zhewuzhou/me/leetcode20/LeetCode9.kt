package zhewuzhou.me.leetcode20

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    val digits = intToDigits(x)
    return digits.zip(digits.reversed()).all { it.first == it.second }
}

fun intToDigits(x: Int): List<Int> {
    var div = x
    val digits = mutableListOf<Int>()
    while (div >= 10) {
        digits.add(div % 10)
        div /= 10
    }
    digits.add(div)
    return digits
}
