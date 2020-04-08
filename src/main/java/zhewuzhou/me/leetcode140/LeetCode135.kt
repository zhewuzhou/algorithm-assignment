package zhewuzhou.me.leetcode140

fun candy(ratings: IntArray): Int {
    if (ratings.isEmpty()) return 0
    if (ratings.size == 1) return 1
    val res = IntArray(ratings.size) {
        1
    }
    val cuts = cutRatings(ratings)
    for (c in cuts) {
        handleSingular(c, res, ratings)
    }
    return res.sum()
}

fun cutRatings(ratings: IntArray): List<List<Int>> {
    val cuts = mutableListOf<List<Int>>()
    var trend = ratings[1].compareTo(ratings[0])
    var start = 2
    val cut = mutableListOf(0, 1)
    while (start <= ratings.lastIndex) {
        val tail = cut.last()
        val newTrend = ratings[start].compareTo(ratings[tail])
        if (newTrend != trend) {
            cuts.add(listOf(*cut.toTypedArray()))
            cut.clear()
            cut.add(tail)
        }
        cut.add(start)
        trend = newTrend
        start += 1
    }
    cuts.add(listOf(*cut.toTypedArray()))
    return cuts
}

private fun handleSingular(index: List<Int>, res: IntArray, ratings: IntArray) {
    val pre = res[index[0]]
    res[index[0]] = 1
    when (ratings[index[1]].compareTo(ratings[index[0]])) {
        1 -> {
            for (i in index.indices) {
                res[index[i]] += i
            }
        }
        -1 -> {
            for (i in index.lastIndex downTo 0) {
                res[index[i]] += index.lastIndex - i
            }
        }
    }
    res[index[0]] = Math.max(res[index[0]], pre)
}
