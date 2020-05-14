package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun hasCycle(head: ListNode?): Boolean {
    var walker = head
    var runner = head
    while (runner?.next != null && runner.next?.next != null) {
        walker = walker?.next
        runner = runner.next?.next
        if (walker === runner) return true
    }
    return false
}
