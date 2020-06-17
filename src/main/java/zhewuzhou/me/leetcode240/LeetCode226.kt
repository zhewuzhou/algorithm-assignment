package zhewuzhou.me.leetcode240

import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

fun invertTreeRecursive(root: TreeNode?): TreeNode? {
    if (root == null) return root
    val right = root.right
    val left = root.left
    root.right = left
    root.left = right
    invertTreeRecursive(left)
    invertTreeRecursive(right)
    return root
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return root
    val queue = LinkedList<TreeNode?>()
    queue.addFirst(root)
    while (queue.isNotEmpty()) {
        val n = queue.pop()
        val right = n?.right
        val left = n?.left
        n?.right = left
        n?.left = right
        if (left != null) {
            queue.add(left)
        }
        if (right != null) {
            queue.add(right)
        }
    }
    return root
}


