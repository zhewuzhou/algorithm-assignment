package zhewuzhou.me.leetcode100

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    //first part
    var curBeforeReverse: ListNode? = dummy
    var preBeforeReverse: ListNode? = null
    for (i in 0 until m) {
        preBeforeReverse = curBeforeReverse
        curBeforeReverse = curBeforeReverse?.next
    }

    //reverse
    var cur = curBeforeReverse
    var pre = preBeforeReverse
    for (i in m..n) {
        val next: ListNode? = cur?.next
        cur?.next = pre
        pre = cur
        cur = next
    }

    //connect
    preBeforeReverse?.next = pre
    curBeforeReverse?.next = cur
    return dummy.next
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    var cur = head
    if (cur?.next == null) return cur
    return if (cur.`val` != cur.next!!.`val`) {
        cur.next = deleteDuplicates(cur.next)
        cur
    } else {
        while (cur!!.next != null && cur.`val` == cur.next!!.`val`)
            cur = cur.next
        deleteDuplicates(cur.next)
    }
}

fun partition(head: ListNode?, x: Int): ListNode? {
    val firstHead = ListNode(-1)
    val secondHead = ListNode(-1)
    var firstCur = firstHead
    var secondCur = secondHead
    var cur = head
    while (cur != null) {
        when (cur.`val` < x) {
            true -> {
                firstCur.next = cur
                firstCur = cur
            }
            false -> {
                secondCur.next = cur
                secondCur = cur
            }
        }
        cur = cur.next
    }
    secondCur.next = null
    if (firstHead.next == null) return secondHead.next
    if (secondHead.next == null) return firstHead.next
    firstCur.next = secondHead.next
    return firstHead.next
}
