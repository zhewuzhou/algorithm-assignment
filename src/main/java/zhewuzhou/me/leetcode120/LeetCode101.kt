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
