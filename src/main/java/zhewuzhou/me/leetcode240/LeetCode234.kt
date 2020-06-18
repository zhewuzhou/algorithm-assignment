package zhewuzhou.me.leetcode240

import zhewuzhou.me.leetcode100.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    var slow = head
    var fast = head
    var length = 1
    var middle: ListNode? = null
    while (fast?.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        length += 2
    }
    if (fast?.next != null) length += 1
    val l2 = slow?.next
    val h2 = slow?.next
    slow?.next = null
    middle = slow
    val l1 = reverseList(head)
    val h1 = if (length % 2 == 1) l1?.next else l1
    val result = compareList(h1, h2)
    reverseList(l1)
    middle?.next = l2
    return result
}

private fun compareList(l1: ListNode?, l2: ListNode?): Boolean {
    var h1 = l1
    var h2 = l2
    var result = true
    while (h1 != null) {
        if (h1.`val` == h2?.`val`) {
            h1 = h1.next
            h2 = h2.next
        } else {
            result = false
            break
        }
    }
    return result
}

private fun reverseList(head: ListNode?): ListNode? {
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
