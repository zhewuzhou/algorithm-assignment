package zhewuzhou.me.leetcode100

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty()) return listOf(listOf())
    val res = mutableSetOf(listOf<Int>())
    subSets(res, nums, mutableListOf(), 0)
    res.add(nums.toList().sorted())
    return res.toList()
}

private fun subSets(res: MutableSet<List<Int>>, source: IntArray, comb: MutableList<Int>, start: Int) {
    res.add(listOf(*comb.toTypedArray().sortedArray()))
    if (comb.size < source.size - 1) {
        for (i in start until source.size) {
            comb.add(source[i])
            subSets(res, source, comb, i + 1)
            comb.removeAt(comb.lastIndex)
        }
    }
}
