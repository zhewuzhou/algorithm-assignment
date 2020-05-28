package zhewuzhou.me.leetcode160

import zhewuzhou.me.leetcode100.ListNode

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    if (head.next?.next == null) {
        return if (head.`val` > head.next!!.`val`) {
            val nh = head.next
            nh?.next = head
            head.next = null
            nh
        } else {
            head
        }
    }

    var fast = head
    var slow = head
    while (fast?.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    val l2 = slow?.next
    slow?.next = null

    return merge(sortList(head), sortList(l2))
}

fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
    var h1 = l1
    var h2 = l2
    val dummyHead = ListNode(-1)
    var h: ListNode? = dummyHead
    while (h != null) {
        if (h1 == null) {
            h.next = h2
            h2 = h2?.next
        } else if (h2 == null) {
            h.next = h1
            h1 = h1.next
        } else {
            if (h1.`val` < h2.`val`) {
                h.next = h1
                h1 = h1.next
            } else {
                h.next = h2
                h2 = h2.next
            }
        }
        h = h.next
    }
    return dummyHead.next
}

fun insertionSortList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val helper = ListNode(0) //new starter of the sorted list
    var cur = head //the node will be inserted
    var pre: ListNode? = helper //insert node between pre and pre.next
    var next: ListNode? = null //the next node will be inserted
    //not the end of input list
    while (cur != null) {
        next = cur.next
        //find the right place to insert
        while (pre!!.next != null && pre.next!!.`val` < cur.`val`) {
            pre = pre.next
        }
        //insert between pre and pre.next
        cur.next = pre.next
        pre.next = cur
        pre = helper
        cur = next
    }
    return helper.next
}
