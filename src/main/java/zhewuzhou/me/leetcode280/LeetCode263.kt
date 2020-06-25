package zhewuzhou.me.leetcode280

fun isUgly(num: Int): Boolean {
    if (num <= 0) return false
    if (num == 1) return true
    var n = num
    val factors = listOf(5, 3, 2)
    while (n != 1) {
        val factor = factors.firstOrNull { n % it == 0 }
        if (factor != null) {
            n /= factor
        } else {
            return false
        }

    }
    return true
}
