package zhewuzhou.me.leetcode100

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    val stack: Stack<TreeNode> = Stack<TreeNode>()
    var cur = root
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.add(cur)
            cur = cur.left
        }
        cur = stack.pop()
        list.add(cur.`val`)
        cur = cur.right
    }
    return list
}
