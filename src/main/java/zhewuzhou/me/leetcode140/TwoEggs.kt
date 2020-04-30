package zhewuzhou.me.leetcode140

//egg not larger than log(l) or else lose meaning
fun eggThrowDPRecur(egg: Int, level: Int): Int {
    val caches = mutableMapOf<Pair<Int, Int>, Int>()
    fun eggThrow(e: Int, l: Int): Int {
        if (caches.containsKey(Pair(e, l))) {
            return caches[Pair(e, l)]!!
        }
        var res = l
        when {
            e == 1 -> res = l
            l == 1 -> res = 1
            else -> {
                for (k in 1..l) {
                    val possible = Math.max(eggThrow(e - 1, k), eggThrow(e, l - k)) + 1
                    if (res > possible) {
                        res = possible
                    }
                }
            }
        }
        caches[Pair(e, l)] = res
        return res
    }
    return eggThrow(egg, level)
}

fun eggThrow(e: Int, l: Int): Int {
    check(e > 0) {
        "Egg can not be negative number."
    }
    check(l > 0) {
        "Level can not be negative number."
    }
    val metrics = Array(e + 1) {
        IntArray(l + 1) {
            -1
        }
    }
    for (i in 1..l) {
        metrics[1][i] = i
    }
    for (i in 1..e) {
        metrics[i][1] = 1
    }
    for (i in 2..e) {
        for (j in 2..l) {
            var minTries = j
            for (k in 1 until j) {
                val p = Math.max(metrics[i - 1][k], metrics[i][j - k]) + 1
                minTries = Math.min(minTries, p)
            }
            metrics[i][j] = minTries
        }
    }
    return metrics[e][l]
}
