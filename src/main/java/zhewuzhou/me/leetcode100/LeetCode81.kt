package zhewuzhou.me.leetcode100

/*
Actually nums.any {it == target} is't slow at all
 */
fun search(nums: IntArray, target: Int): Boolean {
    var s = 0
    var e = nums.size
    while (s < e) {
        val mid = (s + e) / 2
        if (nums[mid] == target) return true
        if (nums[mid] > nums[s]) {
            if (target < nums[mid] && target >= nums[s]) e = mid else s = mid + 1
        } else if (nums[mid] < nums[s]) {
            if (target > nums[mid] && target < nums[s]) s = mid + 1 else e = mid
        } else {
            s++
        }
    }
    return false
}

fun searchB(nums: IntArray, target: Int): Boolean {
    if (nums.isEmpty()) return false
    nums.any { it == target }
    var start = 0
    var end = nums.lastIndex
    if (target < nums[0] && target > nums[end]) {
        return false
    } else if (target >= nums[0] && target > nums[end]) {
        while (end > 0 && nums[end] >= nums[end - 1]) end -= 1
        return binarySearch(nums, 0, end - 1, target)
    } else if (target < nums[0] && target <= nums[end]) {
        while (start < nums.lastIndex && nums[start] <= nums[start + 1]) start += 1
        return binarySearch(nums, start + 1, end, target)
    } else {
        while (start <= end) {
            if (nums[start] == target || nums[end] == target) return true
            if (nums[start] <= nums[start + 1]) {
                start += 1
            } else {
                return binarySearch(nums, start + 1, end, target)
            }
            if (nums[end] >= nums[end - 1]) {
                end -= 1
            } else {
                return binarySearch(nums, start, end - 1, target)
            }
        }
        return false
    }
}

fun binarySearch(nums: IntArray, s: Int, e: Int, target: Int): Boolean {
    var start = s
    var end = e
    while (start <= end) {
        var mid = (start + end + 1) / 2
        when (nums[mid].compareTo(target)) {
            0 -> return true
            1 -> {
                while (mid > s && nums[mid] == nums[mid - 1]) mid -= 1
                end = mid - 1
            }
            -1 -> {
                while (mid < e && nums[mid] == nums[mid + 1]) mid += 1
                start = mid + 1
            }
        }
    }
    return false
}
