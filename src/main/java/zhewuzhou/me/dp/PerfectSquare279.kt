package zhewuzhou.me.dp

fun numSquares(n: Int): Int {
    if (n < 1) return 0
    val metrics = Array(n + 1) {
        n + 1
    }
    for (i in 1..metrics.lastIndex) {
        when (isSquareNumber(i)) {
            true -> metrics[i] = 1
            false -> {
                var min = n + 1
                var count = 1
                while (count * count < i) {
                    min = Math.min(metrics[i - count * count] + 1, min)
                    count += 1
                }
                metrics[i] = min
            }
        }
    }
    return metrics.last()
}

private fun isSquareNumber(n: Int): Boolean {
    var t = 1
    while (t * t <= n) {
        if (t * t == n) return true
        t += 1
    }
    return false
}
