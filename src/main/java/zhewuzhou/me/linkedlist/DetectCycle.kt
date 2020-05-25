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

fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) return null
    var slow = head
    var fast = head
    var cycleStart = head
    while (slow != null || fast != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if (slow == fast) {
            while (cycleStart != slow) {
                cycleStart = cycleStart?.next
                slow = slow?.next
            }
            return cycleStart
        }
    }
    return null
}
