package zhewuzhou.me.leetcode260

import zhewuzhou.me.leetcode100.TreeNode

fun binaryTreePathsS(root: TreeNode?): List<String> {
    if (root == null) return listOf()
    if (root.left == null && root.right == null) return listOf(root.`val`.toString())
    val path = mutableListOf<String>()
    if (root.left != null) {
        path.addAll(binaryTreePaths(root.left).map { "${root.`val`.toString()}->$it" })
    }
    if (root.right != null) {
        path.addAll(binaryTreePaths(root.right).map { "${root.`val`.toString()}->$it" })
    }
    return path
}

fun binaryTreePaths(root: TreeNode?): List<String> {
    fun searchPaths(node: TreeNode?, cur: String, res: MutableList<String>) {
        if (node != null && node.right == null && node.left == null) {
            res.add(cur)
            return
        }
        if (node?.right != null) {
            searchPaths(node.right, "$cur->${node.right!!.`val`}", res)
        }
        if (node?.left != null) {
            searchPaths(node.left, "$cur->${node.left!!.`val`}", res)
        }
    }

    val result = mutableListOf<String>()
    if (root == null) return listOf()
    searchPaths(root, "${root.`val`}", result)
    return result
}
