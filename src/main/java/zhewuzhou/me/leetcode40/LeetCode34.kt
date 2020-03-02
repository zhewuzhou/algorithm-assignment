package zhewuzhou.me.leetcode40

fun searchRange(nums: IntArray, target: Int): IntArray {
    val notFound = listOf(-1, -1).toIntArray()
    if (nums.isEmpty()) return notFound
    val start = searchStart(nums, target)
    return when (start == -1) {
        true -> notFound
        false -> listOf(start, searchEnd(nums, target)).toIntArray()
    }
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        when (nums[mid].compareTo(target)) {
            0 -> return mid
            1 -> high = mid - 1
            -1 -> low = mid + 1
        }
    }
    return low
}

fun searchStart(nums: IntArray, target: Int): Int {
    return searchConditions(nums, target,
        { mid ->
            (nums[mid] == target && mid == 0) ||
                (nums[mid] == target && nums[mid - 1] < nums[mid])
        },
        { mid -> (nums[mid] == target && mid > 0 && nums[mid - 1] == target) },
        { false })
}

fun searchEnd(nums: IntArray, target: Int): Int {
    return searchConditions(nums, target,
        { mid ->
            (nums[mid] == target && mid == nums.size - 1) ||
                (nums[mid] == target && nums[mid + 1] > nums[mid])
        },
        { false },
        { mid -> (nums[mid] == target && mid < nums.size - 1 && nums[mid + 1] == target) })
}

fun searchConditions(nums: IntArray, target: Int,
                     found: (mid: Int) -> Boolean,
                     reduceHighBound: (mid: Int) -> Boolean,
                     increaseLowBound: (mid: Int) -> Boolean): Int {
    val maxIndex = nums.size - 1
    var mid = (maxIndex + 1) / 2
    var lBound = 0
    var hBound = maxIndex
    while (lBound <= hBound) {
        when (found(mid)) {
            true -> return mid
            false -> {
                if (nums[mid] > target || reduceHighBound(mid)) {
                    hBound = mid - 1
                } else if (nums[mid] < target || increaseLowBound(mid)) {
                    lBound = mid + 1
                }
            }
        }
        mid = (lBound + hBound + 1) / 2
    }
    return -1
}
