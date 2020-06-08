package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun reverseListR(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val hn = head.next
    head.next = null
    val reversedHead = reverseListR(hn)
    hn?.next = head
    return reversedHead
}
