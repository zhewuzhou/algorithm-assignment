package zhewuzhou.me.leetcode

data class SumEle(val a: Int, val b: Int, val c: Int)

fun threeSumSlow(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<SumEle>()
    val rhs = nums.filter { it >= 0 }
    val lhs = nums.filter { it < 0 }
    if (nums.filter { it == 0 }.size >= 3) {
        result.add(SumEle(0, 0, 0))
    }
    for (a in lhs) {
        val rr = rhs.filter { it <= Math.abs(a) }
        for (bi in rr.indices) {
            for (ci in rr.indices) {
                if (bi != ci && rr[bi] <= rr[ci] && rr[bi] + rr[ci] == Math.abs(a)) {
                    result.add(SumEle(a, rr[bi], rr[ci]))
                }
            }
        }
    }
    for (c in rhs) {
        val lr = lhs.filter { Math.abs(it) < c }
        for (bi in lr.indices) {
            for (ai in lr.indices) {
                if (bi != ai && lr[ai] <= lr[bi] && Math.abs(lr[ai] + lr[bi]) == c) {
                    result.add(SumEle(lr[ai], lr[bi], c))
                }
            }
        }
    }
    return result.toList().map { listOf(it.a, it.b, it.c) }
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<SumEle>()
    nums.sort()
    var ni = 0
    while (ni < nums.size && nums[ni] <= 0) {
        val target = -nums[ni]
        var start = ni + 1
        var end = nums.size - 1
        while (start < end) {
            when ((nums[start] + nums[end]).compareTo(target)) {
                1 -> end -= 1
                -1 -> start += 1
                0 -> {
                    result.add(SumEle(nums[ni], nums[start], nums[end]))
                    while (start < end && nums[start] == nums[start + 1]) {
                        start += 1
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end -= 1
                    }
                    start += 1
                    end = nums.size - 1
                }
            }
        }
        while (ni < nums.size - 1 && nums[ni] == nums[ni + 1]) {
            ni += 1
        }
        ni += 1
    }
    return result.map { listOf(it.a, it.b, it.c) }
}
