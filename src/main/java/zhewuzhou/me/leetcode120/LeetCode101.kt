package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

fun isSymmetric(root: TreeNode?): Boolean {
    val lhs = root?.left
    val rhs = root?.right
    if (lhs == null && rhs == null) return true
    if (lhs == null || rhs == null) return false
    return isSymmetric(root.left, root.right)
}

fun isSymmetric(lhs: TreeNode?, rhs: TreeNode?): Boolean {
    val ls: Stack<TreeNode> = Stack<TreeNode>()
    val rs: Stack<TreeNode> = Stack<TreeNode>()
    var lc = lhs
    var rc = rhs
    while ((lc != null || ls.isNotEmpty()) || (rc != null || rs.isNotEmpty())) {
        if (lc?.`val` != rc?.`val`) return false
        while (lc != null) {
            ls.add(lc)
            lc = lc.left
        }
        while (rc != null) {
            rs.add(rc)
            rc = rc.right
        }
        if (ls.map { it.`val` } != rs.map { it.`val` }) return false
        lc = ls.pop()
        rc = rs.pop()
        lc = lc.right
        rc = rc.left
    }
    return true
}

fun isSymmetricRecursive(lhs: TreeNode?, rhs: TreeNode?): Boolean {
    if (lhs == null && rhs == null) return true
    if (lhs == null || rhs == null) return false
    if (lhs.`val` == rhs.`val`) {
        return isSymmetricRecursive(lhs.right, rhs.left) && isSymmetricRecursive(lhs.left, rhs.right)
    }
    return false
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    return travel(root, false)
}

private fun travel(root: TreeNode?, isZigZag: Boolean): List<List<Int>> {
    if (root == null) return listOf()
    var zigzag = isZigZag
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    val res = mutableListOf(listOf(root.`val`))
    while (queue.isNotEmpty()) {
        val level = mutableListOf<TreeNode>()
        while (queue.isNotEmpty()) {
            val ele = queue.pop()
            if (ele.left != null) {
                level.add(ele.left!!)
            }
            if (ele.right != null) {
                level.add(ele.right!!)
            }
        }
        if (level.isNotEmpty()) {
            if (isZigZag && zigzag) {
                res.add(level.reversed().map { it.`val` })
            } else {
                res.add(level.map { it.`val` })
            }
            queue.addAll(level)
        }
        if (isZigZag) zigzag = !zigzag
    }
    return res
}

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    return travel(root, true)
}
