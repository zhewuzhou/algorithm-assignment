package zhewuzhou.me.leetcode120

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

fun connectR(root: Node?): Node? {
    if (root != null) {
        connectNeighbors(root.left, root.right)
    }
    return root

}

fun connectNeighbors(lhs: Node?, rhs: Node?) {
    if (lhs == null || rhs == null) return
    connectNeighbors(lhs.left, lhs.right)
    connectNeighbors(rhs.left, rhs.right)
    connectNeighbors(lhs.right, rhs.left)
}

fun connect(root: Node?): Node? {
    var curRoot = root
    while (curRoot != null) {
        val dummyHead = Node(-1)
        var curr: Node? = dummyHead
        while (curRoot != null) {
            if (curRoot.left != null) {
                curr?.next = curRoot.left
                curr = curr?.next
            }
            if (curRoot.right != null) {
                curr?.next = curRoot.right
                curr = curr?.next
            }
            curRoot = curRoot.next
        }
        curRoot = dummyHead.next
    }
    return root
}

