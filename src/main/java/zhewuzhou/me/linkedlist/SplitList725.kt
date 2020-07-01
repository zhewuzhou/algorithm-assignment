package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
    val len = length(root)
    val partLen = len / k
    var partRemaining = len % k
    val result = Array<ListNode?>(k) {
        null
    }
    var cur = root
    var i = 0
    while (cur != null) {
        result[i] = cur
        for (j in 1 until partLen) {
            cur = cur?.next
        }
        if (partLen > 0 && partRemaining > 0) {
            cur = cur?.next
            partRemaining -= 1
        }
        val t = cur?.next
        cur?.next = null
        cur = t
        i += 1

    }
    return result
}

private fun length(root: ListNode?): Int {
    var len = 0
    var cur = root
    while (cur != null) {
        len += 1
        cur = cur.next
    }
    return len
}
