package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun reorderList(head: ListNode?): Unit {
    if (head?.next?.next == null) return
    var slow = head
    var fast = head

    while (fast?.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    val headOfL2 = slow?.next
    slow?.next = null

    val l2 = reverseList(headOfL2)
    merge(head, l2)

}

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    var next: ListNode? = null
    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}

fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
    var h1 = l1
    var h2 = l2
    while (h1 != null) {
        val n1 = h1.next
        val n2 = h2?.next
        h1.next = h2
        h2?.next = n1
        h2 = n2
        h1 = n1
    }
    return l1
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var cur = head
    while (cur != null) {
        val sectionHead = cur
        while (cur.next?.`val` == sectionHead.`val`) {
            cur.next = cur.next?.next
        }
        cur = cur.next
    }
    return head
}
