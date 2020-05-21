package zhewuzhou.me.dp

fun countBits(num: Int): IntArray {
    val result = IntArray(num + 1)
    var seed = 1
    while (seed <= num) {
        for (i in seed..Math.min(num, seed * 2 - 1)) {
            result[i] = 1 + result[i - seed]
        }
        seed *= 2
    }
    return result
}
