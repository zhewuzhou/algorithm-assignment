package zhewuzhou.me.leetcode20

fun reverse(x: Int): Int {
    var div = x
    var prevRev = 0
    var rev = 0
    while (div != 0) {
        rev = rev * 10 + div % 10
        if ((rev - div % 10) / 10 != prevRev) {
            return 0
        }
        prevRev = rev
        div /= 10
    }
    return rev
}
