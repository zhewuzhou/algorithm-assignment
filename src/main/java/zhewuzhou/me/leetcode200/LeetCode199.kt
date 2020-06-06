package zhewuzhou.me.leetcode200

import zhewuzhou.me.leetcode100.TreeNode

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) return listOf()
    val result = mutableListOf(root.`val`)
    var level: List<TreeNode?> = mutableListOf(root)
    while (level.isNotEmpty()) {
        val nextLevel = mutableListOf<TreeNode?>()
        for (n in level) {
            if (n?.left != null) {
                nextLevel.add(n.left)
            }
            if (n?.right != null) {
                nextLevel.add(n.right)
            }
        }
        if (nextLevel.isNotEmpty()) {
            result.add(nextLevel.last()!!.`val`)
        }
        level = nextLevel
    }
    return result
}
