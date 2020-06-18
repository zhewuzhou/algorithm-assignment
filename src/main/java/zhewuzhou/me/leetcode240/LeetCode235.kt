package zhewuzhou.me.leetcode240

import zhewuzhou.me.leetcode100.TreeNode

//TODO: P or Q is root
fun lowestCommonAncestorEB(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return null
    if (find(q, p)) return q
    if (find(p, q)) return p
    return lowestCommonAncestorEB(root, findParent(root, p), findParent(root, q))
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    if (root === p || root === q) {
        return root
    }
    val l = lowestCommonAncestor(root.left, p, q)
    val r = lowestCommonAncestor(root.right, p, q)
    return if (l != null && r != null) {
        root
    } else l ?: r
}

fun lowestCommonAncestorE(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return null
    return if (root.`val` > p?.`val`!! && root.`val` > q?.`val`!!) {
        lowestCommonAncestorE(root.left, p, q)
    } else if (root.`val` < p.`val` && root.`val` < q?.`val`!!) {
        lowestCommonAncestorE(root.right, p, q)
    } else root
}

private fun find(root: TreeNode?, target: TreeNode?): Boolean {
    if (root?.`val` == target?.`val`) return true
    return when {
        root?.`val`!! > target?.`val`!! -> if (root.left == null) false else find(root.left, target)
        else -> if (root.right == null) false else find(root.right, target)
    }
}

private fun findParent(root: TreeNode?, target: TreeNode?): TreeNode? {
    if (root?.left?.`val` == target?.`val` || root?.right?.`val` == target?.`val`) {
        return root
    }
    if (root?.`val`!! > target?.`val`!!) {
        return findParent(root.left, target)
    }
    return findParent(root.right, target)
}
