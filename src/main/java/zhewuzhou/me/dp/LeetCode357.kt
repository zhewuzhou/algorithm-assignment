package zhewuzhou.me.dp

fun countNumbersWithUniqueDigits(n: Int): Int {
    if (n == 0) return 1
    val caches = mutableMapOf<Int, Int>()
    for (i in 1..n) {
        caches[i] = permutationsOn9(i)
    }
    val metrics = IntArray(n + 1) { 10 }
    for (i in 2..n) {
        metrics[i] = metrics[i - 1] + caches[i]!! + (i - 1) * caches[i - 1]!!
    }
    return metrics[n]
}

fun permutationsOn9(selected: Int): Int {
    var result = 1
    var base = 9
    repeat(selected) {
        result *= base
        base -= 1
    }
    return result
}
