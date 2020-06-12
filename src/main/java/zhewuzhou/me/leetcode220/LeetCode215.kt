package zhewuzhou.me.leetcode220

import java.util.*


fun findKthLargest(nums: IntArray, k: Int): Int {
    val numsList = nums.toMutableList()
    numsList.shuffle()
    val kth = nums.size - k
    var lo = 0
    var hi = nums.size - 1
    while (lo < hi) {
        val j = partition(numsList, lo, hi)
        if (j < kth) {
            lo = j + 1
        } else if (j > kth) {
            hi = j - 1
        } else {
            break
        }
    }
    return numsList[kth]
}

private fun partition(a: MutableList<Int>, lo: Int, hi: Int): Int {
    var start = lo
    var end = hi + 1
    while (true) {
        do {
            start += 1
        } while (start < hi && isLessThan(a[start], a[lo]))

        do {
            end -= 1
        } while (end > lo && isLessThan(a[lo], a[end]))

        if (start >= end) {
            break
        }
        swap(a, start, end)
    }
    swap(a, lo, end)
    return end
}

private fun swap(a: MutableList<Int>, i: Int, j: Int) {
    val tmp = a[i]
    a[i] = a[j]
    a[j] = tmp
}

private fun isLessThan(v: Int, w: Int): Boolean {
    return v < w
}

fun findKthLargestQueue(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>()
    for (v in nums) {
        pq.offer(v)
        if (pq.size > k) {
            pq.poll()
        }
    }
    return pq.peek()
}
