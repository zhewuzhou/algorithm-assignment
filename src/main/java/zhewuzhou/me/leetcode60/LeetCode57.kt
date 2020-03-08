package zhewuzhou.me.leetcode60

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val res = mutableListOf<IntArray>()
    //looking for low
    val low = searchForLowerBound(intervals, newInterval[0])
    if (low == -1) {
        res.addAll(intervals.toList())
        res.add(newInterval)
        return res.toTypedArray()
    }
    val upper = searchForUpperBound(intervals, newInterval[1])
    if (upper == -1) {
        res.add(newInterval)
        res.addAll(intervals.toList())
        return res.toTypedArray()
    }
    if (low > 0) {
        res.addAll(intervals.toList().subList(0, low))
    }
    res.add(arrayOf(
        Math.min(intervals[low][0], newInterval[0]),
        Math.max(intervals[upper][1], newInterval[1])).toIntArray()
    )
    if (upper < intervals.lastIndex) {
        res.addAll(intervals.toList().subList(upper + 1, intervals.size))
    }

    return res.toTypedArray()
}

fun searchForLowerBound(intervals: Array<IntArray>, target: Int): Int {
    var start = 0
    var end = intervals.lastIndex
    while (start <= end) {
        val mid = (start + end + 1) / 2
        if ((intervals[mid][0] <= target && intervals[mid][1] >= target) ||
            (mid > 0 && intervals[mid][0] > target && intervals[mid - 1][1] < target) ||
            mid == 0 && intervals[mid][0] >= target) {
            return mid
        } else if (intervals[mid][0] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}

fun searchForUpperBound(intervals: Array<IntArray>, target: Int): Int {
    var start = 0
    var end = intervals.lastIndex
    while (start <= end) {
        val mid = (start + end + 1) / 2
        if ((intervals[mid][0] <= target && intervals[mid][1] >= target) ||
            (mid < intervals.lastIndex && intervals[mid][1] < target && intervals[mid + 1][0] > target) ||
            mid == intervals.lastIndex && intervals[mid][1] <= target) {
            return mid
        } else if (intervals[mid][1] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}
