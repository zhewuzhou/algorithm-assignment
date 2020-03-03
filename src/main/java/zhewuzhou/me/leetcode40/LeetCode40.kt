package zhewuzhou.me.leetcode40

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    val result = mutableListOf<MutableList<Int>>()
    doSearch(result, mutableListOf<Int>(), candidates.toList(), target, 0)
    return result
}

private fun doSearch(result: MutableList<MutableList<Int>>, comb: MutableList<Int>, nums: List<Int>, remain: Int, start: Int) {
    when (remain.compareTo(0)) {
        -1 -> return
        0 -> result.add(mutableListOf(*comb.toTypedArray()))
        1 -> {
            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1]) continue
                if (nums[i] <= remain) {
                    comb.add(nums[i])
                    doSearch(result, comb, nums, remain - nums[i], i + 1)
                    comb.removeAt(comb.lastIndex)
                }
            }
        }
    }
}
