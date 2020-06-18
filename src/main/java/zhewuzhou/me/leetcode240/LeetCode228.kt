package zhewuzhou.me.leetcode240

fun summaryRanges(nums: IntArray): List<String> {
    val res = mutableListOf<String>()
    var start = 0
    var end = 0
    while (start < nums.size) {
        while (end < nums.lastIndex && nums[end] + 1 == nums[end + 1]) {
            end += 1
        }
        if (end > start) {
            res.add("${nums[start]}->${nums[end]}")
        } else {
            res.add("${nums[start]}")
        }
        end += 1
        start = end
    }
    return res.toList()
}
