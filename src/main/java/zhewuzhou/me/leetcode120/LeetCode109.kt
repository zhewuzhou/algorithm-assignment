package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.ListNode
import zhewuzhou.me.leetcode100.TreeNode

fun pickNthElement(head: ListNode?, n: Int): Pair<ListNode?, Int> {
    var pc = 1
    var cur = head
    while (pc <= n && cur != null) {
        cur = cur.next
        pc += 1
    }
    val nh = cur?.next
    cur?.next = null
    return Pair(nh, cur?.`val`!!)
}

private fun listNodeLength(head: ListNode?): Int {
    var nh = head
    var length = 1
    while (nh?.next != null) {
        nh = nh.next
        length += 1
    }
    return length
}

fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null
    val length = listNodeLength(head)
    if (length == 1) return TreeNode(head.`val`)
    val (right, rootVal) = pickNthElement(head, length / 2)
    val root = TreeNode(rootVal)
    root.left = sortedListToBST(head)
    if (right != null) root.right = sortedListToBST(right)
    return root
}
