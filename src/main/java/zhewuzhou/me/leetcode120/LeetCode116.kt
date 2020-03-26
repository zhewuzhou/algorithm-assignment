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


