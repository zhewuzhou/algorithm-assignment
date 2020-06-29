package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return head
    val odd = ListNode(0)
    val even = ListNode(0)
    odd.next = head
    even.next = head.next
    var oddCur = odd.next
    var evenCur = even.next
    var pre: ListNode? = null
    while (oddCur != null) {
        oddCur.next = evenCur?.next
        evenCur?.next = oddCur.next?.next
        pre = oddCur
        oddCur = oddCur.next
        evenCur = evenCur?.next
    }
    pre?.next = even.next
    return odd.next
}
