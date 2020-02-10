package zhewuzhou.me.leetcode

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

fun findKthElement(l1: List<Int>, l2: List<Int>, k: Int): Int {
    check(k <= l1.size + l2.size)
    if (isOrdered(l2, l1)) return (l1 + l2)[k - 1]
    if (isOrdered(l1, l2)) return (l2 + l1)[k - 1]
    var i = 0
    var j = 0
    var iMin = 0
    var iMax = min(l1.size, k - 1)
    while (iMin <= iMax) {
        i = (iMin + iMax) / 2
        j = k - 1 - i
        if (j > 0 && l2[j - 1] > l1[i]) {
            iMin = i + 1
        } else if (i > 0 && l1[i - 1] > l2[j]) {
            iMax = i - 1
        } else {
            return min(l1[i], l2[j])
        }
    }
    return -1
}

private fun isOrdered(l2: List<Int>, l1: List<Int>): Boolean {
    if (l2.first() >= l1.last()) {
        return true
    }
    return false
}