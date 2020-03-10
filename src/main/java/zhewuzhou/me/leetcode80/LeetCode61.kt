package zhewuzhou.me.leetcode80


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if(head == null) return null
    if(head?.next == null) return head
    val mapping = mutableMapOf<Int, ListNode>()
    var cur = head
    var index = 0
    while (cur != null) {
        mapping[index] = cur
        cur = cur.next
        index += 1
    }
    mapping[mapping.size-1]?.next = head
    val total = mapping.size
    val newEnd = (total-1) - k % total
    val newHead = mapping[newEnd]?.next
    mapping[newEnd]?.next = null
    return newHead
}
