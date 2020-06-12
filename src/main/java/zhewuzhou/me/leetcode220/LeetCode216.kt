package zhewuzhou.me.leetcode220

fun combinationSum3(k: Int, target: Int): List<List<Int>> {
    if (k == 1) return if (target in 1..9) listOf(listOf(target)) else listOf()
    val maxKSum = maxKSum(k)
    val minKSum = minKSum(k)
    if (target > maxKSum || target < minKSum) return listOf()

    fun doSearch(res: MutableSet<List<Int>>,
                 comb: MutableList<Int>,
                 space: List<Int>,
                 start: Int) {
        if (comb.size == k) {
            if (comb.sum() == target) {
                res.add(comb.toList())
                return
            }
            return
        }
        if (start > space.lastIndex) {
            return
        }
        for (i in start..(space.size - (k - comb.size))) {
            comb.add(space[i])
            doSearch(res, comb, space, i + 1)
            comb.remove(comb.last())
        }
    }

    val hi = upperBound(k, target)
    val lo = lowerBound(k, target)
    val result = mutableSetOf<List<Int>>()
    doSearch(result, mutableListOf(), (lo..hi).toList(), 0)
    return result.toList()
}


fun lowerBound(k: Int, target: Int): Int {
    val o = target - maxKSum(k - 1)
    return if (o < 1) 1 else o
}

fun upperBound(k: Int, target: Int): Int {
    val u = target - minKSum(k - 1)
    return if (u > 9) 9 else u
}

fun maxKSum(k: Int): Int {
    if (k < 1 || k > 9) return Int.MIN_VALUE
    return (9 downTo 10 - k).sum()
}

fun minKSum(k: Int): Int {
    if (k < 1 || k > 9) return Int.MAX_VALUE
    return (1..k).sum()
}
