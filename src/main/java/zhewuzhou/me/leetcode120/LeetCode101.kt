package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    return isSymmetricRecursive(root?.left, root?.right)
}


fun isSymmetricRecursive(lhs: TreeNode?, rhs: TreeNode?): Boolean {
    if (lhs == null && rhs == null) return true
    if (lhs == null || rhs == null) return false
    if (lhs.`val` == rhs.`val`) {
        return isSymmetricRecursive(lhs.right, rhs.left) && isSymmetricRecursive(lhs.left, rhs.right)
    }
    return false
}
