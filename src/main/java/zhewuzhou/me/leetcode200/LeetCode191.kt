package zhewuzhou.me.leetcode200

fun hammingWeight(n: Int): Int {
    var num = n
    var result = 0
    for (i in 0..31) {
        result += num.and(1)
        num = num.shr(1)
    }
    return result
}
