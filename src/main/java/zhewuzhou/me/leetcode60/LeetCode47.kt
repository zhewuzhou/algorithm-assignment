package zhewuzhou.me.leetcode60

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    doSearch(result, nums, mutableListOf<Int>(), BooleanArray(nums.size))
    return result
}

private fun doSearch(result: MutableList<MutableList<Int>>, nums: IntArray, comb: MutableList<Int>, used: BooleanArray) {
    println("==========================================")
    println("result: $result")
    println("used: ${used.toList()}")
    println("comb: $comb")
    println("==========================================")
    if (comb.size < nums.size) {
        for (i in nums.indices) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                if (!used[i]) {
                    println("**************************************")
                    println("i: $i")
                    println("used[i]: ${used[i]}")
                    println("used[i-1]: ${used[i - 1]}")
                    println("nums[i]: ${nums[i]}")
                    println("nums: ${nums.toList()}")
                    println("comb: $comb")
                    println("**************************************")
                }
                continue
            }
            used[i] = true;
            comb.add(nums[i])
            doSearch(result, nums, comb, used)
            used[i] = false
            comb.removeAt(comb.lastIndex)
        }
    } else {
        result.add(mutableListOf(*comb.toTypedArray()))
    }
}
