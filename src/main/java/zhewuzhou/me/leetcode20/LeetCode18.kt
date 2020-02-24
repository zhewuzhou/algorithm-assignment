package zhewuzhou.me.leetcode20

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    nums.sort()
    var pos = 0
    val ts = nums.size
    val max3Sum = nums[ts - 1] + nums[ts - 2] + nums[ts - 3]
    while (pos < ts - 3) {
        val min3Sum = nums[pos + 1] + nums[pos + 2] + nums[pos + 3]
        val curTarget = target - nums[pos]
        if (curTarget in min3Sum..max3Sum) {
            val possibleThree = threeSum(nums, pos + 1, curTarget)
            if (possibleThree.isNotEmpty()) {
                possibleThree.map { it.add(0, nums[pos]) }
            }
            result.addAll(possibleThree)
        }
        while (pos < nums.size - 3 && nums[pos] == nums[pos + 1]) {
            pos += 1
        }
        pos += 1
    }
    return result
}
