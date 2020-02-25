package zhewuzhou.me.leetcode40

fun swapPairs(head: ListNode?): ListNode? {
    var start = head
    var next = head?.next
    var preNext: ListNode? = null
    var nh = when (next == null) {
        true -> start
        false -> next
    }
    while (start != null && next != null) {
        val nn = next.next
        next.next = start
        start.next = nn
        when (preNext == null) {
            true -> preNext = start
            false -> {
                preNext.next = next
                preNext = start
            }
        }
        start = nn
        next = start?.next
    }
    return nh
}
