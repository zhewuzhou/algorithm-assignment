package zhewuzhou.me.leetcode40

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    when (nums.size) {
        1 -> return if (nums[0] == target) 0 else -1
        2 -> {
            return when (target) {
                nums[0] -> 0
                nums[1] -> 1
                else -> -1
            }
        }
        else -> {
            val pivot = findPivot(nums)
            val lhs = binarySearch(nums.copyOfRange(0, pivot), target)
            return when (lhs != -1) {
                true -> lhs
                false -> {
                    val rhs = binarySearch(nums.copyOfRange(pivot, nums.size), target)
                    if (rhs == -1) -1 else pivot + rhs
                }
            }
        }
    }
}

fun binarySearch(nums: IntArray, target: Int): Int {
    var mid = (nums.size - 1) / 2
    var lowBound = 0
    var upBound = nums.size - 1
    while (lowBound <= upBound) {
        when (nums[mid].compareTo(target)) {
            0 -> return mid
            1 -> {
                upBound = mid - 1
            }
            -1 -> {
                lowBound = mid + 1
            }
        }
        mid = (upBound + lowBound + 1) / 2
    }
    return -1
}

fun findPivot(nums: IntArray): Int {
    var mid = (nums.size - 1) / 2
    var lowBound = 0
    var upBound = nums.size - 1
    while (lowBound < upBound) {
        when (nums[mid].compareTo(nums[0])) {
            0 -> return 0
            1 -> {
                if (mid + 1 < nums.size && nums[mid + 1] < nums[mid])
                    return mid + 1
                else
                    lowBound = mid + 1
            }
            -1 -> {
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                    return mid
                else
                    upBound = mid - 1
            }
        }
        mid = (upBound + lowBound + 1) / 2
    }
    return when (mid == nums.size - 1) {
        true -> {
            if (nums[nums.size - 1] > nums[0]) 0 else nums.size - 1
        }
        false -> mid
    }
}
