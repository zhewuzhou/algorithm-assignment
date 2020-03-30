package zhewuzhou.me.leetcode140

//egg not larger than log(l) or else lose meaning
fun eggThrowDP(egg: Int, level: Int): Int {
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
