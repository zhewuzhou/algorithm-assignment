package zhewuzhou.me.linkedlist

import zhewuzhou.me.leetcode100.ListNode
import java.util.*


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1Cur = l1
    var l2Cur = l2
    val s1: Stack<Int> = Stack<Int>()
    val s2: Stack<Int> = Stack<Int>()
    while (l1Cur != null) {
        s1.push(l1Cur.`val`)
        l1Cur = l1Cur.next
    }
    while (l2Cur != null) {
        s2.push(l2Cur.`val`)
        l2Cur = l2Cur.next
    }
    var sum = 0
    var result = ListNode(0)
    while (!s1.empty() || !s2.empty()) {
        if (!s1.empty()) sum += s1.pop()
        if (!s2.empty()) sum += s2.pop()
        result.`val` = sum % 10
        val head = ListNode(sum / 10)
        head.next = result
        result = head
        sum /= 10
    }
    return if (result.`val` == 0) result.next else result
}

fun addTwoNumbersSlow(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    val sumOfNodes = mutableListOf<Int>()
    val len1 = length(l1)
    val len2 = length(l2)
    var l1Cur = l1
    var l2Cur = l2
    var diff = Math.abs(len1 - len2)
    when (len1.compareTo(len2)) {
        1 -> {
            while (diff > 0 && l1Cur != null) {
                sumOfNodes.add(l1Cur.`val`)
                l1Cur = l1Cur.next
                diff -= 1
            }
        }
        -1 -> {
            while (diff > 0 && l2Cur != null) {
                sumOfNodes.add(l2Cur.`val`)
                l2Cur = l2Cur.next
                diff -= 1
            }
        }
    }
    while (l1Cur != null && l2Cur != null) {
        sumOfNodes.add(l1Cur.`val` + l2Cur.`val`)
        l1Cur = l1Cur.next
        l2Cur = l2Cur.next
    }
    for (i in sumOfNodes.lastIndex downTo 0) {
        if (i > 0) {
            if (sumOfNodes[i] > 9) {
                sumOfNodes[i] -= 10
                sumOfNodes[i - 1] += 1
            }
        }
    }
    val significant = sumOfNodes[0]
    sumOfNodes[0] = if (sumOfNodes[0] > 9) sumOfNodes[0] - 10 else sumOfNodes[0]
    val result = ListNode(1)
    var cur = result
    for (i in sumOfNodes.indices) {
        val n = ListNode(sumOfNodes[i])
        cur.next = n
        cur = n
    }
    return if (significant > 9) result else result.next
}

private fun length(root: ListNode?): Int {
    var len = 0
    var cur = root
    while (cur != null) {
        len += 1
        cur = cur.next
    }
    return len
}
