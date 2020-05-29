package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode

fun getIntersectionNode(la: ListNode?, lb: ListNode?): ListNode? {
    if (la == null || lb == null) return null
    if (la == lb) return la
    if (la.next == null) {
        var cur = lb
        while (cur != null) {
            if (cur == la) {
                return cur
            }
            cur = cur.next
        }
    }
    if (lb.next == null) {
        var cur = la
        while (cur != null) {
            if (cur == lb) {
                return cur
            }
            cur = cur.next
        }
    }
    var tailOfB = lb
    while (tailOfB?.next != null) {
        tailOfB = tailOfB.next
    }
    tailOfB?.next = lb
    val result = detectCycle(la)
    tailOfB?.next = null
    return result
}
