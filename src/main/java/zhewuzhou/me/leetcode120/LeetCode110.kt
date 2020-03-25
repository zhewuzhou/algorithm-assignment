package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.TreeNode

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    if (Math.abs(getDepth(root?.left) - getDepth(root?.right)) > 1) return false
    return isBalanced(root?.left) && isBalanced(root?.right)
}

private fun getDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return when {
        (root.left != null && root.right != null) -> Math.max(getDepth(root.left), getDepth(root.right)) + 1
        (root.left != null && root.right == null) -> getDepth(root.left) + 1
        (root.left == null && root.right != null) -> getDepth(root.right) + 1
        else -> 1
    }
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return when {
        (root.left != null && root.right != null) -> Math.min(minDepth(root.left), minDepth(root.right)) + 1
        (root.left != null && root.right == null) -> minDepth(root.left) + 1
        (root.left == null && root.right != null) -> minDepth(root.right) + 1
        else -> 1
    }
}

fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null || root.`val` > sum) return false
    if (root.`val` == sum && root.left == null && root.right == null) return true
    return hasPathSum(root.left, sum - root.`val`)
        || hasPathSum(root.right, sum - root.`val`)
}
