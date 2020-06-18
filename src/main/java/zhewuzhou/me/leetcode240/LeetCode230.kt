package zhewuzhou.me.leetcode240

import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var order = 0
    val stack = Stack<TreeNode>()
    var p = root
    while (!stack.isEmpty() || p != null) {
        p = if (p != null) {
            stack.push(p)
            p.left
        } else {
            val node = stack.pop()
            order += 1
            if (order == k) {
                return node.`val`
            }
            node.right
        }
    }
    return 0
}

