package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun removeElements(head: ListNode?, v: Int): ListNode? {
    val dummyHead = ListNode(v - 1)
    dummyHead.next = head
    var cur = head
    var pre = dummyHead
    while (cur != null) {
        if (cur.`val` == v) {
            pre.next = cur.next
            cur = pre.next
        } else {
            pre = cur
            cur = cur.next
        }
    }
    return dummyHead.next
}
