package zhewuzhou.me.leetcode

import java.lang.Integer.max
import java.lang.Integer.min

/*
A[a, b, c .. x]: median is the middle elem m
B[a1, b1, c1, ..x1] median is the middle elem m1
find mth element in 2 list:
for x - 1 = i + j
All B[0..j] < A[i] && A[0
 */

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val totalSize = nums1.size + nums2.size
    return if (totalSize % 2 == 0)
        (findKthElement(nums1.toList(), nums2.toList(), totalSize / 2)
            + findKthElement(nums1.toList(), nums2.toList(), totalSize / 2 + 1)) / 2.0
    else findKthElement(nums1.toList(), nums2.toList(), totalSize / 2 + 1).toDouble()
}

fun findKthElement(lhs: List<Int>, rhs: List<Int>, k: Int): Int {
    if (k == lhs.size + rhs.size) {
        return max(lhs.last(), rhs.last())
    }
    var start = 0
    var end = min(lhs.size - 1, k - 1)
    while (start <= end) {
        val lPartition = (end + start) / 2
        val rPartition = k - lPartition - 1
        if (rPartition <= rhs.size - 1) {
            val lhsValidSplit = when (rPartition > 0) {
                (true) -> lPartition == lhs.size - 1 || lhs[lPartition] >= rhs[rPartition - 1]
                (false) -> true
            }
            val rhsValidSplit = when (lPartition > 0) {
                (true) -> lhs[lPartition - 1] <= rhs[rPartition]
                (false) -> true
            }
            if (lhsValidSplit && rhsValidSplit) {
                return kthByPartition(lhs, lPartition, rhs, rPartition)
            }
            if (lPartition > 0 && lhs[lPartition - 1] > rhs[rPartition]) {
                end = lPartition - 1
            } else {
                start = lPartition + 1
            }
        } else {
            start = lPartition + 1
        }
    }
    return 0
}

private fun kthByPartition(lhs: List<Int>, lPartition: Int, rhs: List<Int>, rPartition: Int): Int {
    if (lPartition == lhs.size - 1 && rPartition >= 1) {
        if (lhs[lPartition] <= rhs[rPartition - 1]) {
            return rhs[rPartition - 1]
        }
    }
    if (rPartition == rhs.size - 1 && lPartition >= 1) {
        if (rhs[rPartition] <= lhs[lPartition - 1]) {
            return lhs[lPartition - 1]
        }
    }
    return min(lhs[lPartition], rhs[rPartition])
}

private fun isOrdered(l2: List<Int>, l1: List<Int>): Boolean {
    if (l2.first() >= l1.last()) {
        return true
    }
    return false
}
