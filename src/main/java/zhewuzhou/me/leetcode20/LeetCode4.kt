package zhewuzhou.me.leetcode20

/*
A[a, b, c .. x]: median is the middle elem m
B[a1, b1, c1, ..x1] median is the middle elem m1
find mth element in 2 list:
for x - 1 = i + j
All B[0..j] < A[i] && A[0
 */

fun findMedianSortedArrays(lhs: IntArray, rhs: IntArray): Double {
    val total = lhs.size + rhs.size
    return when (total % 2 == 0) {
        (true) -> (kth(lhs, 0, rhs, 0, total / 2) + kth(lhs, 0, rhs, 0, (total / 2 + 1))) / 2.0
        (false) -> kth(lhs, 0, rhs, 0, (total + 1) / 2).toDouble()
    }
}

fun kth(lhs: IntArray, ls: Int, rhs: IntArray, rs: Int, k: Int): Int {
    if (ls > lhs.size - 1) return rhs[rs + k - 1]
    if (rs > rhs.size - 1) return lhs[ls + k - 1]
    if (k == 1) return Math.min(lhs[ls], rhs[rs])
    var aMid = Int.MAX_VALUE
    var bMid = Int.MAX_VALUE
    if (ls + k / 2 - 1 < lhs.size) aMid = lhs[ls + k / 2 - 1]
    if (rs + k / 2 - 1 < rhs.size) bMid = rhs[rs + k / 2 - 1]
    return if (aMid < bMid) kth(lhs, ls + k / 2, rhs, rs, k - k / 2) // Check: aRight + bLeft
    else kth(lhs, ls, rhs, rs + k / 2, k - k / 2) // Check: bRight + aLeft
}
