package zhewuzhou.me.leetcode240

import zhewuzhou.me.leetcode100.TreeNode

fun countNodes(root: TreeNode?): Int {
    val lh = heightL(root)
    val rh = heightR(root)
    return if (lh == rh) {
        1.shl(lh) - 1
    } else {
        1 + countNodes(root?.left) + countNodes(root?.right)
    }
}

private fun heightL(root: TreeNode?): Int {
    var depth = 0
    var cur = root
    while (cur != null) {
        depth += 1
        cur = cur.left
    }
    return depth
}

private fun heightR(root: TreeNode?): Int {
    var depth = 0
    var cur = root
    while (cur != null) {
        depth += 1
        cur = cur.right
    }
    return depth
}
